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

@DisplayName("Задание: Найти все фильмы, у которых больше одного режиссёра.")
public class MovCode0008 extends Base {

    /**
     * Задание: Найти все фильмы, у которых больше одного режиссёра.
     * <p>
     * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те фильмы,
     * у которых количество режиссёров строго больше одного.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, у которых строго больше одного режиссёра
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();
        Random random = new Random();
        List<Movie> subMovies = movies.stream().toList().subList(0, random.nextInt(100, 1000));
        List<Movie> moviesWithMultipleDirectors = task(subMovies);

        assertNotNull(moviesWithMultipleDirectors);
        assertFalse(moviesWithMultipleDirectors.isEmpty());
        assertTrue(moviesWithMultipleDirectors.size() <= subMovies.size());
        assertTrue(movies.containsAll(moviesWithMultipleDirectors));

        moviesWithMultipleDirectors.forEach(System.out::println);
    }
}
