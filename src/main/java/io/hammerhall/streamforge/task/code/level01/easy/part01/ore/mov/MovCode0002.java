package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovCode0002}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
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
}
