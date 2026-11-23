package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovCode0003}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
@Title("Витрина видеосалона")
public class MovCode0003 extends Base {

    /**
     * Задание: Получить первые N фильмов из базы.
     * <p>
     * Описание: необходимо получить первые N фильмов из исходной коллекции в порядке
     * её обхода. Если в коллекции меньше фильмов, чем указано в параметре limit,
     * необходимо вернуть все доступные фильмы.
     *
     * @param movies коллекция фильмов
     * @param limit  количество фильмов, которое нужно получить; если значение
     *               отрицательное, будет использовано 0
     * @return список из первых N фильмов исходной коллекции или всех фильмов,
     * если limit больше размера коллекции
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, int limit) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
