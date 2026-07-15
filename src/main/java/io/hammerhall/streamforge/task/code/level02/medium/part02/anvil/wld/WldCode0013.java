package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@DisplayName("Задание: Получить список стран, отсортированный сначала по континенту, затем по названию.")
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

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        List<Country> sortedCountries = task(countries);

        assertNotNull(sortedCountries);
        assertFalse(sortedCountries.isEmpty());
        assertEquals(countries.size(), sortedCountries.size());
        assertTrue(sortedCountries.containsAll(countries));

        assertTrue(task(List.of()).isEmpty());

        sortedCountries
                .forEach(country -> System.out.printf("%s — %s%n", country.getContinent(), country.getName()));
    }
}
