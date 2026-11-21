package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Пыльные коробки архива")
public class MovCode0009 extends Base {

    /**
     * Задание: Получить список всех фильмов, отсортированных по году выхода.
     * <p>
     * Описание: необходимо отсортировать коллекцию фильмов по году выхода в порядке
     * возрастания — от более старых фильмов к более новым.
     * <p>
     * Порядок фильмов с одинаковым годом выхода не регламентирован.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, отсортированных по году выхода по возрастанию
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0009");

        Collection<Movie> movies = movies();

        task(movies).stream().limit(20).forEach(IO::println);
    }
}
