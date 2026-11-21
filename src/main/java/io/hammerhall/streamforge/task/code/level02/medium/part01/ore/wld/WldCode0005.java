package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Справочник почтальона")
public class WldCode0005 extends Base {

    /**
     * Задание: Получить список всех городов мира.
     * <p>
     * Описание: необходимо собрать все города, находящиеся в каждой стране,
     * и вернуть их единым плоским списком.
     * <p>
     * Порядок городов в результате соответствует порядку обхода стран, а внутри
     * страны — порядку её списка городов.
     *
     * @param countries список стран мира
     * @return список всех городов мира
     */
    public List<City> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0005");

        Collection<Country> countries = countries();

        task(countries).stream().limit(20).forEach(IO::println);
    }
}
