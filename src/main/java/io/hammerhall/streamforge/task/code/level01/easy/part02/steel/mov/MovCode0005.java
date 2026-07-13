package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.Optional;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти первый фильм, вышедший после указанного года.")
public class MovCode0005 extends Base {

    /**
     * Задание: Найти первый фильм, вышедший после указанного года.
     * <p>
     * Описание: необходимо отфильтровать фильмы, оставив те, у которых год выхода
     * строго больше {@code targetYear}, и вернуть первый из них в порядке обхода
     * исходной коллекции.
     *
     * @param movies     коллекция фильмов
     * @param targetYear пороговый год; в результат попадают фильмы с годом строго больше
     * @return Optional с первым (в порядке обхода) фильмом, вышедшим после
     * {@code targetYear}, или {@code Optional.empty()}, если такого фильма нет
     */
    public Optional<Movie> task(@NonNull Collection<Movie> movies, int targetYear) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        int targetYear = 2000;

        Optional<Movie> firstMovieAfterYear = task(movies, targetYear);

        assertNotNull(firstMovieAfterYear);
        assertTrue(firstMovieAfterYear.isPresent());
        Optional<Movie> movieAfterFutureYear = task(movies, 3000);
        assertNotNull(movieAfterFutureYear);
        assertTrue(movieAfterFutureYear.isEmpty());

        firstMovieAfterYear.ifPresentOrElse(System.out::println, () -> System.out.println("Фильм не найден"));
    }
}
