package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@DisplayName("Задание: Построить индекс стран по коду.")
public class WldCode0008 extends Base {

    /**
     * Задание: Построить индекс стран по коду.
     * <p>
     * Описание: необходимо преобразовать коллекцию стран в ассоциативный массив,
     * в котором ключом выступает код страны, а значением — её название.
     * Такой индекс позволяет получать название страны напрямую по её коду.
     * <p>
     * Коды стран в исходных данных уникальны. Если коллекция пуста,
     * необходимо вернуть пустой ассоциативный массив.
     *
     * @param countries коллекция стран
     * @return ассоциативный массив, сопоставляющий коду страны её название
     */
    public Map<String, String> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        Map<String, String> index = task(countries);

        assertNotNull(index);
        assertFalse(index.isEmpty());
        assertEquals(countries.size(), index.size());

        Country any = countries.iterator().next();
        assertEquals(any.getName(), index.get(any.getCode()));

        assertTrue(task(List.of()).isEmpty());

        index.forEach((code, name) -> System.out.println(code + " -> " + name));
    }
}
