package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить список всех городов мира.")
public class WldCode0005 extends Base {

    /**
     * Задание: Получить список всех городов мира.
     * <p>
     * Описание: необходимо собрать все города, находящиеся в каждой стране,
     * и вернуть их единым плоским списком.
     *
     * @param countries список стран мира
     * @return список всех городов мира
     */
    public List<City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        List<City> allCities = task(countries);

        assertNotNull(allCities);
        assertFalse(allCities.isEmpty());

        assertTrue(task(List.of()).isEmpty());

        System.out.println("Всего городов: " + allCities.size());
        allCities.forEach(System.out::println);
    }
}
