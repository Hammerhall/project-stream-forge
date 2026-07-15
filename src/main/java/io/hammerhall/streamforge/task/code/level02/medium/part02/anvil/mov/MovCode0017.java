package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

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

@DisplayName("Задание: Получить список названий всех уникальных жанров, отсортированный по алфавиту.")
public class MovCode0017 extends Base {

    /**
     * Задание: Получить список названий всех уникальных жанров, отсортированный по алфавиту.
     * <p>
     * Описание: необходимо собрать названия всех жанров, встречающихся в коллекции фильмов,
     * исключить дубликаты и вернуть итоговый список в алфавитном порядке.
     *
     * @param movies коллекция фильмов
     * @return список уникальных названий жанров, отсортированный по алфавиту
     */
    public List<String> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        List<String> uniqueGenreNames = task(movies);

        assertNotNull(uniqueGenreNames);
        assertFalse(uniqueGenreNames.isEmpty());
        assertTrue(uniqueGenreNames.stream().allMatch(name -> name != null && !name.isBlank()));

        uniqueGenreNames.forEach(System.out::println);
    }
}
