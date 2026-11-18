package io.hammerhall.streamforge.task.mind.level05.ignition.part01.ore.wld;

import io.hammerhall.streamforge.task.Base;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Записки демографа")
public class WldMind0018 extends Base {

    /**
     * Задание: Построить последовательность роста населения.
     * <p>
     * Описание: необходимо сформировать последовательность значений
     * численности населения, начиная с указанного стартового значения.
     * Каждое следующее значение вычисляется увеличением предыдущего
     * на заданный процент — точно: например, 100 при росте на 15 % дают ровно 115.
     * Дробная часть каждого нового значения отбрасывается,
     * и следующее значение считается уже от усечённого.
     * <p>
     * Генерация завершается при достижении верхней границы. В результат попадают
     * только значения, строго меньшие {@code maxPopulation}: значение, достигшее
     * границы или перешагнувшее её, не включается. Если {@code startPopulation}
     * не меньше {@code maxPopulation}, возвращается пустой список.
     * Гарантируется, что {@code growthRate > 0} и уже первый шаг увеличивает численность
     * хотя бы на единицу.
     * В результирующий список должны попасть все полученные значения
     * в порядке их генерации.
     *
     * @param startPopulation начальная численность населения
     * @param growthRate      ежегодный прирост в процентах
     * @param maxPopulation   верхняя граница генерации
     * @return последовательность значений численности населения
     */
    public List<Long> task(long startPopulation, double growthRate, long maxPopulation) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldMind0018");

        long startPopulation = 1_000_000L;
        double growthRate = 5.0;
        long maxPopulation = 2_000_000L;

        task(startPopulation, growthRate, maxPopulation).stream().limit(20).forEach(IO::println);
    }
}
