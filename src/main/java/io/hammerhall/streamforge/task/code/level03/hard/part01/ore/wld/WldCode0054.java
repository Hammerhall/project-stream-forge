package io.hammerhall.streamforge.task.code.level03.hard.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти столицу с наибольшей численностью населения на каждом континенте.")
public class WldCode0054 extends Base {

    /**
     * Задание: Найти столицу с наибольшей численностью населения на каждом континенте.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: столица страны определяется как город из списка городов страны,
     * идентификатор которого совпадает с {@code capital}. Необходимо для каждого
     * континента среди столиц его стран найти столицу с наибольшим населением.
     * Результат возвращается в виде ассоциативного массива, где ключ — название
     * континента, а значение — столица с наибольшим населением на этом континенте.
     * <p>
     * Страны, для которых столица не найдена среди их городов, не учитываются.
     * Если на континенте несколько столиц с одинаковым (максимальным) населением,
     * выбирается город, название которого идёт раньше в алфавитном порядке.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → столица с наибольшим населением»
     */
    public Map<String, City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        Map<String, City> result = task(countries);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // значения — столицы с положительным населением
        assertTrue(result.values().stream()
                .allMatch(city -> city != null && city.getPopulation() > 0));

        // ключи — непустые названия континентов
        assertTrue(result.keySet().stream()
                .allMatch(continent -> continent != null && !continent.isBlank()));

        // граница: пустой вход
        assertTrue(task(List.of()).isEmpty());

        // граница: страна без подходящей столицы не даёт записи
        Country noCapital = new Country();
        noCapital.setContinent("Nowhere");
        noCapital.setCapital(-1);
        noCapital.setCities(List.of());
        assertTrue(task(List.of(noCapital)).isEmpty());

        result.forEach((continent, city) ->
                System.out.printf("%s -> %s (%d)%n",
                        continent, city.getName(), city.getPopulation()));
    }
}
