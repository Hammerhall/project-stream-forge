package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

@Title("Заседание в Женеве")
public class WldCode0001 extends Base {

    /**
     * Задание: Получить список стран с населением более 50 миллионов человек.
     * <p>
     * Описание: необходимо отфильтровать страны, оставив только те,
     * численность населения которых строго больше 50 000 000. Порядок результата
     * соответствует порядку обхода исходной коллекции.
     *
     * @param countries список стран
     * @return список стран с населением > 50 000 000
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    void main() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0001");
        task(countries()).forEach(country ->
                IO.println("%s — %d".formatted(country.getName(), country.getPopulation())));
    }
}
