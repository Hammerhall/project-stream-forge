package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.Map;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Посчитать количество фильмов для каждого года.")
public class MovCode0023 extends Base {

    /**
     * Задание: Посчитать количество фильмов для каждого года.
     * <p>
     * Описание: необходимо сгруппировать фильмы по году выхода и посчитать,
     * сколько фильмов вышло в каждом году. Ключом итоговой Map является год
     * выхода фильма, а значением — количество фильмов, вышедших в этот год.
     *
     * @param movies коллекция фильмов
     * @return Map, где ключ — год выхода, значение — количество фильмов за этот год
     */
    public Map<Integer, Long> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        Map<Integer, Long> movieCountByYear = task(movies);

        assertNotNull(movieCountByYear);
        assertFalse(movieCountByYear.isEmpty());
        assertTrue(movieCountByYear.keySet().stream()
                .allMatch(year -> year != null && year > 0));

        assertTrue(movieCountByYear.values().stream()
                .allMatch(count -> count != null && count > 0));

        movieCountByYear.forEach((year, movieCount) -> System.out.println(year + " " + movieCount));
    }
}
