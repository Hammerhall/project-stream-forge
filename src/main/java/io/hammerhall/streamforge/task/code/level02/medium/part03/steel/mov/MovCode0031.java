package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.NoSuchElementException;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovCode0031}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
@Title("Спор старых киноманов")
public class MovCode0031 extends Base {

    /**
     * Задание: Найти год, в котором вышло больше всего фильмов.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: необходимо определить год с наибольшим количеством вышедших фильмов.
     * Если несколько лет имеют одинаковое максимальное количество фильмов,
     * результатом должен стать наиболее поздний из таких годов.
     *
     * @param movies коллекция фильмов
     * @return год и количество вышедших в нём фильмов
     * @throws NoSuchElementException если коллекция фильмов пустая
     */
    public YearMovieCount task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    /**
     * Год и количество фильмов, выпущенных в этом году.
     *
     * @param year       год выхода фильмов
     * @param movieCount количество фильмов за этот год
     */
    public record YearMovieCount(int year, long movieCount) {

        @Override
        public String toString() {
            return "Год: %d | Количество фильмов: %d".formatted(year, movieCount);
        }
    }
}
