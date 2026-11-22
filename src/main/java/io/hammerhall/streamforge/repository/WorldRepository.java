package io.hammerhall.streamforge.repository;

import com.google.gson.Gson;
import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.domain.world.CountryLanguage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;
import lombok.Getter;

/**
 * In-memory store for the World dataset.
 *
 * <p>Data is loaded once, at construction time, from classpath resources generated
 * from the MySQL {@code world} sample database:
 * <ul>
 *     <li>{@code /world/countries.json}          — 239 countries (JSON array)</li>
 *     <li>{@code /world/cities.jsonl}            — 4079 cities (one JSON object per line)</li>
 *     <li>{@code /world/country_languages.jsonl} — 984 country-language rows</li>
 * </ul>
 *
 * <p>No database or framework is involved at runtime: the resources are plain text
 * parsed with Gson into the same in-memory maps the rest of the project relies on.
 * Foreign keys are kept by id ({@code city.countryCode}, {@code country.capital},
 * {@code countryLanguage.countryCode}) so that joins remain explicit Stream operations
 * rather than pre-resolved object graphs.
 */
@Getter
public class WorldRepository {

    private static final Gson GSON = new Gson();

    private static final String COUNTRIES_RESOURCE = "/world/countries.json";
    private static final String CITIES_RESOURCE = "/world/cities.jsonl";
    private static final String LANGUAGES_RESOURCE = "/world/country_languages.jsonl";

    private final Map<String, Country> countries;
    private final Map<Integer, City> cities;
    private final List<CountryLanguage> languages;
    private final Set<String> continents;

    public WorldRepository() {
        countries = loadCountries();
        cities = loadCitiesAndLink();
        languages = loadLanguagesAndLink();
        continents = extractContinents();
    }

    private Map<String, Country> loadCountries() {
        try (BufferedReader reader = open(COUNTRIES_RESOURCE)) {
            Country[] loaded = GSON.fromJson(reader, Country[].class);
            Map<String, Country> result = new HashMap<>();
            for (Country country : loaded) {
                result.put(country.getCode(), country);
            }
            return result;
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read " + COUNTRIES_RESOURCE, e);
        }
    }

    private Map<Integer, City> loadCitiesAndLink() {
        Map<Integer, City> result = new HashMap<>();
        forEachLine(CITIES_RESOURCE, City.class, city -> {
            result.put(city.getId(), city);
            Country country = countries.get(city.getCountryCode());
            if (country == null) {
                throw new IllegalStateException("City " + city.getId()
                        + " references unknown countryCode: " + city.getCountryCode());
            }
            country.getCities().add(city);
        });
        return result;
    }

    private List<CountryLanguage> loadLanguagesAndLink() {
        List<CountryLanguage> result = new ArrayList<>();
        forEachLine(LANGUAGES_RESOURCE, CountryLanguage.class, language -> {
            result.add(language);
            Country country = countries.get(language.getCountryCode());
            if (country == null) {
                throw new IllegalStateException("Language " + language.getLanguage()
                        + " references unknown countryCode: " + language.getCountryCode());
            }
            country.getLanguages().add(language);
        });
        return result;
    }

    private Set<String> extractContinents() {
        Set<String> result = new HashSet<>();
        for (Country country : countries.values()) {
            result.add(country.getContinent());
        }
        return result;
    }

    private static <T> void forEachLine(String resource, Class<T> type, Consumer<T> consumer) {
        try (BufferedReader reader = open(resource)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                consumer.accept(GSON.fromJson(line, type));
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read " + resource, e);
        }
    }

    private static BufferedReader open(String resource) {
        InputStream in = WorldRepository.class.getResourceAsStream(resource);
        if (in == null) {
            throw new IllegalStateException("Resource not found on classpath: " + resource);
        }
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
    }
}
