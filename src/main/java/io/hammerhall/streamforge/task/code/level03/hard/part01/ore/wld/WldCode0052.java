package io.hammerhall.streamforge.task.code.level03.hard.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти страну с максимальным количеством городов на каждом континенте.")
public class WldCode0052 extends Base {

    /**
     * Задание: Найти страну с максимальным количеством городов на каждом континенте.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: необходимо для каждого континента определить страну, у которой
     * наибольшее количество городов. Результат возвращается в виде ассоциативного
     * массива, где ключ — название континента, а значение — страна этого
     * континента с максимальным числом городов.
     * <p>
     * Если на континенте несколько стран с одинаковым (максимальным) числом
     * городов, выбирается страна, название которой идёт раньше в алфавитном
     * порядке.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → страна с наибольшим числом городов»
     */
    public Map<String, Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        Map<String, Country> result = task(countries);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // ключи — непустые названия континентов, значения — не null
        assertTrue(result.keySet().stream()
                .allMatch(continent -> continent != null && !continent.isBlank()));
        assertTrue(result.values().stream().allMatch(Objects::nonNull));

        // выбранная страна действительно с того же континента, что и ключ
        assertTrue(result.entrySet().stream()
                .allMatch(entry -> entry.getKey().equals(entry.getValue().getContinent())));

        // граница: пустой вход
        assertTrue(task(List.of()).isEmpty());

        result.forEach((continent, country) ->
                System.out.printf("%s -> %s (%d городов)%n",
                        continent, country.getName(), country.getCities().size()));
    }
}
