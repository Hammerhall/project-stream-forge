package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Сгруппировать фильмы по году и перечислить их названия.")
public class MovCode0029 extends Base {

    /**
     * Задание: Сгруппировать фильмы по году и перечислить их названия.
     * <p>
     * Описание: необходимо сгруппировать фильмы по году выхода и для каждого года
     * получить список названий фильмов, вышедших в этот год. Итоговая карта должна
     * быть отсортирована по году в порядке возрастания.
     *
     * @param movies коллекция фильмов
     * @return отсортированная по году карта, где ключ — год выхода,
     * значение — список названий фильмов за этот год
     */
    public TreeMap<Integer, List<String>> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        TreeMap<Integer, List<String>> movieTitlesByYear = task(movies);

        assertNotNull(movieTitlesByYear);
        assertFalse(movieTitlesByYear.isEmpty());
        assertInstanceOf(TreeMap.class, movieTitlesByYear);
        assertTrue(movieTitlesByYear.keySet().stream()
                .allMatch(year -> year != null && year > 0));

        assertTrue(movieTitlesByYear.values().stream()
                .flatMap(Collection::stream)
                .allMatch(title -> title != null && !title.isBlank()));

        movieTitlesByYear.forEach((year, movieTitles) ->
                System.out.println(year + " : " + movieTitles));
    }
}
