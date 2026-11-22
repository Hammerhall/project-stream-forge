package io.hammerhall.streamforge.task.code.level03.hard.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Map;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0052}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Гонка градостроителей")
public class WldCode0052 extends Base {

    /**
     * Задание: Найти страну с максимальным количеством городов на каждом континенте.
     * <p>
     * Описание: необходимо для каждого континента определить страну, у которой
     * наибольшее количество городов. Результат возвращается в виде ассоциативного
     * массива, где ключ — название континента, а значение — страна этого
     * континента с максимальным числом городов.
     * <p>
     * Если на континенте несколько стран с одинаковым (максимальным) числом
     * городов, выбирается страна, название которой идёт раньше в алфавитном
     * порядке.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → страна с наибольшим числом городов»
     */
    public Map<String, Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
