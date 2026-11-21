package io.hammerhall.streamforge.task.mind.level05.ignition.part02.ingot.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.NoSuchElementException;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Экспедиция картографа")
public class WldMind0022 extends Base {

    /**
     * Задание: Найти континент с максимальной плотностью населения.
     * <p>
     * Описание: плотность населения континента вычисляется как отношение
     * суммарного населения всех его стран к суммарной площади этих стран.
     * Необходимо вернуть название континента с наибольшей плотностью. Если суммарная
     * площадь стран континента равна нулю, его плотность считается равной нулю.
     *
     * @param countries список стран
     * @return название континента с максимальной плотностью населения
     * @throws NoSuchElementException если список стран пуст
     */
    public String task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldMind0022");

        Collection<Country> countries = countries();

        IO.println(task(countries));
    }
}
