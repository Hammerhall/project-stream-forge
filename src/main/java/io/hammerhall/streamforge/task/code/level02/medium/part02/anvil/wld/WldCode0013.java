package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0013}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Стенд в школьном коридоре")
public class WldCode0013 extends Base {

    /**
     * Задание: Получить список стран, отсортированный сначала по континенту, затем по названию.
     * <p>
     * Описание: необходимо отсортировать страны в порядке возрастания:
     * сначала по названию континента (лексикографически), а среди стран
     * одного континента — по названию страны (лексикографически).
     *
     * @param countries список стран мира
     * @return список стран, отсортированный по континенту и названию
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
