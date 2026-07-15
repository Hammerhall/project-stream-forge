package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти количество фильмов каждого режиссёра.")
public class MovCode0022 extends Base {

    /**
     * Задание: Найти количество фильмов каждого режиссёра.
     * <p>
     * Описание: необходимо подсчитать, со сколькими фильмами связан каждый режиссёр.
     * Результирующая карта должна быть отсортирована по имени режиссёра
     * в алфавитном порядке.
     *
     * @param movies коллекция фильмов
     * @return отсортированная по имени карта, где ключ — имя режиссёра,
     * значение — количество его фильмов
     */
    public TreeMap<String, Long> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        TreeMap<String, Long> movieCountByDirectorName = task(movies);

        assertNotNull(movieCountByDirectorName);
        assertFalse(movieCountByDirectorName.isEmpty());
        assertInstanceOf(TreeMap.class, movieCountByDirectorName);

        assertTrue(movieCountByDirectorName.values().stream().allMatch(c -> c != null && c > 0));
        assertEquals(movieCountByDirectorName.keySet().stream().sorted().toList(), new ArrayList<>(movieCountByDirectorName.keySet()));

        movieCountByDirectorName.forEach((directorName, movieCount) ->
                System.out.printf("%-25s %d%n", directorName, movieCount));
    }
}
