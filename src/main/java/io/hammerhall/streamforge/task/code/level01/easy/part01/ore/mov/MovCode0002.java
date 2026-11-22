package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

@Title("Новинки проката")
public class MovCode0002 extends Base {

    /**
     * Задание: Найти все фильмы, вышедшие после указанного года.
     * <p>
     * Описание: из коллекции фильмов нужно получить те, год выхода которых
     * строго больше указанного. Порядок результата соответствует порядку
     * обхода исходной коллекции.
     *
     * @param movies     коллекция фильмов
     * @param targetYear граничный год; учитываются фильмы строго новее него
     * @return список фильмов, вышедших после указанного года
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, int targetYear) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    void main() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0002");
        task(movies(), 2005).stream().limit(20).forEach(IO::println);
    }
}
