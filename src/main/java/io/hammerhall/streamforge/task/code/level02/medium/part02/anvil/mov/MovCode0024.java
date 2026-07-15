package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@DisplayName("Задание: Собрать список примечательных фильмов.")
public class MovCode0024 extends Base {

    /**
     * Задание: Собрать список примечательных фильмов.
     * <p>
     * Описание: по переданной коллекции фильмов необходимо собрать список,
     * включающий:
     * 1. самый ранний по году выхода фильм;
     * 2. самый поздний по году выхода фильм;
     * 3. фильм с наибольшим числом жанров.
     * <p>
     * Если какой-либо из фильмов определить невозможно (например, коллекция пуста),
     * он в результат не добавляется. Повторяющиеся фильмы в результате не дублируются.
     * Для пустой коллекции возвращается пустой список.
     *
     * @param movies коллекция фильмов
     * @return список примечательных фильмов без повторов; пустой список, если их нет
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        List<Movie> result = task(movies);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), result.stream().distinct().count());

        int minYear = movies.stream().mapToInt(Movie::getYear).min().orElseThrow();
        int maxYear = movies.stream().mapToInt(Movie::getYear).max().orElseThrow();
        assertTrue(result.stream().anyMatch(movie -> movie.getYear() == minYear));
        assertTrue(result.stream().anyMatch(movie -> movie.getYear() == maxYear));

        assertTrue(task(List.of()).isEmpty());

        result.forEach(System.out::println);
    }
}
