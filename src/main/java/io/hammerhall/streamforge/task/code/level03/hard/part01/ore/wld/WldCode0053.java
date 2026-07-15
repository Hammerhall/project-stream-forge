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

@DisplayName("Задание: Найти самый густонаселённый город на каждом континенте.")
public class WldCode0053 extends Base {

    /**
     * Задание: Найти самый густонаселённый город на каждом континенте.
     * <p>
     * Описание: каждый город принадлежит стране, а страна расположена на
     * континенте. Необходимо для каждого континента определить город с
     * наибольшим населением среди всех городов его стран. Результат
     * возвращается в виде ассоциативного массива, где ключ — название
     * континента, а значение — самый густонаселённый город этого континента.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → самый населённый город»
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

        // у каждого континента есть город с положительным населением
        assertTrue(result.values().stream()
                .allMatch(city -> city != null && city.getPopulation() > 0));

        // ключи — непустые названия континентов
        assertTrue(result.keySet().stream()
                .allMatch(continent -> continent != null && !continent.isBlank()));

        // граница: пустой вход
        assertTrue(task(List.of()).isEmpty());

        result.forEach((continent, city) ->
                System.out.printf("%s - %s (%d)%n", continent, city.getName(), city.getPopulation()));
    }
}
