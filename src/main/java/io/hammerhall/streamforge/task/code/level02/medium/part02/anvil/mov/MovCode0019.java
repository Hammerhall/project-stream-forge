package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Director;
import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Получить список всех режиссёров фильмов без создания промежуточных коллекций.")
public class MovCode0019 extends Base {

    /**
     * Задание: Получить список всех режиссёров фильмов без создания промежуточных коллекций.
     * <p>
     * Описание: каждый фильм может иметь нескольких режиссёров. Необходимо
     * извлечь всех режиссёров из всех фильмов, сохранив порядок их
     * появления (сначала все режиссёры первого фильма, затем второго и так
     * далее). Повторяющиеся режиссёры не удаляются. Для пустой коллекции
     * фильмов возвращается пустой список.
     *
     * @param movies коллекция фильмов
     * @return список всех режиссёров в порядке появления
     */
    public List<Director> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();
        List<Director> allDirectors = task(movies);

        assertNotNull(allDirectors);
        assertFalse(allDirectors.isEmpty());

        // все элементы — не null
        assertTrue(allDirectors.stream().allMatch(Objects::nonNull));

        // каждый режиссёр из результата действительно снимал хотя бы один фильм
        // из исходной коллекции (проверка пересчётом через flatMap)
        Set<Director> viaFlatMap = movies.stream()
                .flatMap(m -> m.getDirectors().stream())
                .collect(Collectors.toSet());
        assertTrue(viaFlatMap.containsAll(allDirectors));

        // граница: пустой вход
        assertTrue(task(List.of()).isEmpty());

        // граница: фильм без режиссёров не добавляет элементов
        Movie noDirector = new Movie();
        noDirector.setDirectors(List.of());
        assertTrue(task(List.of(noDirector)).isEmpty());

        System.out.printf("Всего режиссёров (с повторами): %d%n", allDirectors.size());
    }
}
