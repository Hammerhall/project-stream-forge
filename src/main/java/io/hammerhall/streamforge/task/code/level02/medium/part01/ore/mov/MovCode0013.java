package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Проверить, есть ли в базе хотя бы один фильм указанного жанра.")
public class MovCode0013 extends Base {

    /**
     * Задание: Проверить, есть ли в базе хотя бы один фильм указанного жанра.
     * <p>
     * Описание: необходимо проверить, существует ли среди всех фильмов хотя бы один,
     * у которого в списке жанров присутствует указанный жанр. Сравнение выполняется
     * по названию жанра.
     *
     * @param movies    коллекция фильмов
     * @param genreName название жанра, наличие которого нужно проверить
     * @return true, если в базе есть хотя бы один фильм указанного жанра, иначе false
     */
    public boolean task(@NonNull Collection<Movie> movies, @NonNull String genreName) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        String genreName = "Drama";

        boolean hasMoviesWithGenre = task(movies, genreName);

        assertTrue(hasMoviesWithGenre);
        assertFalse(task(movies, "__unknown_genre__"));
        assertFalse(task(movies, ""));

        System.out.println(hasMoviesWithGenre);
    }
}
