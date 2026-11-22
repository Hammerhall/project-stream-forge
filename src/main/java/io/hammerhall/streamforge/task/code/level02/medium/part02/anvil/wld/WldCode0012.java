package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0012}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Анкета визового центра")
public class WldCode0012 extends Base {

    /**
     * Задание: Отобрать страны по нескольким критериям одновременно.
     * <p>
     * Описание: результат содержит страны, одновременно удовлетворяющие
     * всем следующим критериям:
     * <p>
     * 1. численность населения строго больше 10 миллионов человек;
     * 2. континент — не Антарктида;
     * 3. выполняется хотя бы одно из двух дополнительных условий:
     * 3.1. площадь территории строго больше 500 000 кв. км;
     * 3.2. плотность населения строго больше 200 чел./кв. км
     * (при положительной площади).
     * <p>
     * Порядок стран в результате соответствует порядку исходного списка.
     *
     * @param countries список стран
     * @return список стран, удовлетворяющих условию отбора
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
