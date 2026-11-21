package io.hammerhall.streamforge.task.mind.level05.ignition.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovMind0022}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
@Title("Юбилейный вечер киноклуба")
public class MovMind0022 extends Base {

    /**
     * Задание: Получить «временной срез» базы — N самых ранних и N самых поздних фильмов.
     * <p>
     * Описание: фильмы упорядочиваются по году выхода. Из полученной последовательности
     * формируется результат: сначала идут N самых ранних фильмов в порядке возрастания
     * года, затем — N самых поздних фильмов в порядке убывания года (от новейшего к
     * старому).
     * <p>
     * Порядок фильмов одного года не задан: если граница части проходит по фильмам одного
     * года, в часть может попасть любой из них, и внутри года они могут идти в любом порядке.
     * <p>
     * Каждая часть содержит {@code limit} фильмов, а если фильмов меньше — все фильмы
     * коллекции. Если фильмов меньше, чем {@code 2 * limit}, один и тот же фильм может попасть
     * в обе части результата. Если коллекция пуста или {@code limit} не положителен —
     * возвращается пустой список.
     *
     * @param movies коллекция фильмов
     * @param limit  количество фильмов с каждого «края» хронологии
     * @return список из самых ранних (по возрастанию) и самых поздних (по убыванию) фильмов
     */
    public List<Movie> task(@NonNull Collection<Movie> movies, int limit) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
