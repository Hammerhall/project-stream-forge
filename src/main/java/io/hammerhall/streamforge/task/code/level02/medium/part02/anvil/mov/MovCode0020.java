package io.hammerhall.streamforge.task.code.level02.medium.part02.anvil.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.Map;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Посчитать количество встреч каждого жанра.")
public class MovCode0020 extends Base {

    /**
     * Задание: Посчитать количество встреч каждого жанра.
     * <p>
     * Описание: необходимо определить, сколько раз каждый жанр встречается
     * в коллекции фильмов. Каждое вхождение жанра у фильма считается отдельно.
     * Ключом результирующей карты является название жанра, значением —
     * количество его встреч среди всех фильмов.
     *
     * @param movies коллекция фильмов
     * @return карта, где ключ — название жанра, значение — количество встреч
     * этого жанра среди фильмов
     */
    public Map<String, Long> task(@NonNull Collection<Movie> movies) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        Map<String, Long> genreOccurrenceCount = task(movies);

        assertNotNull(genreOccurrenceCount);
        assertFalse(genreOccurrenceCount.isEmpty());
        assertTrue(genreOccurrenceCount.containsKey("Drama"));
        assertTrue(genreOccurrenceCount.keySet().stream()
                .allMatch(genreName -> genreName != null && !genreName.isBlank()));

        assertTrue(genreOccurrenceCount.values().stream()
                .allMatch(count -> count != null && count > 0));

        genreOccurrenceCount.forEach((genreName, movieCount) ->
                System.out.println(genreName + " " + movieCount));
    }
}
