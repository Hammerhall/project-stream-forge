package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить первые N фильмов из базы.")
public class MovCode0003 extends Base {

    /**
     * Задание: Получить первые N фильмов из базы.
     * <p>
     * Описание: необходимо получить первые N фильмов из исходной коллекции в порядке
     * её обхода. Если в коллекции меньше фильмов, чем указано в параметре limit,
     * необходимо вернуть все доступные фильмы.
     *
     * @param movies коллекция фильмов
     * @param limit  количество фильмов, которое нужно получить; если значение
     *               отрицательное, будет использовано 0
     * @return список из первых N фильмов исходной коллекции или всех фильмов,
     * если limit больше размера коллекции
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, int limit) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        int limit = 5;

        List<Movie> firstMovies = task(movies, limit);

        assertNotNull(firstMovies);
        assertEquals(Math.min(limit, movies.size()), firstMovies.size());
        assertTrue(task(movies, -1).isEmpty());
        assertEquals(movies.size(), task(movies, movies.size() + 100).size());

        firstMovies.forEach(System.out::println);
    }
}
