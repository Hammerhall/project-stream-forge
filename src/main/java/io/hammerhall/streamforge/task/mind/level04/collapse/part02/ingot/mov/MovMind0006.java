package io.hammerhall.streamforge.task.mind.level04.collapse.part02.ingot.mov;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import io.hammerhall.streamforge.task.Title;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * Проверить решение: {@code ./hammerhall submit MovMind0006}. Посмотреть результат на открытых данных — добавьте
 * {@code void main()} и вызовите {@code task(…)}; данные даёт {@code Base} (здесь — {@code movies()}).
 */
@Title("Вечер в провинциальном театре")
public class MovMind0006 extends Base {

    /**
     * Задание: Найти все фильмы, у которых набор жанров строго равен набору: Drama и Comedy.
     * <p>
     * Описание: необходимо найти фильмы, у которых множество названий жанров
     * состоит ровно из двух значений: "Drama" и "Comedy". Фильм попадает в результат
     * только при полном совпадении наборов — ни больше, ни меньше.
     * Например, фильм с жанрами Drama, Comedy и Romance не подходит.
     * Названия жанров сравниваются с учётом регистра. Порядок фильмов в результате
     * соответствует порядку обхода исходной коллекции.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, у которых набор жанров строго равен {"Drama", "Comedy"}
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }
}
