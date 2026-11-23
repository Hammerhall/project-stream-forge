package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovCode0004}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
@Title("Календарь киномеханика")
public class MovCode0004 extends Base {

    /**
     * Задание: Посчитать количество фильмов, вышедших в годы, которые не являются високосными.
     * <p>
     * Описание: необходимо посчитать, сколько фильмов из исходной коллекции вышло в годы,
     * не являющиеся високосными. Високосный год определяется по григорианскому календарю:
     * он делится на 4 и при этом не делится на 100 либо делится на 400. Так, 1900 год —
     * невисокосный, а 2000 — високосный.
     *
     * @param movies коллекция фильмов
     * @return количество фильмов, вышедших в невисокосные годы
     */
    public long task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
