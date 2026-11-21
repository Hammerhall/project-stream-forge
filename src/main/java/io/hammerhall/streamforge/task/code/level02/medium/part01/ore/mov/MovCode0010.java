package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Афиша на стене фойе")
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
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0010");

        Collection<Movie> movies = movies();

        task(movies).stream().limit(20).forEach(IO::println);
    }
}
