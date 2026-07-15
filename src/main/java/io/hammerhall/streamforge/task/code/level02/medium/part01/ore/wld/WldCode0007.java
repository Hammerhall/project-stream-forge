package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить неизменяемый список стран, отсортированных по убыванию численности населения.")
public class WldCode0007 extends Base {

    /**
     * Задание: Получить неизменяемый список стран, отсортированных по убыванию численности населения.
     * <p>
     * Описание: результатом является список всех стран из исходного набора,
     * упорядоченный от самой населённой страны к наименее населённой.
     * Полученный список должен быть защищён от модификации — любая попытка
     * добавить или удалить элемент должна приводить к исключению.
     *
     * @param countries список всех стран мира
     * @return неизменяемый список стран, отсортированных по населению по убыванию
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        List<Country> largestCountries = task(countries);

        assertNotNull(largestCountries);
        assertFalse(largestCountries.isEmpty());
        assertEquals(countries.size(), largestCountries.size());

        assertThrows(UnsupportedOperationException.class, () -> largestCountries.add(new Country()));

        largestCountries
                .forEach(country -> System.out.printf("%s — %d%n", country.getName(), country.getPopulation()));
    }
}
