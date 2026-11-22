package io.hammerhall.streamforge.domain.air;

import java.util.Objects;

/**
 * Место в салоне модели самолёта.
 *
 * @param airplaneCode   код модели
 * @param seatNo         номер места: ряд и буква, {@code 12C}
 * @param fareConditions класс, к которому место относится
 */
public record Seat(String airplaneCode, String seatNo, FareConditions fareConditions) {
    public Seat {
        Objects.requireNonNull(airplaneCode, "airplaneCode");
        Objects.requireNonNull(seatNo, "seatNo");
        Objects.requireNonNull(fareConditions, "fareConditions");
    }
}
