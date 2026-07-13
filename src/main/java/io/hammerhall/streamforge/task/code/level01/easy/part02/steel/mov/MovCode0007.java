package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти все фильмы, у которых больше одного жанра.")
public class MovCode0007 extends Base {

    /**
     * Задание: Найти все фильмы, у которых больше одного жанра.
     * <p>
     * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те фильмы,
     * у которых количество жанров строго больше одного.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, у которых строго больше одного жанра
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();
        Random random = new Random();
        List<Movie> subMovies = movies.stream().toList().subList(0, random.nextInt(100, 1000));
        List<Movie> moviesWithMultipleGenres = task(subMovies);

        assertNotNull(moviesWithMultipleGenres);
        assertFalse(moviesWithMultipleGenres.isEmpty());
        assertTrue(moviesWithMultipleGenres.size() <= subMovies.size());
        assertTrue(movies.containsAll(moviesWithMultipleGenres));

        moviesWithMultipleGenres.forEach(System.out::println);
    }
}
