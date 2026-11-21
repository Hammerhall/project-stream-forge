package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Optional;
import lombok.NonNull;

@Title("Долгожданная премьера")
public class MovCode0005 extends Base {

    /**
     * Задание: Найти первый фильм, вышедший после указанного года.
     * <p>
     * Описание: необходимо отфильтровать фильмы, оставив те, у которых год выхода
     * строго больше {@code targetYear}, и вернуть первый из них в порядке обхода
     * исходной коллекции.
     *
     * @param movies     коллекция фильмов
     * @param targetYear пороговый год; в результат попадают фильмы с годом строго больше
     * @return Optional с первым (в порядке обхода) фильмом, вышедшим после
     * {@code targetYear}, или {@code Optional.empty()}, если такого фильма нет
     */
    public Optional<Movie> task(@NonNull Collection<Movie> movies, int targetYear) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    void main() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0005");
        task(movies(), 2000).ifPresentOrElse(IO::println, () -> IO.println("Фильм не найден"));
    }
}
