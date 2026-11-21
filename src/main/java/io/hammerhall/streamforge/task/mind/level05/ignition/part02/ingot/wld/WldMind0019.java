package io.hammerhall.streamforge.task.mind.level05.ignition.part02.ingot.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldMind0019}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Ошибка переписчика")
public class WldMind0019 extends Base {

    /**
     * Задание: Найти страны, где сумма населения городов больше населения страны.
     * <p>
     * Описание: для каждой страны вычисляется суммарное население всех её
     * городов. Страна попадает в результат, если эта сумма строго больше
     * населения самой страны ({@code population}).
     * <p>
     * Порядок стран соответствует исходному списку. Для пустого списка стран
     * возвращается пустой список.
     *
     * @param countries список стран
     * @return список стран, у которых суммарное население городов больше
     * населения страны
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
