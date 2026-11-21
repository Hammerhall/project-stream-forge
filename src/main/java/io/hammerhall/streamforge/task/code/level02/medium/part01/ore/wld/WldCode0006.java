package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Optional;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Спор у глобуса")
public class WldCode0006 extends Base {

    /**
     * Задание: Найти страну с наибольшей площадью.
     * <p>
     * Описание: необходимо найти страну, у которой значение
     * {@code surfaceArea} максимально среди всех стран.
     * <p>
     * Если несколько стран имеют одинаковую максимальную площадь, допускается
     * вернуть любую из них.
     *
     * @param countries список стран
     * @return {@code Optional}, содержащий страну с наибольшей площадью,
     * или {@code Optional.empty()}, если список стран пуст
     */
    public Optional<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0006");

        Collection<Country> countries = countries();

        IO.println(task(countries));
    }
}
