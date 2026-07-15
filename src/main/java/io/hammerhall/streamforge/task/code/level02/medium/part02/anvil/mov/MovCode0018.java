package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

@DisplayName("Задание: Получить последние N уникальных имён режиссёров, отсортированных по алфавиту.")
public class MovCode0018 extends Base {

    /**
     * Задание: Получить последние N уникальных имён режиссёров в алфавитном порядке.
     * <p>
     * Описание: из всех фильмов извлекаются имена всех режиссёров.
     * Результатом является список не более чем из N уникальных имён,
     * отсортированных по алфавиту. Если список уникальных имён содержит
     * больше N элементов, в результат попадают только последние N позиций
     * отсортированного списка (элементы с конца). Если список уникальных
     * имён содержит N или менее элементов, результат содержит все уникальные
     * имена. Отрицательное значение limit трактуется как 0 и даёт пустой список.
     * <p>
     * Например, уникальные имена после сортировки: A, B, C, D, E; limit = 2.
     * Результат: D, E.
     *
     * @param movies коллекция фильмов
     * @param limit  максимальное количество возвращаемых имён;
     *               отрицательное значение даёт пустой результат
     * @return список последних N уникальных имён режиссёров в алфавитном порядке
     */
    public List<String> task(@NonNull Collection<Movie> movies, int limit) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        int limit = 10;

        List<String> lastUniqueDirectorNames = task(movies, limit);

        assertNotNull(lastUniqueDirectorNames);
        assertFalse(lastUniqueDirectorNames.isEmpty());
        assertTrue(lastUniqueDirectorNames.size() <= limit);
        assertTrue(lastUniqueDirectorNames.stream()
                .allMatch(name -> name != null && !name.isBlank()));

        IntStream.range(1, lastUniqueDirectorNames.size())
                .mapToObj(i -> lastUniqueDirectorNames.get(i - 1).compareTo(lastUniqueDirectorNames.get(i)) <= 0)
                .forEach(Assertions::assertTrue);

        assertTrue(task(movies, -1).isEmpty());

        lastUniqueDirectorNames.forEach(System.out::println);
    }
}
