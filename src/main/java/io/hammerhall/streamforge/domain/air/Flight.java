package io.hammerhall.streamforge.domain.air;

import java.time.Instant;
import java.util.Objects;

/**
 * Рейс — один вылет маршрута в конкретный день.
 *
 * <p>Моменты — {@link Instant}, то есть UTC. Местное время — через часовой пояс аэропорта:
 * {@code scheduledDeparture().atZone(airport.timezone())}.
 *
 * @param flightId           номер рейса в данных
 * @param routeNo            номер маршрута
 * @param status             статус на «сейчас» набора
 * @param scheduledDeparture плановый вылет
 * @param scheduledArrival   плановый прилёт
 * @param actualDeparture    фактический вылет; {@code null} — ещё не вылетел или отменён
 * @param actualArrival      фактический прилёт; {@code null} — ещё не прилетел или отменён
 */
public record Flight(int flightId, String routeNo, FlightStatus status, Instant scheduledDeparture,
                     Instant scheduledArrival, Instant actualDeparture, Instant actualArrival) {
    public Flight {
        Objects.requireNonNull(routeNo, "routeNo");
        Objects.requireNonNull(status, "status");
        Objects.requireNonNull(scheduledDeparture, "scheduledDeparture");
        Objects.requireNonNull(scheduledArrival, "scheduledArrival");
    }
}
