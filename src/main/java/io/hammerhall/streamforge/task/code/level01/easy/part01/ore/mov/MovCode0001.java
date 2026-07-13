package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

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

@DisplayName("Задание: Получить список всех названий фильмов.")
public class MovCode0001 extends Base {

    /**
     * Задание: Получить список всех названий фильмов.
     * <p>
     * Описание: необходимо преобразовать коллекцию фильмов в список строк,
     * где каждая строка — это название фильма. Порядок названий в результате
     * соответствует порядку обхода исходной коллекции.
     *
     * @param movies коллекция фильмов
     * @return список названий всех фильмов
     */
    public List<String> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        List<String> movieTitles = task(movies);

        assertNotNull(movieTitles);
        assertEquals(movies.size(), movieTitles.size());
        assertTrue(movieTitles.stream().allMatch(title -> title != null && !title.isBlank()));

        movieTitles.forEach(System.out::println);
    }
}