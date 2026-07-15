package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Для каждого континента построить список стран с населением более 50 миллионов.")
public class WldCode0038 extends Base {

    /**
     * Задание: Для каждого континента построить список стран с населением более 50 миллионов.
     * <p>
     * Описание: необходимо сгруппировать страны по континентам, и для каждого
     * континента отобрать только те страны, население которых строго больше
     * 50 миллионов. Результат возвращается в виде ассоциативного массива, где
     * ключ — название континента, а значение — список подходящих стран.
     * Континенты, на которых нет стран с населением более 50 миллионов,
     * представлены в результате пустым списком.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → список стран с населением > 50 млн»
     */
    public Map<String, List<Country>> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        Map<String, List<Country>> result = task(countries);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // ключи — непустые названия континентов
        assertTrue(result.keySet().stream()
                .allMatch(continent -> continent != null && !continent.isBlank()));

        // граница: страна с населением ровно 50 млн НЕ попадает (строго больше)
        Country edge = new Country();
        edge.setContinent("Test");
        edge.setPopulation(50_000_000);
        edge.setCities(List.of());
        Map<String, List<Country>> edgeResult = task(List.of(edge));
        assertTrue(edgeResult.containsKey("Test"));
        assertTrue(edgeResult.get("Test").isEmpty());

        result.forEach((continent, filteredCountries) ->
                System.out.printf("%s -> %d стран(ы)%n",
                        continent, filteredCountries.size()));
    }
}
