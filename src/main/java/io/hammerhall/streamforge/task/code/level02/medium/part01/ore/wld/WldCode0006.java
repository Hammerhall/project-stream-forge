package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.Optional;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0006}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
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
}
