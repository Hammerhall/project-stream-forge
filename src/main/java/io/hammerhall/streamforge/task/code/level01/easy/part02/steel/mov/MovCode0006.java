package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Беспокойный критик")
public class MovCode0006 extends Base {

    /**
     * Задание: Получить список фильмов без рейтинга или с некорректным рейтингом.
     * <p>
     * Описание: рейтинг фильма считается корректным, если он не равен {@code null}
     * и находится в диапазоне от 1.0 до 10.0 включительно. Результатом является
     * список фильмов, у которых рейтинг отсутствует ({@code null}) или выходит за
     * пределы допустимого диапазона.
     * <p>
     * Порядок фильмов в результате соответствует порядку обхода исходной коллекции.
     *
     * @param movies коллекция фильмов
     * @return список фильмов с отсутствующим или некорректным рейтингом
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0006");

        Collection<Movie> movies = movies();

        task(movies).stream().limit(20).forEach(IO::println);
    }
}
