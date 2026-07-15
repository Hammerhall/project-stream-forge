package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.LongSummaryStatistics;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти минимальное, максимальное и среднее население стран мира.")
public class WldCode0021 extends Base {

    /**
     * Задание: Найти минимальное, максимальное и среднее население среди стран мира.
     * <p>
     * Описание: по коллекции стран необходимо вычислить сводную статистику
     * численности населения — минимальное, максимальное и среднее значение
     * среди всех стран. Для пустой коллекции статистика не содержит элементов.
     *
     * @param countries коллекция стран
     * @return сводная статистика населения: минимум, максимум, среднее, сумма и количество
     */
    public LongSummaryStatistics task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        LongSummaryStatistics stats = task(countries);

        assertNotNull(stats);
        assertEquals(countries.size(), stats.getCount());
        assertTrue(stats.getMin() <= stats.getMax());
        assertTrue(stats.getAverage() >= stats.getMin());
        assertTrue(stats.getAverage() <= stats.getMax());

        assertEquals(0, task(List.of()).getCount());

        System.out.printf("min=%d max=%d avg=%.2f%n", stats.getMin(), stats.getMax(), stats.getAverage());
    }
}
