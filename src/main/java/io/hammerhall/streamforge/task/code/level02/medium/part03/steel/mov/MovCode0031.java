package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти год, в котором вышло больше всего фильмов.")
public class MovCode0031 extends Base {

    /**
     * Задание: Найти год, в котором вышло больше всего фильмов.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: необходимо определить год с наибольшим количеством вышедших фильмов.
     * Если несколько лет имеют одинаковое максимальное количество фильмов,
     * результатом должен стать наиболее поздний из таких годов.
     *
     * @param movies коллекция фильмов
     * @return год и количество вышедших в нём фильмов
     * @throws NoSuchElementException если коллекция фильмов пустая
     */
    public YearMovieCount task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    /**
     * Год и количество фильмов, выпущенных в этом году.
     *
     * @param year       год выхода фильмов
     * @param movieCount количество фильмов за этот год
     */
    record YearMovieCount(int year, long movieCount) {

        @Override
        public String toString() {
            return "Год: %d | Количество фильмов: %d".formatted(year, movieCount);
        }
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        YearMovieCount yearMovieCount = task(movies);

        assertNotNull(yearMovieCount);
        assertTrue(yearMovieCount.year() > 0);
        assertTrue(yearMovieCount.movieCount() > 0);
        assertThrows(NoSuchElementException.class, () -> task(List.of()));

        Movie any = movies.iterator().next();
        YearMovieCount single = task(List.of(any));
        assertEquals(any.getYear(), single.year());
        assertEquals(1L, single.movieCount());

        System.out.println(yearMovieCount);
    }
}
