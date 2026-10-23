package io.hammerhall.streamforge.domain.air;

import java.time.Instant;
import java.util.Objects;

/**
 * Посадочный талон — выдаётся при регистрации на перелёт.
 *
 * @param ticketNo     номер билета
 * @param flightId     номер рейса
 * @param seatNo       номер места
 * @param boardingNo   номер в порядке посадки; {@code null} — зарегистрирован, на борт ещё не прошёл
 * @param boardingTime момент прохода на борт; {@code null} — ещё не прошёл
 */
public record BoardingPass(String ticketNo, int flightId, String seatNo, Integer boardingNo, Instant boardingTime) {
    public BoardingPass {
        Objects.requireNonNull(ticketNo, "ticketNo");
        Objects.requireNonNull(seatNo, "seatNo");
    }
}
