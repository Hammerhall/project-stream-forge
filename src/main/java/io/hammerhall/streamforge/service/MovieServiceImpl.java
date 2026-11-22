package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.movie.*;
import io.hammerhall.streamforge.repository.MovieRepository;
import java.util.*;

public class MovieServiceImpl implements MovieService {

    private final Map<Integer, Movie> movies;
    private final Map<Integer, Genre> genres;
    private final Map<Integer, Director> directors;
    private final Map<Integer, Actor> actors;
    private final List<Role> roles;
    private final List<DirectorGenre> directorGenres;

    public MovieServiceImpl(MovieRepository movieRepository) {
        movies = movieRepository.getMovies();
        genres = movieRepository.getGenres();
        directors = movieRepository.getDirectors();
        actors = movieRepository.getActors();
        roles = movieRepository.getRoles();
        directorGenres = movieRepository.getDirectorGenres();
    }

    @Override
    public Collection<Movie> findAllMovies() {
        return Collections.unmodifiableCollection(movies.values());
    }

    @Override
    public Collection<Genre> findAllGenres() {
        return Collections.unmodifiableCollection(genres.values());
    }

    @Override
    public Collection<Director> findAllDirectors() {
        return Collections.unmodifiableCollection(directors.values());
    }

    @Override
    public Collection<Actor> findAllActors() {
        return Collections.unmodifiableCollection(actors.values());
    }

    @Override
    public Collection<Role> findAllRoles() {
        return Collections.unmodifiableCollection(roles);
    }

    @Override
    public Collection<DirectorGenre> findAllDirectorGenres() {
        return Collections.unmodifiableCollection(directorGenres);
    }
}
