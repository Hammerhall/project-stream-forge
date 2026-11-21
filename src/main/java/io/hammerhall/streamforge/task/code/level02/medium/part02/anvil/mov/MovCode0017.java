package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Таблички на стеллажах")
public class MovCode0017 extends Base {

    /**
     * Задание: Получить список названий всех уникальных жанров, отсортированный по алфавиту.
     * <p>
     * Описание: необходимо собрать названия всех жанров, встречающихся в коллекции фильмов,
     * исключить дубликаты и вернуть итоговый список в алфавитном порядке.
     *
     * @param movies коллекция фильмов
     * @return список уникальных названий жанров, отсортированный по алфавиту
     */
    public List<String> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovCode0017");

        Collection<Movie> movies = movies();

        task(movies).stream().limit(20).forEach(IO::println);
    }
}
