package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти топ-5 самых населённых городов мира вместе со страной и континентом")
public class WldCode0043 extends Base {

    /**
     * Задание: Найти топ-5 самых населённых городов мира вместе со страной и континентом.
     * <p>
     * Описание: среди всех городов всех стран необходимо выбрать пять городов
     * с наибольшим населением (в порядке убывания населения) и для каждого
     * вернуть его название, название страны, континент и население.
     * <p>
     * Если суммарное количество городов меньше пяти, возвращаются все города.
     * Для пустого списка стран возвращается пустой список.
     *
     * @param countries список стран
     * @return список из не более чем пяти описаний самых населённых городов,
     * упорядоченный по убыванию населения
     */
    public List<CityInfo> task(@NonNull Collection<Country> countries) {
        throw new UnsupportedOperationException("Реализуйте метод");
    }

    /**
     * Описание города: название города, страна, континент и население.
     *
     * @param cityName    название города
     * @param countryName название страны, которой принадлежит город
     * @param continent   название континента страны
     * @param population  население города
     */
    public record CityInfo(String cityName, String countryName, String continent, int population) {

        @Override
        public String toString() {
            return "%s | %s | %s | %d".formatted(cityName, countryName, continent, population);
        }
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        List<CityInfo> result = task(countries);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // не больше пяти
        assertTrue(result.size() <= 5);

        // отсортировано по убыванию населения
        assertTrue(IntStream.range(0, result.size() - 1)
                .allMatch(i -> result.get(i).population() >= result.get(i + 1).population()));

        // поля заполнены
        assertTrue(result.stream().allMatch(info ->
                info.cityName() != null && !info.cityName().isBlank()
                        && info.countryName() != null && !info.countryName().isBlank()
                        && info.continent() != null && !info.continent().isBlank()
                        && info.population() > 0));

        // граница: пустой вход
        assertTrue(task(List.of()).isEmpty());

        result.forEach(System.out::println);
    }
}
