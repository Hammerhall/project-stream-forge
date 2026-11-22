package io.hammerhall.streamforge.task.mind.level05.ignition.part02.ingot.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.NoSuchElementException;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldMind0022}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Экспедиция картографа")
public class WldMind0022 extends Base {

    /**
     * Задание: Найти континент с максимальной плотностью населения.
     * <p>
     * Описание: плотность населения континента вычисляется как отношение
     * суммарного населения всех его стран к суммарной площади этих стран.
     * Необходимо вернуть название континента с наибольшей плотностью. Если суммарная
     * площадь стран континента равна нулю, его плотность считается равной нулю.
     * Если наибольшая плотность сразу у нескольких континентов, годится любой
     * из них.
     *
     * @param countries список стран
     * @return название континента с максимальной плотностью населения
     * @throws NoSuchElementException если список стран пуст
     */
    public String task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
