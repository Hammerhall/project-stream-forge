package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

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

@DisplayName("Задание: Найти все фильмы заданного режиссёра.")
public class MovCode0015 extends Base {

    /**
     * Задание: Найти все фильмы заданного режиссёра.
     * <p>
     * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те,
     * у которых среди режиссёров присутствует режиссёр с указанным именем.
     * Сравнение выполняется по имени режиссёра.
     *
     * @param movies       коллекция фильмов
     * @param directorName имя режиссёра, фильмы которого нужно найти
     * @return список фильмов указанного режиссёра
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, @NonNull String directorName) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        String directorName = "Steven Spielberg";

        List<Movie> moviesByDirector = task(movies, directorName);

        assertNotNull(moviesByDirector);
        assertFalse(moviesByDirector.isEmpty());
        assertTrue(moviesByDirector.size() <= movies.size());
        assertTrue(movies.containsAll(moviesByDirector));
        assertTrue(task(movies, "__unknown_director__").isEmpty());

        moviesByDirector.forEach(System.out::println);
    }
}
