package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.wld;

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

@DisplayName("Задание: Получить список стран с населением более 50 миллионов человек.")
public class WldCode0001 extends Base {

    /**
     * Задание: Получить список стран с населением более 50 миллионов человек.
     * <p>
     * Описание: необходимо отфильтровать страны, оставив только те,
     * численность населения которых строго больше 50 000 000.
     *
     * @param countries список стран
     * @return список стран с населением > 50 000 000
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        List<Country> largeCountries = task(countries);

        assertNotNull(largeCountries);
        assertFalse(largeCountries.isEmpty());

        assertTrue(task(List.of()).isEmpty());

        largeCountries.forEach(country -> System.out.printf("%s — %d%n", country.getName(), country.getPopulation()));
    }
}
