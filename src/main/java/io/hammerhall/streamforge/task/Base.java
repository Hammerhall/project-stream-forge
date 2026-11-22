package io.hammerhall.streamforge.task;

import io.hammerhall.streamforge.domain.air.Airplane;
import io.hammerhall.streamforge.domain.air.Airport;
import io.hammerhall.streamforge.domain.air.BoardingPass;
import io.hammerhall.streamforge.domain.air.Booking;
import io.hammerhall.streamforge.domain.air.Flight;
import io.hammerhall.streamforge.domain.air.Route;
import io.hammerhall.streamforge.domain.air.Seat;
import io.hammerhall.streamforge.domain.air.Segment;
import io.hammerhall.streamforge.domain.air.Ticket;
import io.hammerhall.streamforge.domain.movie.Actor;
import io.hammerhall.streamforge.domain.movie.Director;
import io.hammerhall.streamforge.domain.movie.DirectorGenre;
import io.hammerhall.streamforge.domain.movie.Genre;
import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.movie.Role;
import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.domain.world.CountryLanguage;
import io.hammerhall.streamforge.repository.AirRepository;
import io.hammerhall.streamforge.repository.MovieRepository;
import io.hammerhall.streamforge.repository.WorldRepository;
import io.hammerhall.streamforge.service.AirService;
import io.hammerhall.streamforge.service.AirServiceImpl;
import io.hammerhall.streamforge.service.MovieService;
import io.hammerhall.streamforge.service.MovieServiceImpl;
import io.hammerhall.streamforge.service.WorldService;
import io.hammerhall.streamforge.service.WorldServiceImpl;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Общий предок задач: даёт доступ к данным курса.
 * <p>
 * Данные грузятся <b>при первом обращении</b>, а не при загрузке класса.
 * Ничего не вызвали — ничего не прочитано.
 */
public abstract class Base {

    /**
     * Держатель данных о фильмах.
     * <p>
     * Вложенный класс здесь — не украшение, а весь смысл правки. JVM
     * инициализирует класс в момент первого активного использования и делает
     * это потокобезопасно, без единой блокировки в нашем коде (JLS 12.4).
     * Пока никто не позвал {@link #movies()} или соседей, {@code MovieHolder}
     * не инициализирован, {@link MovieRepository} не построен и датасет не
     * развёрнут в память.
     * <p>
     * Будь поле объявлено прямо в {@code Base}, оно бы читалось при загрузке
     * {@code Base} — то есть при создании <b>любой</b> задачи, даже про страны,
     * даже если данные ей не нужны вовсе. А это миллионы записей: 388 269
     * фильмов, 817 718 актёров, 3 431 966 ролей.
     */
    private static final class MovieHolder {
        private static final MovieService SERVICE =
                new MovieServiceImpl(new MovieRepository());
    }

    /**
     * Держатель данных о мире — отдельно от фильмов, и это намеренно.
     * <p>
     * Один держатель на двоих означал бы, что задача про страны платит
     * за фильмы, а задача про фильмы — за страны. Раздельные держатели
     * инициализируются независимо: берётся только то, что спросили.
     */
    private static final class WorldHolder {
        private static final WorldService SERVICE =
                new WorldServiceImpl(new WorldRepository());
    }

    /**
     * Держатель данных «Авиаперевозки» — третий, по той же причине: задача про фильмы не платит
     * за авиа. Данные авиа не лежат в кузнице: при первом обращении к таблице её файл скачивается
     * из выпуска {@code hammerhall-data} в {@code ~/.hammerhall/data/} и дальше берётся с диска
     * (см. {@link AirRepository}).
     */
    private static final class AirHolder {
        private static final AirService SERVICE =
                new AirServiceImpl(new AirRepository());
    }

    protected Collection<Movie> movies() {
        return MovieHolder.SERVICE.findAllMovies();
    }

    protected Collection<Genre> genres() {
        return MovieHolder.SERVICE.findAllGenres();
    }

    protected Collection<Director> directors() {
        return MovieHolder.SERVICE.findAllDirectors();
    }

    protected Collection<Actor> actors() {
        return MovieHolder.SERVICE.findAllActors();
    }

    protected Collection<Role> roles() {
        return MovieHolder.SERVICE.findAllRoles();
    }

    protected Collection<DirectorGenre> directorGenres() {
        return MovieHolder.SERVICE.findAllDirectorGenres();
    }

    protected Collection<Country> countries() {
        return WorldHolder.SERVICE.findAllCountries();
    }

    protected Collection<City> cities() {
        return WorldHolder.SERVICE.findAllCities();
    }

    protected Collection<CountryLanguage> languages() {
        return WorldHolder.SERVICE.findAllLanguages();
    }

    // ---------------------------------------------------------------- авиаперевозки

    // Малые таблицы — коллекциями: читаются один раз и держатся в памяти.

    protected Collection<Airport> airports() {
        return AirHolder.SERVICE.findAllAirports();
    }

    protected Collection<Airplane> airplanes() {
        return AirHolder.SERVICE.findAllAirplanes();
    }

    protected Collection<Seat> seats() {
        return AirHolder.SERVICE.findAllSeats();
    }

    protected Collection<Route> routes() {
        return AirHolder.SERVICE.findAllRoutes();
    }

    protected Collection<Flight> flights() {
        return AirHolder.SERVICE.findAllFlights();
    }

    // Большие таблицы — потоками: десятки миллионов строк в память не помещаются, поэтому
    // каждый вызов читает файл заново, строка за строкой. Поток одноразовый — нужен второй
    // проход, зови метод ещё раз. Бросаешь поток на полпути — закрой его: try (var s = …) { … }.

    protected Stream<Booking> bookings() {
        return AirHolder.SERVICE.streamBookings();
    }

    protected Stream<Ticket> tickets() {
        return AirHolder.SERVICE.streamTickets();
    }

    protected Stream<Segment> segments() {
        return AirHolder.SERVICE.streamSegments();
    }

    protected Stream<BoardingPass> boardingPasses() {
        return AirHolder.SERVICE.streamBoardingPasses();
    }
}
