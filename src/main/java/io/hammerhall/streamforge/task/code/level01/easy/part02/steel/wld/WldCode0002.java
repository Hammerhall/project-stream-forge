package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Set;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Атлас для первоклассника")
public class WldCode0002 extends Base {

    /**
     * Задание: Получить множество всех континентов.
     * <p>
     * Описание: необходимо собрать уникальные названия континентов,
     * на которых расположены страны из базы данных.
     *
     * @param countries список стран
     * @return множество уникальных названий континентов
     */
    public Set<String> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0002");

        Collection<Country> countries = countries();

        task(countries).stream().limit(20).forEach(IO::println);
    }
}
