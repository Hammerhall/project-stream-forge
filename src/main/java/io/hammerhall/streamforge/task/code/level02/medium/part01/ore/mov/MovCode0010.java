package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить названия фильмов, отсортированные по году выхода от новых к старым.")
public class MovCode0010 extends Base {

    /**
     * Задание: Получить названия фильмов, упорядоченные по году выхода от новых к старым.
     * <p>
     * Описание: результатом является список названий всех фильмов из исходной коллекции,
     * отсортированных по убыванию года выхода: сначала идут названия самых новых фильмов,
     * затем — более старых.
     * <p>
     * Порядок названий фильмов с одинаковым годом выхода не регламентирован.
     *
     * @param movies коллекция фильмов
     * @return список названий фильмов в порядке убывания года выхода
     */
    public List<String> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        List<String> movieTitlesSortedByYearDesc = task(movies);

        assertNotNull(movieTitlesSortedByYearDesc);
        assertEquals(movies.size(), movieTitlesSortedByYearDesc.size());
        assertTrue(movieTitlesSortedByYearDesc.stream()
                .allMatch(title -> title != null && !title.isBlank()));

        movieTitlesSortedByYearDesc.forEach(System.out::println);
    }
}
