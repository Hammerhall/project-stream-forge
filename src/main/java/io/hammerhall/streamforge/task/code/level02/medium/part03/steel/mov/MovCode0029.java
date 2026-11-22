package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovCode0029}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
@Title("Подшивка киножурнала")
public class MovCode0029 extends Base {

    /**
     * Задание: Сгруппировать фильмы по году и перечислить их названия.
     * <p>
     * Описание: необходимо сгруппировать фильмы по году выхода и для каждого года
     * получить список названий фильмов, вышедших в этот год. Итоговая карта должна
     * быть отсортирована по году в порядке возрастания.
     *
     * @param movies коллекция фильмов
     * @return отсортированная по году карта, где ключ — год выхода,
     * значение — список названий фильмов за этот год
     */
    public TreeMap<Integer, List<String>> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
