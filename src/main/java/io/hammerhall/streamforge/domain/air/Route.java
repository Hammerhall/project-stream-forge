package io.hammerhall.streamforge.domain.air;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Маршрут в одной из своих версий. Расписание пересобирается помесячно: у одного номера
 * маршрута — несколько записей с разными периодами действия, а в них может меняться модель
 * самолёта и дни недели. Версия маршрута для рейса — та, чей период содержит плановый вылет.
 *
 * @param routeNo          номер маршрута: {@code PG0001}
 * @param validFrom        начало периода действия, включительно
 * @param validTo          конец периода действия, не включительно
 * @param departureAirport код аэропорта вылета
 * @param arrivalAirport   код аэропорта прилёта
 * @param airplaneCode     код модели самолёта
 * @param daysOfWeek       дни недели, по которым летает, — по местному времени вылета
 * @param scheduledTime    местное время вылета по расписанию
 * @param duration         плановая длительность полёта
 */
public record Route(String routeNo, Instant validFrom, Instant validTo, String departureAirport,
                    String arrivalAirport, String airplaneCode, Set<DayOfWeek> daysOfWeek,
                    LocalTime scheduledTime, Duration duration) {
    public Route {
        Objects.requireNonNull(routeNo, "routeNo");
        Objects.requireNonNull(validFrom, "validFrom");
        Objects.requireNonNull(validTo, "validTo");
        Objects.requireNonNull(departureAirport, "departureAirport");
        Objects.requireNonNull(arrivalAirport, "arrivalAirport");
        Objects.requireNonNull(airplaneCode, "airplaneCode");
        Objects.requireNonNull(daysOfWeek, "daysOfWeek");
        Objects.requireNonNull(scheduledTime, "scheduledTime");
        Objects.requireNonNull(duration, "duration");
        // EnumSet — дни по порядку, с понедельника; снаружи — только чтение
        daysOfWeek = Collections.unmodifiableSet(
                daysOfWeek.isEmpty() ? EnumSet.noneOf(DayOfWeek.class) : EnumSet.copyOf(daysOfWeek));
    }
}
