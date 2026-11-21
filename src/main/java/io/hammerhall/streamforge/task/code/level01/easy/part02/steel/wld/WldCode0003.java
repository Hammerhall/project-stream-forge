package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Флаги вдоль набережной")
public class WldCode0003 extends Base {

    /**
     * Задание: Получить список названий всех стран, отсортированный в алфавитном порядке.
     * <p>
     * Описание: необходимо преобразовать список стран в список их названий
     * и отсортировать по алфавиту (лексикографически) — в естественном порядке строк
     * ({@link String#compareTo}: по кодам символов, поэтому заглавные буквы идут раньше строчных,
     * а буквы с диакритикой — после латинских без неё).
     *
     * @param countries список стран
     * @return список названий стран в естественном порядке строк
     */
    public List<String> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit WldCode0003");

        Collection<Country> countries = countries();

        task(countries).stream().limit(20).forEach(IO::println);
    }
}
