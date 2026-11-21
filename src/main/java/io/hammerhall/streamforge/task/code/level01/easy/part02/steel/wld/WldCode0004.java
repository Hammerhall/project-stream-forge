package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Карта первооткрывателя")
public class WldCode0004 extends Base {

    /**
     * Задание: Найти страны, у которых нет ни одного города.
     * <p>
     * Описание: необходимо оставить только те страны, список городов которых пуст.
     * Порядок стран в результате не важен.
     *
     * @param countries список стран
     * @return список стран без городов
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0004");

        Collection<Country> countries = countries();

        task(countries).stream().limit(20).forEach(IO::println);
    }
}
