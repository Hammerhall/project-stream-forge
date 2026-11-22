package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0005}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Справочник почтальона")
public class WldCode0005 extends Base {

    /**
     * Задание: Получить список всех городов мира.
     * <p>
     * Описание: необходимо собрать все города, находящиеся в каждой стране,
     * и вернуть их единым плоским списком.
     * <p>
     * Порядок городов в результате соответствует порядку обхода стран, а внутри
     * страны — порядку её списка городов.
     *
     * @param countries список стран мира
     * @return список всех городов мира
     */
    public List<City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
