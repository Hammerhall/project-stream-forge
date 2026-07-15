package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Сгруппировать фильмы по количеству жанров.")
public class MovCode0016 extends Base {

    /**
     * Задание: Сгруппировать фильмы по количеству жанров.
     * <p>
     * Описание: необходимо сгруппировать фильмы по количеству жанров, указанных
     * у каждого фильма. Ключом итоговой Map является количество жанров, а значением
     * — список фильмов, у которых ровно такое количество жанров.
     *
     * @param movies коллекция фильмов
     * @return Map, где ключ — количество жанров, значение — список фильмов
     * с таким количеством жанров
     */
    public Map<Integer, List<Movie>> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        Map<Integer, List<Movie>> moviesByGenreCount = task(movies);

        assertNotNull(moviesByGenreCount);
        assertFalse(moviesByGenreCount.isEmpty());
        assertTrue(moviesByGenreCount.containsKey(1));

        moviesByGenreCount.forEach((genreCount, moviesWithSameGenreCount) ->
                System.out.println(genreCount + " " + moviesWithSameGenreCount));
    }
}
