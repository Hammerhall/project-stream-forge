package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Сопоставить странам их города-столицы.")
public class WldCode0026 extends Base {

    /**
     * Задание: Сопоставить странам их города-столицы.
     * <p>
     * Описание: по всем городам строится индекс, позволяющий находить город
     * по его идентификатору. Затем для каждой страны из индекса извлекается
     * город, идентификатор которого совпадает с {@code capital} этой страны.
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

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        List<City> capitals = task(countries);

        assertNotNull(capitals);
        assertFalse(capitals.isEmpty());
        assertTrue(capitals.size() <= countries.size());
        assertTrue(capitals.stream().allMatch(Objects::nonNull));

        assertTrue(task(List.of()).isEmpty());

        Country noCapitalMatch = new Country();
        noCapitalMatch.setCapital(-1);
        noCapitalMatch.setCities(List.of());
        assertTrue(task(List.of(noCapitalMatch)).isEmpty());

        capitals.forEach(c -> System.out.println(c.getName() + " (id=" + c.getId() + ")"));
    }
}
