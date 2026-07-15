package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти страну с наибольшей площадью.")
public class WldCode0006 extends Base {

    /**
     * Задание: Найти страну с наибольшей площадью.
     * <p>
     * Описание: необходимо найти страну, у которой значение
     * {@code surfaceArea} максимально среди всех стран.
     *
     * @param countries список стран
     * @return {@code Optional}, содержащий страну с наибольшей площадью,
     * или {@code Optional.empty()}, если список стран пуст
     */
    public Optional<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        Optional<Country> largestByArea = task(countries);

        assertNotNull(largestByArea);
        assertTrue(largestByArea.isPresent());

        Country largest = largestByArea.get();

        assertTrue(task(List.of()).isEmpty());

        System.out.printf("Страна с наибольшей площадью: %s — %s%n", largest.getName(), largest.getSurfaceArea());
    }
}
