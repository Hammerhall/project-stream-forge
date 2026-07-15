package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти столицу с наибольшей численностью населения.")
public class WldCode0015 extends Base {

    /**
     * Задание: Найти столицу с наибольшей численностью населения.
     * <p>
     * Описание: для каждой страны необходимо определить её столицу — город
     * с идентификатором, равным {@code country.getCapital()}. Среди всех
     * найденных столиц нужно найти город с максимальной численностью населения.
     * Если ни одна столица не найдена, выбрасывается {@link NoSuchElementException}.
     *
     * @param countries список стран мира
     * @return столица с наибольшей численностью населения
     * @throws NoSuchElementException если список стран пуст или ни у одной
     *                                страны не найдена столица
     */
    public City task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        City capitalWithMaxPopulation = task(countries);

        assertNotNull(capitalWithMaxPopulation);
        assertNotNull(capitalWithMaxPopulation.getName());
        assertFalse(capitalWithMaxPopulation.getName().isBlank());
        assertTrue(capitalWithMaxPopulation.getPopulation() > 0);

        assertThrows(NoSuchElementException.class, () -> task(List.of()));

        System.out.printf("Столица с наибольшим населением: %s — %d%n",
                capitalWithMaxPopulation.getName(), capitalWithMaxPopulation.getPopulation());
    }
}
