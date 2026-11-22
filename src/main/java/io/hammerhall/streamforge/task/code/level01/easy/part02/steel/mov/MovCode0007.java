package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

@Title("Ни рыба ни мясо")
public class MovCode0007 extends Base {

    /**
     * Задание: Найти все фильмы, у которых больше одного жанра.
     * <p>
     * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те фильмы,
     * у которых количество жанров строго больше одного.
     * <p>
     * Порядок фильмов в результате соответствует порядку обхода исходной коллекции.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, у которых строго больше одного жанра
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    void main() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0007");
        task(movies()).stream().limit(20).forEach(IO::println);
    }
}
