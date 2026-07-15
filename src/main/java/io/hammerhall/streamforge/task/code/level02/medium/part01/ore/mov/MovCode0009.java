package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить список всех фильмов, отсортированных по году выхода.")
public class MovCode0009 extends Base {

    /**
     * Задание: Получить список всех фильмов, отсортированных по году выхода.
     * <p>
     * Описание: необходимо отсортировать коллекцию фильмов по году выхода в порядке
     * возрастания — от более старых фильмов к более новым.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, отсортированных по году выхода по возрастанию
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();
        List<Movie> list = movies.stream().toList().subList(0, 1000);
        List<Movie> moviesSortedByYear = task(list);

        assertNotNull(moviesSortedByYear);
        assertEquals(list.size(), moviesSortedByYear.size());
        assertTrue(moviesSortedByYear.containsAll(list));
        IntStream.range(1, moviesSortedByYear.size())
                .mapToObj(i -> moviesSortedByYear.get(i - 1).getYear() <= moviesSortedByYear.get(i).getYear())
                .forEach(Assertions::assertTrue);

        moviesSortedByYear.forEach(System.out::println);
    }
}
