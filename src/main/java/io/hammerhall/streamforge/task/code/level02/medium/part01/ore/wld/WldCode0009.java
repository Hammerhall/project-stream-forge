package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Вычислить суммарную численность населения всех городов мира.")
public class WldCode0009 extends Base {

    /**
     * Задание: Вычислить суммарную численность населения всех городов мира.
     * <p>
     * Описание: результатом является сумма значений численности населения
     * всех городов из всех стран мира.
     *
     * @param countries список стран мира
     * @return суммарная численность населения всех городов мира;
     * для пустого списка стран — 0
     */
    public long task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        long totalCityPopulation = task(countries);

        assertTrue(totalCityPopulation > 0,
                "Суммарное население городов должно быть положительным");

        assertEquals(0L, task(List.of()));

        System.out.println("Суммарное население всех городов: " + totalCityPopulation);
    }
}
