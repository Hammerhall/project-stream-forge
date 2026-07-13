package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Посчитать количество фильмов, вышедших в годы, которые не являются високосными.")
public class MovCode0004 extends Base {

    /**
     * Задание: Посчитать количество фильмов, вышедших в годы, которые не являются високосными.
     * <p>
     * Описание: необходимо посчитать, сколько фильмов из исходной коллекции вышло в годы,
     * не являющиеся високосными. Год, делящийся на 4, не всегда является високосным —
     * воспользуйтесь стандартным Java API для точной проверки.
     *
     * @param movies коллекция фильмов
     * @return количество фильмов, вышедших в невисокосные годы
     */
    public long task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        long nonLeapYearMoviesCount = task(movies);

        assertTrue(nonLeapYearMoviesCount > 0);
        assertTrue(nonLeapYearMoviesCount <= movies.size());
        assertEquals(0L, task(List.of()));

        System.out.println(nonLeapYearMoviesCount);
    }
}
