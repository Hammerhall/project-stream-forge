package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0038}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Региональные саммиты")
public class WldCode0038 extends Base {

    /**
     * Задание: Для каждого континента построить список стран с населением более 50 миллионов.
     * <p>
     * Описание: необходимо сгруппировать страны по континентам, и для каждого
     * континента отобрать только те страны, население которых строго больше
     * 50 миллионов. Результат возвращается в виде ассоциативного массива, где
     * ключ — название континента, а значение — список подходящих стран.
     * Континенты, на которых нет стран с населением более 50 миллионов,
     * представлены в результате пустым списком.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → список стран с населением > 50 млн»
     */
    public Map<String, List<Country>> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
