package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти самый ранний фильм в базе.")
public class MovCode0011 extends Base {

    /**
     * Задание: Найти самый ранний фильм в базе.
     * <p>
     * Описание: необходимо найти фильм с минимальным годом выхода среди всех
     * фильмов из исходной коллекции. Если несколько фильмов имеют одинаковый
     * минимальный год, допускается вернуть любой из них. Если коллекция фильмов
     * пустая, результатом должен быть Optional.empty().
     *
     * @param movies коллекция фильмов
     * @return Optional с самым ранним фильмом или Optional.empty(),
     * если коллекция пуста
     */
    public Optional<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        Optional<Movie> earliestMovie = task(movies);

        assertNotNull(earliestMovie);
        assertTrue(earliestMovie.isPresent());

        Movie earliestMovieValue = earliestMovie.orElseThrow();

        assertNotNull(earliestMovieValue.getTitle());
        assertFalse(earliestMovieValue.getTitle().isBlank());
        assertTrue(earliestMovieValue.getYear() > 0);
        assertTrue(movies.stream()
                .allMatch(movie -> movie.getYear() >= earliestMovieValue.getYear()));
        assertTrue(task(List.of()).isEmpty());

        earliestMovie.ifPresent(System.out::println);
    }
}
