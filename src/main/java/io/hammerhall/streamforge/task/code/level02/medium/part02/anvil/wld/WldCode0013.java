package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Стенд в школьном коридоре")
public class WldCode0013 extends Base {

    /**
     * Задание: Получить список стран, отсортированный сначала по континенту, затем по названию.
     * <p>
     * Описание: необходимо отсортировать страны в порядке возрастания:
     * сначала по названию континента (лексикографически), а среди стран
     * одного континента — по названию страны (лексикографически).
     *
     * @param countries список стран мира
     * @return список стран, отсортированный по континенту и названию
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0013");

        Collection<Country> countries = countries();

        task(countries).stream().limit(20).forEach(IO::println);
    }
}
