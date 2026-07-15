package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

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

@DisplayName("Задание: Получить список названий столиц всех стран.")
public class WldCode0014 extends Base {

    /**
     * Задание: Получить список названий столиц всех стран.
     * <p>
     * Описание: для каждой страны необходимо среди её городов найти столицу
     * и получить её название. Страны, у которых столица не найдена, пропускаются.
     *
     * @param countries список стран мира
     * @return список названий столиц
     */
    public List<String> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        List<String> capitalNames = task(countries);

        assertNotNull(capitalNames);
        assertFalse(capitalNames.isEmpty());

        assertTrue(capitalNames.size() <= countries.size());

        assertTrue(capitalNames.stream()
                .allMatch(name -> name != null && !name.isBlank()));

        assertTrue(task(List.of()).isEmpty());

        System.out.println("Найдено столиц: " + capitalNames.size());
        capitalNames.forEach(System.out::println);
    }
}
