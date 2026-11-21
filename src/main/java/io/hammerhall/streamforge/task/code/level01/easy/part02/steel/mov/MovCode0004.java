package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Календарь киномеханика")
public class MovCode0004 extends Base {

    /**
     * Задание: Посчитать количество фильмов, вышедших в годы, которые не являются високосными.
     * <p>
     * Описание: необходимо посчитать, сколько фильмов из исходной коллекции вышло в годы,
     * не являющиеся високосными. Год, делящийся на 4, не всегда является високосным —
     * воспользуйтесь стандартным Java API для точной проверки.
     *
     * @param movies коллекция фильмов
     * @return количество фильмов, вышедших в невисокосные годы
     */
    public long task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0004");

        Collection<Movie> movies = movies();

        IO.println(task(movies));
    }
}
