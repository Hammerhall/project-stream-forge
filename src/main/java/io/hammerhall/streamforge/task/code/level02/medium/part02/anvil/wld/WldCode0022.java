package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

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

@DisplayName("Задание: Отсортировать страны по плотности населения в порядке убывания.")
public class WldCode0022 extends Base {

    /**
     * Задание: Отсортировать страны по плотности населения в порядке убывания.
     * <p>
     * Описание: плотность населения страны вычисляется как отношение численности
     * населения к площади. Необходимо отсортировать страны по убыванию плотности.
     * Страны, для которых плотность посчитать нельзя или она равна нулю,
     * в результат не включаются.
     * <p>
     * Страны с одинаковой плотностью могут располагаться в любом порядке.
     *
     * @param countries список стран
     * @return новый список стран, отсортированный по плотности населения
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
        assertTrue(sorted.stream().allMatch(c -> c.getPopulation() > 0));

        IntStream.range(1, sorted.size()).forEach(i -> {
            double prev = (double) sorted.get(i - 1).getPopulation() / sorted.get(i - 1).getSurfaceArea();
            double curr = (double) sorted.get(i).getPopulation() / sorted.get(i).getSurfaceArea();
            assertTrue(prev >= curr);
        });

        assertTrue(task(List.of()).isEmpty());
        sorted.forEach(c -> System.out.println(c.getName() + " -> "
                + (double) c.getPopulation() / c.getSurfaceArea()));
    }
}
