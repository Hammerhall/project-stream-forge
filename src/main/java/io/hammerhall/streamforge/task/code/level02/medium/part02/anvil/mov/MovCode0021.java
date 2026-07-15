package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Сгруппировать фильмы по десятилетиям.")
public class MovCode0021 extends Base {

    /**
     * Задание: Сгруппировать фильмы по десятилетиям.
     * <p>
     * Описание: необходимо сгруппировать фильмы по десятилетиям их выхода. Десятилетие
     * вычисляется как год, округлённый вниз до десятков: например, 1994 относится
     * к 1990-м, 2001 — к 2000-м, 2019 — к 2010-м. Для каждого десятилетия нужно собрать
     * список фильмов, вышедших в этом десятилетии.
     * <p>
     * Итоговая структура должна быть отсортирована по десятилетию в порядке возрастания.
     *
     * @param movies коллекция фильмов
     * @return отсортированная по десятилетию карта, где ключ — десятилетие,
     * а значение — список фильмов, вышедших в этом десятилетии
     */
    public TreeMap<Integer, List<Movie>> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        TreeMap<Integer, List<Movie>> moviesByDecade = task(movies);

        assertNotNull(moviesByDecade);
        assertFalse(moviesByDecade.isEmpty());

        assertNotNull(task(List.of()));
        assertTrue(task(List.of()).isEmpty());

        moviesByDecade.forEach((decade, decadeMovies) -> {
            assertNotNull(decade);
            assertTrue(decade > 0);
            assertEquals(0, decade % 10);

            assertNotNull(decadeMovies);
            assertFalse(decadeMovies.isEmpty());

            decadeMovies.forEach(movie -> {
                assertNotNull(movie);
                assertTrue(movie.getYear() >= decade);
                assertTrue(movie.getYear() <= decade + 9);
            });
        });

        assertEquals(moviesByDecade.keySet().stream().sorted().toList(), new ArrayList<>(moviesByDecade.keySet()));

        moviesByDecade.forEach((decade, decadeMovies) ->
                System.out.printf("Десятилетие: %d | Количество фильмов: %d%n", decade, decadeMovies.size()));
    }
}
