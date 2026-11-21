package io.hammerhall.streamforge.task.mind.level05.ignition.part02.ingot.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Жалоба губернатора")
public class WldMind0020 extends Base {

    /**
     * Задание: Найти страны, где население столицы составляет больше 30% населения страны.
     * <p>
     * Описание: для каждой страны её столица определяется как город из списка
     * городов страны, идентификатор которого совпадает с {@code capital}. Страна
     * попадает в результат, если население найденной столицы строго больше 30%
     * населения самой страны.
     * <p>
     * Страны, для которых столица не найдена или население которых равно нулю,
     * в результат не включаются. Порядок стран соответствует исходному списку.
     * Для пустого списка стран возвращается пустой список.
     * Страна без столицы ({@code capital == null}) считается страной, столица которой
     * не найдена.
     *
     * @param countries список стран
     * @return список стран, удовлетворяющих условию
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldMind0020");

        Collection<Country> countries = countries();

        task(countries).stream().limit(20).forEach(IO::println);
    }
}
