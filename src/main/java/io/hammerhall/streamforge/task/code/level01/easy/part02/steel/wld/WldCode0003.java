package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldCode0003}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
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
}
