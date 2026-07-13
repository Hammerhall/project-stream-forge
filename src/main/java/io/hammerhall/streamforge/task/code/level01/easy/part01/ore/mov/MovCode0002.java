package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти все фильмы, вышедшие после указанного года.")
public class MovCode0002 extends Base {

    /**
     * Задание: Найти все фильмы, вышедшие после указанного года.
     * <p>
     * Описание: из коллекции фильмов нужно получить те, год выхода которых
     * строго больше указанного. Порядок результата соответствует порядку
     * обхода исходной коллекции.
     *
     * @param movies     коллекция фильмов
     * @param targetYear граничный год; учитываются фильмы строго новее него
     * @return список фильмов, вышедших после указанного года
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, int targetYear) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        int targetYear = 2005;

        List<Movie> moviesAfterYear = task(movies, targetYear);

        assertNotNull(moviesAfterYear);
        assertFalse(moviesAfterYear.isEmpty());
        assertTrue(movies.containsAll(moviesAfterYear));

        moviesAfterYear.forEach(System.out::println);
    }
}
