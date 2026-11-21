package io.hammerhall.streamforge.task.code.level03.hard.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Map;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Открытки туриста")
public class WldCode0053 extends Base {

    /**
     * Задание: Найти самый густонаселённый город на каждом континенте.
     * <p>
     * Описание: каждый город принадлежит стране, а страна расположена на
     * континенте. Необходимо для каждого континента определить город с
     * наибольшим населением среди всех городов его стран. Результат
     * возвращается в виде ассоциативного массива, где ключ — название
     * континента, а значение — самый густонаселённый город этого континента.
     * Континент, у стран которого нет ни одного города, в результат не включается.
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
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0053");

        Collection<Country> countries = countries();

        task(countries).entrySet().stream().limit(20).forEach(IO::println);
    }
}
