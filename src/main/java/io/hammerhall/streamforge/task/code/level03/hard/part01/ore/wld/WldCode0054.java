package io.hammerhall.streamforge.task.code.level03.hard.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Map;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0054}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Дипломатический бал")
public class WldCode0054 extends Base {

    /**
     * Задание: Найти столицу с наибольшей численностью населения на каждом континенте.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: столица страны определяется как город из списка городов страны,
     * идентификатор которого совпадает с {@code capital}. Необходимо для каждого
     * континента среди столиц его стран найти столицу с наибольшим населением.
     * Результат возвращается в виде ассоциативного массива, где ключ — название
     * континента, а значение — столица с наибольшим населением на этом континенте.
     * <p>
     * Страны, для которых столица не найдена среди их городов, не учитываются.
     * Если на континенте несколько столиц с одинаковым (максимальным) населением,
     * выбирается город, название которого идёт раньше в алфавитном порядке.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → столица с наибольшим населением»
     */
    public Map<String, City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
