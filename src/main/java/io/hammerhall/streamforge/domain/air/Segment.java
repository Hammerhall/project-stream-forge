package io.hammerhall.streamforge.domain.air;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Сегмент — один перелёт по билету: билет с пересадкой состоит из нескольких сегментов.
 * Порядок перелётов билета — по плановому вылету их рейсов.
 *
 * @param ticketNo       номер билета
 * @param flightId       номер рейса
 * @param fareConditions класс обслуживания на этом перелёте
 * @param price          цена перелёта, ₽
 */
public record Segment(String ticketNo, int flightId, FareConditions fareConditions, BigDecimal price) {
    public Segment {
        Objects.requireNonNull(ticketNo, "ticketNo");
        Objects.requireNonNull(fareConditions, "fareConditions");
        Objects.requireNonNull(price, "price");
    }
}
