package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.wld;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0026}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Конверты в посольства")
public class WldCode0026 extends Base {

    /**
     * Задание: Сопоставить странам их города-столицы.
     * <p>
     * Описание: результат — список городов-столиц: по одному городу на каждую страну,
     * у которой столица нашлась, в порядке стран входной коллекции. Столица страны —
     * город, идентификатор которого ({@code City.getId()}) равен значению {@code capital}
     * этой страны. Столица ищется среди городов всех стран входа, а не только в списке
     * городов самой страны: город с этим идентификатором может лежать в списке другой страны.
     * <p>
     * Страна, у которой столица не указана ({@code capital} равен {@code null}), и страна,
     * для которой города с таким идентификатором во входе нет, в результат ничего не дают.
     * Идентификаторы городов во входе не повторяются. Для пустой коллекции результат пуст.
     *
     * @param countries список стран
     * @return список городов-столиц, найденных по идентификатору
     */
    public List<City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
