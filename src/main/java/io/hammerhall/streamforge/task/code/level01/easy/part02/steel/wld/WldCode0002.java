package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить множество всех континентов.")
public class WldCode0002 extends Base {

    /**
     * Задание: Получить множество всех континентов.
     * <p>
     * Описание: необходимо собрать уникальные названия континентов,
     * на которых расположены страны из базы данных.
     *
     * @param countries список стран
     * @return множество уникальных названий континентов
     */
    public Set<String> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        Set<String> continents = task(countries);

        assertNotNull(continents);
        assertFalse(continents.isEmpty());

        assertFalse(continents.contains(null));

        assertTrue(continents.stream()
                .allMatch(continentName -> continentName != null && !continentName.isBlank()));

        assertTrue(task(List.of()).isEmpty());

        System.out.println("Континенты: " + continents);
    }
}
