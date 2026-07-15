package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Отобрать страны по нескольким критериям одновременно.")
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
     * Критерии должны быть объединены в одно составное условие отбора.
     * <p>
     * Порядок стран в результате соответствует порядку исходного списка.
     *
     * @param countries список стран
     * @return список стран, удовлетворяющих условию отбора
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        List<Country> filtered = task(countries);

        assertNotNull(filtered);

        assertFalse(filtered.isEmpty());

        assertTrue(filtered.size() <= countries.size());

        assertTrue(countries.containsAll(filtered));

        assertTrue(task(List.of()).isEmpty());

        System.out.println("Отобрано стран: " + filtered.size());
        filtered.forEach(country ->
                System.out.printf("%s | нас.: %d | площ.: %s | конт.: %s%n",
                        country.getName(),
                        country.getPopulation(),
                        country.getSurfaceArea(),
                        country.getContinent()));
    }
}
