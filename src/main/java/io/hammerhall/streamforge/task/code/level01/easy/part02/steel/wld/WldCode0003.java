package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.wld;

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

@DisplayName("Задание: Получить список названий всех стран, отсортированный в алфавитном порядке.")
public class WldCode0003 extends Base {

    /**
     * Задание: Получить список названий всех стран,
     * отсортированный в алфавитном порядке.
     * <p>
     * Описание: необходимо преобразовать список стран в список их названий
     * и отсортировать по алфавиту (лексикографически).
     *
     * @param countries список стран
     * @return список названий стран, отсортированный по алфавиту
     */
    public List<String> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        List<String> countryNames = task(countries);

        assertNotNull(countryNames);
        assertFalse(countryNames.isEmpty());
        assertEquals(countries.size(), countryNames.size());

        assertTrue(countryNames.stream()
                .allMatch(name -> name != null && !name.isBlank()));

        assertTrue(task(List.of()).isEmpty());

        countryNames.forEach(System.out::println);
    }
}
