package io.hammerhall.streamforge.repository;

import io.hammerhall.streamforge.data.DataSet;
import io.hammerhall.streamforge.data.Tsv;
import io.hammerhall.streamforge.domain.air.Airplane;
import io.hammerhall.streamforge.domain.air.Airport;
import io.hammerhall.streamforge.domain.air.BoardingPass;
import io.hammerhall.streamforge.domain.air.Booking;
import io.hammerhall.streamforge.domain.air.FareConditions;
import io.hammerhall.streamforge.domain.air.Flight;
import io.hammerhall.streamforge.domain.air.FlightStatus;
import io.hammerhall.streamforge.domain.air.Route;
import io.hammerhall.streamforge.domain.air.Seat;
import io.hammerhall.streamforge.domain.air.Segment;
import io.hammerhall.streamforge.domain.air.Ticket;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Данные «Авиаперевозки» — набор {@code air-data-v1} из выпусков {@code hammerhall-data}
 * (демобаза Postgres Pro «Авиаперевозки» 2.0, MIT © 2025 Postgres Professional; что изменено
 * против исходной выгрузки — {@code SOURCE.md} выпуска).
 *
 * <p><b>Малые таблицы — в памяти, большие — потоком.</b> Аэропорты, самолёты, места, маршруты
 * и рейсы — 150 тысяч строк — читаются один раз и держатся списком. Брони, билеты, сегменты
 * и посадочные талоны — 74 миллиона строк — в память не помещаются: каждый вызов открывает
 * файл заново и отдаёт {@link Stream}, строка за строкой. Проход по 24 миллионам сегментов —
 * пара секунд и килобайты памяти, а не гигабайты.
 *
 * <p>Таблица читается при первом обращении к ней: задача про аэропорты не тянет билеты. Файлы
 * скачиваются тоже по одному — при первом обращении (см. {@link DataSet}).
 *
 * <p>Внешние ключи — по коду и номеру, как в базе: {@code flight.routeNo()},
 * {@code segment.flightId()}. Соединения — работа задачи, а не загрузчика.
 */
public class AirRepository {

    /** Версия набора в выпусках {@code hammerhall-data}. */
    public static final String DATA_VERSION = "air-data-v1";

    static final List<String> AIRPORTS = List.of("airport_code", "name_en", "name_ru", "city_en", "city_ru",
            "country_en", "country_ru", "longitude", "latitude", "timezone");
    static final List<String> AIRPLANES = List.of("airplane_code", "model_en", "model_ru", "range_km", "speed_kmh");
    static final List<String> SEATS = List.of("airplane_code", "seat_no", "fare_conditions");
    static final List<String> ROUTES = List.of("route_no", "valid_from", "valid_to", "departure_airport",
            "arrival_airport", "airplane_code", "days_of_week", "scheduled_time", "duration_min");
    static final List<String> FLIGHTS = List.of("flight_id", "route_no", "status", "scheduled_departure",
            "scheduled_arrival", "actual_departure", "actual_arrival");
    static final List<String> BOOKINGS = List.of("book_ref", "book_date", "total_amount");
    static final List<String> TICKETS = List.of("ticket_no", "book_ref", "passenger_id", "passenger_name", "outbound");
    static final List<String> SEGMENTS = List.of("ticket_no", "flight_id", "fare_conditions", "price");
    static final List<String> BOARDING_PASSES = List.of("ticket_no", "flight_id", "seat_no", "boarding_no",
            "boarding_time");

    private final DataSet data;

    private volatile List<Airport> airports;
    private volatile List<Airplane> airplanes;
    private volatile List<Seat> seats;
    private volatile List<Route> routes;
    private volatile List<Flight> flights;

    public AirRepository() {
        this(DataSet.of(DATA_VERSION));
    }

    public AirRepository(DataSet data) {
        this.data = data;
    }

    public List<Airport> airports() {
        List<Airport> result = airports;
        if (result == null) {
            synchronized (this) {
                if (airports == null) {
                    airports = load("airports.tsv.gz", AIRPORTS, AirRepository::airport);
                }
                result = airports;
            }
        }
        return result;
    }

    public List<Airplane> airplanes() {
        List<Airplane> result = airplanes;
        if (result == null) {
            synchronized (this) {
                if (airplanes == null) {
                    airplanes = load("airplanes.tsv.gz", AIRPLANES, AirRepository::airplane);
                }
                result = airplanes;
            }
        }
        return result;
    }

