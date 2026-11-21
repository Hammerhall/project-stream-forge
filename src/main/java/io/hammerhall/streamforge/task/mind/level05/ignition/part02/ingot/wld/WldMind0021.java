package io.hammerhall.streamforge.task.mind.level05.ignition.part02.ingot.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit WldMind0021}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code countries()}).
 */
@Title("Спор двух городов")
public class WldMind0021 extends Base {

    /**
     * Задание: Найти страны, где самый большой город не является столицей.
     * <p>
     * Описание: для каждой страны самым большим городом считается город с
     * наибольшим населением среди её городов. Страна попадает в результат,
     * если идентификатор её самого большого города не совпадает с
     * идентификатором столицы ({@code capital}).
     * <p>
     * Страны без городов в результат не включаются. Порядок стран
     * соответствует исходному списку. Для пустого списка стран возвращается
     * пустой список.
     * Если у страны нет столицы ({@code capital == null}), её самый большой город
     * столицей не является — страна попадает в результат.
     * Гарантируется, что у каждой страны наибольшее население — ровно у одного
     * из её городов.
     *
     * @param countries список стран
     * @return список стран, у которых самый большой город не является столицей
     */
    public List<Country> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
