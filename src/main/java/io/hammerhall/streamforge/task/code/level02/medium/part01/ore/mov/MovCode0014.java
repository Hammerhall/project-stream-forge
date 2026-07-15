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

@DisplayName("Задание: Найти все фильмы заданного жанра.")
public class MovCode0014 extends Base {

    /**
     * Задание: Найти все фильмы заданного жанра.
     * <p>
     * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те,
     * у которых среди жанров присутствует жанр с указанным названием.
     * Сравнение выполняется по названию жанра.
     *
     * @param movies    коллекция фильмов
     * @param genreName название жанра, фильмы которого нужно найти
     * @return список фильмов указанного жанра
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, @NonNull String genreName) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        String genreName = "Drama";
        List<Movie> list = movies.stream().toList().subList(0, 1000);
        List<Movie> moviesByGenre = task(list, genreName);

        assertNotNull(moviesByGenre);
        assertFalse(moviesByGenre.isEmpty());
        assertTrue(moviesByGenre.size() <= list.size());
        assertTrue(movies.containsAll(moviesByGenre));
        assertTrue(task(movies, "__unknown_genre__").isEmpty());

        moviesByGenre.forEach(System.out::println);
    }
}
