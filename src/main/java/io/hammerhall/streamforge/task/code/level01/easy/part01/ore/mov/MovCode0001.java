package io.hammerhall.streamforge.task.code.level01.easy.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

@Title("Программка для зрителей")
public class MovCode0001 extends Base {

    /**
     * Задание: Получить список всех названий фильмов.
     * <p>
     * Описание: необходимо преобразовать коллекцию фильмов в список строк,
     * где каждая строка — это название фильма. Порядок названий в результате
     * соответствует порядку обхода исходной коллекции.
     *
     * @param movies коллекция фильмов
     * @return список названий всех фильмов
     */
    public List<String> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    void main() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0001");
        task(movies()).stream().limit(20).forEach(IO::println);
    }
}