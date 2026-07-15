package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти название самого популярного жанра по количеству фильмов.")
public class MovCode0032 extends Base {

    /**
     * Задание: Найти название самого популярного жанра по количеству фильмов.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: необходимо определить жанр, который чаще всего встречается
     * в жанровых списках фильмов. Если несколько жанров имеют одинаковое количество
     * встреч, необходимо вернуть название жанра, которое идёт позже по алфавиту.
     *
     * @param movies коллекция фильмов
     * @return название самого популярного жанра
     * @throws NoSuchElementException если коллекция фильмов пустая
     *                                или не найдено ни одного жанра
     */
    public String task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        String mostPopularGenre = task(movies);

        assertNotNull(mostPopularGenre);
        assertFalse(mostPopularGenre.isBlank());

        // граница: пустой вход
        assertThrows(NoSuchElementException.class, () -> task(List.of()));

        System.out.println(mostPopularGenre);
    }
}
