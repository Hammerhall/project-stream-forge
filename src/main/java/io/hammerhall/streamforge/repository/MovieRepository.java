package io.hammerhall.streamforge.repository;

import io.hammerhall.streamforge.domain.movie.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.zip.GZIPInputStream;
import lombok.Getter;

/**
 * In-memory store for the Movie dataset (normalized IMDb snapshot, years 1888–2008).
 *
 * <p>Data is loaded once, at construction time, from gzip-compressed TSV resources on the
 * classpath. The files are plain tab-separated text (one record per line, no quoting — the
 * data contains no tabs); they are committed gzipped purely to keep the repository small and
 * are decompressed on the fly with the JDK's {@link GZIPInputStream} — no third-party
 * dependency and no database is involved at runtime.
 *
 * <ul>
 *     <li>{@code genres.tsv.gz}            — 24-genre catalog ({@code id}, {@code name})</li>
 *     <li>{@code movies.tsv.gz}            — 388 269 movies</li>
 *     <li>{@code directors.tsv.gz}         — 86 880 directors</li>
 *     <li>{@code actors.tsv.gz}            — 817 718 actors</li>
 *     <li>{@code movies_directors.tsv.gz}  — movie↔director links</li>
 *     <li>{@code movies_genres.tsv.gz}     — movie↔genre links (by genre id)</li>
 *     <li>{@code directors_genres.tsv.gz}  — director genre-affinity rows</li>
 *     <li>{@code roles.tsv.gz}             — 3 431 966 acting credits</li>
 * </ul>
 *
 * <p>{@code Movie.genres} and {@code Movie.directors} are wired up at load time (preserving the
 * existing model). Actors, roles and director-genre affinities are exposed as flat collections
 * keyed by id, so that the corresponding joins remain explicit Stream operations.
 */
@Getter
public class MovieRepository {

	private static final String GENRES_RESOURCE = "/movies/genres.tsv.gz";
	private static final String MOVIES_RESOURCE = "/movies/movies.tsv.gz";
	private static final String DIRECTORS_RESOURCE = "/movies/directors.tsv.gz";
	private static final String ACTORS_RESOURCE = "/movies/actors.tsv.gz";
	private static final String MOVIES_DIRECTORS_RESOURCE = "/movies/movies_directors.tsv.gz";
	private static final String MOVIES_GENRES_RESOURCE = "/movies/movies_genres.tsv.gz";
	private static final String DIRECTORS_GENRES_RESOURCE = "/movies/directors_genres.tsv.gz";
	private static final String ROLES_RESOURCE = "/movies/roles.tsv.gz";

	private final Map<Integer, Movie> movies;
	private final Map<Integer, Genre> genres;
	private final Map<Integer, Director> directors;
	private final Map<Integer, Actor> actors;
	private final List<Role> roles;
	private final List<DirectorGenre> directorGenres;

	public MovieRepository() {
		genres = loadGenres();
		movies = loadMovies();
		directors = loadDirectors();
		actors = loadActors();
		linkMoviesDirectors();
		linkMoviesGenres();
		roles = loadRoles();
		directorGenres = loadDirectorGenres();
	}

	private Map<Integer, Genre> loadGenres() {
		Map<Integer, Genre> result = new HashMap<>();
		forEachRow(GENRES_RESOURCE, f ->
				result.put(Integer.parseInt(f[0]), new Genre(Integer.parseInt(f[0]), f[1])));
		return result;
	}

	private Map<Integer, Movie> loadMovies() {
		Map<Integer, Movie> result = new HashMap<>(1 << 19);
		forEachRow(MOVIES_RESOURCE, f -> {
			Movie m = new Movie();
			m.setId(Integer.parseInt(f[0]));
			m.setTitle(f[1]);
			m.setYear(f[2].isEmpty() ? 0 : Integer.parseInt(f[2]));
			m.setRank(parseRank(f.length > 3 ? f[3] : ""));
			result.put(m.getId(), m);
		});
		return result;
	}

	private Map<Integer, Director> loadDirectors() {
		Map<Integer, Director> result = new HashMap<>(1 << 17);
		forEachRow(DIRECTORS_RESOURCE, f -> {
			Director d = new Director();
			d.setId(Integer.parseInt(f[0]));
			String first = f.length > 1 ? f[1] : "";
			String last = f.length > 2 ? f[2] : "";
			d.setFirstName(first);
			d.setLastName(last);
			result.put(d.getId(), d);
		});
		return result;
	}

	private Map<Integer, Actor> loadActors() {
		Map<Integer, Actor> result = new HashMap<>(1 << 20);
		forEachRow(ACTORS_RESOURCE, f -> {
			Actor a = new Actor();
			a.setId(Integer.parseInt(f[0]));
			a.setFirstName(f.length > 1 ? f[1] : "");
			a.setLastName(f.length > 2 ? f[2] : "");
			a.setGender(f.length > 3 ? f[3] : "");
			result.put(a.getId(), a);
		});
		return result;
	}

	private void linkMoviesDirectors() {
		forEachRow(MOVIES_DIRECTORS_RESOURCE, f -> {
			Director d = directors.get(Integer.parseInt(f[0]));
			Movie m = movies.get(Integer.parseInt(f[1]));
			if (m != null && d != null) {
				m.getDirectors().add(d);
			}
		});
	}

	private void linkMoviesGenres() {
		forEachRow(MOVIES_GENRES_RESOURCE, f -> {
			Movie m = movies.get(Integer.parseInt(f[0]));
			Genre g = genres.get(Integer.parseInt(f[1]));
			if (m != null && g != null) {
				m.getGenres().add(g);
			}
		});
	}

	private List<Role> loadRoles() {
		List<Role> result = new ArrayList<>(1 << 22);
		forEachRow(ROLES_RESOURCE, f -> result.add(new Role(
				Integer.parseInt(f[0]), Integer.parseInt(f[1]), f.length > 2 ? f[2] : "")));
		return result;
	}

	private List<DirectorGenre> loadDirectorGenres() {
		List<DirectorGenre> result = new ArrayList<>(1 << 17);
		forEachRow(DIRECTORS_GENRES_RESOURCE, f -> result.add(new DirectorGenre(
				Integer.parseInt(f[0]), Integer.parseInt(f[1]),
				f.length > 2 && !f[2].isEmpty() ? Double.parseDouble(f[2]) : 0.0)));
		return result;
	}

	/** IMDb rank uses 0.0 as "no rating"; map it to {@code null}. */
	private static Double parseRank(String raw) {
		if (raw.isEmpty()) {
			return null;
		}
		double r = Double.parseDouble(raw);
		return r == 0.0 ? null : r;
	}

	private static void forEachRow(String resource, Consumer<String[]> consumer) {
		try (BufferedReader reader = open(resource)) {
			reader.readLine(); // header
			for (String line; (line = reader.readLine()) != null; ) {
				if (line.isEmpty()) {
					continue;
				}
				consumer.accept(line.split("\t", -1));
			}
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to read " + resource, e);
		}
	}

	private static BufferedReader open(String resource) {
		InputStream in = MovieRepository.class.getResourceAsStream(resource);
		if (in == null) {
			throw new IllegalStateException("Resource not found on classpath: " + resource);
		}
		try {
			return new BufferedReader(
					new InputStreamReader(new GZIPInputStream(in), StandardCharsets.UTF_8), 1 << 16);
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to open gzip resource " + resource, e);
		}
	}
}
