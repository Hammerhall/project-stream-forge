package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Отсортировать страны по количеству городов в порядке убывания.")
public class WldCode0011 extends Base {

    /**
     * Задание: Отсортировать страны по количеству городов в порядке убывания.
     * <p>
     * Описание: необходимо отсортировать список стран в порядке убывания
     * количества городов, принадлежащих каждой стране.
     * <p>
     * Страны с одинаковым количеством городов могут располагаться
     * в любом порядке.
     *
     * @param countries список стран
     * @return новый список стран, отсортированный по количеству городов
     * в порядке убывания
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {

        Collection<Country> countries = countries();

        List<Country> sorted = task(countries);

        assertNotNull(sorted);
        assertFalse(sorted.isEmpty());

        assertEquals(countries.size(), sorted.size());

        IntStream.range(1, sorted.size())
                .forEach(i -> assertTrue(
                        sorted.get(i - 1).getCities().size()
                                >= sorted.get(i).getCities().size()));

        assertTrue(task(List.of()).isEmpty());

        System.out.println("Страны по количеству городов:");
        sorted.forEach(country ->
                System.out.println(country.getName()
                        + " -> " + country.getCities().size()));
    }
}
