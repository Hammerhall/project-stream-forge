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

@DisplayName("Задание: Найти среднее население городов по каждому континенту")
public class WldCode0044 extends Base {

    /**
     * Задание: Найти среднее население городов по каждому континенту.
     * <p>
     * Описание: каждый город принадлежит стране, а страна расположена на
     * континенте. Необходимо сгруппировать все города по континентам их стран
     * и для каждого континента вычислить среднее население входящих в него
     * городов. Результат возвращается в виде ассоциативного массива, где ключ —
     * название континента, а значение — среднее население его городов.
     * <p>
     * Для пустого списка стран возвращается пустой ассоциативный массив.
     *
     * @param countries список стран
     * @return ассоциативный массив «континент → среднее население городов»
     */
    public Map<String, Double> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        Map<String, Double> result = task(countries);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // средние значения положительны
        assertTrue(result.values().stream().allMatch(avg -> avg > 0));

        // ключи — непустые названия континентов
        assertTrue(result.keySet().stream()
                .allMatch(continent -> continent != null && !continent.isBlank()));

        // граница: пустой вход
        assertTrue(task(List.of()).isEmpty());

        result.forEach((continent, avg) ->
                System.out.printf("%s -> %.2f%n", continent, avg));
    }
}
