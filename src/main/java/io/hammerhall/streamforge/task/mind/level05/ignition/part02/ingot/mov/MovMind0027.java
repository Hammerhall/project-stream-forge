package io.hammerhall.streamforge.task.mind.level05.ignition.part02.ingot.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.NoSuchElementException;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

@Title("Чествование мастера")
public class MovMind0027 extends Base {

    /**
     * Задание: Найти наиболее представленного режиссёра и годы его активности.
     * <p>
     * Метки: [TIE_BREAK]
     * <p>
     * Описание: для каждого режиссёра необходимо определить количество его фильмов,
     * а также самый ранний и самый поздний год выхода. Если у фильма несколько
     * режиссёров, фильм учитывается для каждого из них. Режиссёры различаются по полному
     * имени ({@code getFullName()}): тёзки считаются одним режиссёром, их фильмы складываются,
     * а фильм, снятый несколькими тёзками, учитывается для их общего имени один раз.
     * <p>
     * Результат — сводка по режиссёру с наибольшим количеством фильмов. При равенстве
     * количества фильмов выбирается режиссёр с более ранним первым годом активности,
     * а при дальнейшем равенстве — режиссёр с лексикографически меньшим именем.
     *
     * @param movies коллекция фильмов
     * @return сводная информация о наиболее представленном режиссёре
     * @throws NoSuchElementException если коллекция фильмов пустая или режиссёров нет
     */
    public DirectorActivitySummary task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    /**
     * Сводка активности режиссёра: количество фильмов, первый и последний год выхода.
     *
     * @param directorName имя режиссёра
     * @param movieCount   количество фильмов режиссёра
     * @param firstYear    самый ранний год выхода фильма
     * @param lastYear     самый поздний год выхода фильма
     */
    public record DirectorActivitySummary(String directorName, long movieCount, int firstYear, int lastYear) {

        @Override
        public String toString() {
            return "Режиссёр: %s | Количество фильмов: %d | Первый год: %d | Последний год: %d"
                    .formatted(directorName, movieCount, firstYear, lastYear);
        }
    }

    @Test
    void runTask() {
        IO.println("Это вывод, а не проверка. Проверить решение: ./hammerhall submit MovMind0027");

        Collection<Movie> movies = movies();

        IO.println(task(movies));
    }
}