    public List<Seat> seats() {
        List<Seat> result = seats;
        if (result == null) {
            synchronized (this) {
                if (seats == null) {
                    seats = load("seats.tsv.gz", SEATS, AirRepository::seat);
                }
                result = seats;
            }
        }
        return result;
    }

    public List<Route> routes() {
        List<Route> result = routes;
        if (result == null) {
            synchronized (this) {
                if (routes == null) {
                    routes = load("routes.tsv.gz", ROUTES, AirRepository::route);
                }
                result = routes;
            }
        }
        return result;
    }

    public List<Flight> flights() {
        List<Flight> result = flights;
        if (result == null) {
            synchronized (this) {
                if (flights == null) {
                    flights = load("flights.tsv.gz", FLIGHTS, AirRepository::flight);
                }
                result = flights;
            }
        }
        return result;
    }

    /** Брони — потоком из файла; каждый вызов — новый поток. */
    public Stream<Booking> bookings() {
        return stream("bookings.tsv.gz", BOOKINGS, AirRepository::booking);
    }

    /** Билеты — потоком из файла; каждый вызов — новый поток. */
    public Stream<Ticket> tickets() {
        return stream("tickets.tsv.gz", TICKETS, AirRepository::ticket);
    }

    /** Сегменты (перелёты по билетам) — потоком из файла; каждый вызов — новый поток. */
    public Stream<Segment> segments() {
        return stream("segments.tsv.gz", SEGMENTS, AirRepository::segment);
    }

    /** Посадочные талоны — потоком из файла; каждый вызов — новый поток. */
    public Stream<BoardingPass> boardingPasses() {
        return stream("boarding_passes.tsv.gz", BOARDING_PASSES, AirRepository::boardingPass);
    }

    private <T> List<T> load(String file, List<String> header, Function<String[], T> mapper) {
        try (Stream<T> rows = stream(file, header, mapper)) {
            return rows.toList();
        }
    }

    private <T> Stream<T> stream(String file, List<String> header, Function<String[], T> mapper) {
        return Tsv.rows(data.file(file), header).map(mapper);
    }

    // ---------------------------------------------------------------- строка → запись

    static Airport airport(String[] f) {
        return new Airport(f[0], f[1], f[2], f[3], f[4], f[5], f[6],
                Double.parseDouble(f[7]), Double.parseDouble(f[8]), ZoneId.of(f[9]));
    }

    static Airplane airplane(String[] f) {
        return new Airplane(f[0], f[1], f[2], Integer.parseInt(f[3]), Integer.parseInt(f[4]));
    }

    static Seat seat(String[] f) {
        return new Seat(f[0], f[1], FareConditions.of(f[2]));
    }

    static Route route(String[] f) {
        Set<DayOfWeek> days = EnumSet.noneOf(DayOfWeek.class);
        for (String day : f[6].split(",")) {
            days.add(DayOfWeek.of(Integer.parseInt(day.trim())));
        }
        return new Route(f[0], instant(f[1]), instant(f[2]), f[3], f[4], f[5], days,
                LocalTime.parse(f[7]), Duration.ofMinutes(Long.parseLong(f[8])));
    }

    static Flight flight(String[] f) {
        return new Flight(Integer.parseInt(f[0]), f[1], FlightStatus.of(f[2]),
                instant(f[3]), instant(f[4]), instantOrNull(f[5]), instantOrNull(f[6]));
    }

    static Booking booking(String[] f) {
        return new Booking(f[0], instant(f[1]), new BigDecimal(f[2]));
    }

    static Ticket ticket(String[] f) {
        return new Ticket(f[0], f[1], f[2], f[3], bool(f[4]));
    }

    static Segment segment(String[] f) {
        return new Segment(f[0], Integer.parseInt(f[1]), FareConditions.of(f[2]), new BigDecimal(f[3]));
    }

    static BoardingPass boardingPass(String[] f) {
        return new BoardingPass(f[0], Integer.parseInt(f[1]), f[2],
                f[3].isEmpty() ? null : Integer.valueOf(f[3]), instantOrNull(f[4]));
    }

    private static Instant instant(String epochSeconds) {
        return Instant.ofEpochSecond(Long.parseLong(epochSeconds));
    }

    private static Instant instantOrNull(String epochSeconds) {
        return epochSeconds.isEmpty() ? null : instant(epochSeconds);
    }

    private static boolean bool(String value) {
        return switch (value) {
            case "t" -> true;
            case "f" -> false;
            default -> throw new IllegalArgumentException("Не t и не f: " + value);
        };
    }
}
