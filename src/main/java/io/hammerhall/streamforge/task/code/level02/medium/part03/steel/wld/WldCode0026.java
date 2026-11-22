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
     * Описание: по всем городам строится индекс, позволяющий находить город
     * по его идентификатору. Затем для каждой страны из индекса извлекается
     * город, идентификатор которого совпадает с {@code capital} этой страны.
     * Столица ищется среди городов всех стран входа, а не только в списке городов
     * самой страны: город с этим идентификатором может лежать в списке другой страны.
     * <p>
     * Если для страны соответствующий город в данных отсутствует, такая страна
     * в результат не попадает. Порядок городов-столиц соответствует порядку
     * обхода исходного списка стран.
     *
     * @param countries список стран
     * @return список городов-столиц, найденных по идентификатору
     */
    public List<City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
