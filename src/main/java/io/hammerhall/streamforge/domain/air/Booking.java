package io.hammerhall.streamforge.domain.air;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * Бронирование: одна покупка, в ней — билеты одного или нескольких пассажиров.
 *
 * @param bookRef     номер брони, шесть знаков
 * @param bookDate    момент покупки
 * @param totalAmount сумма, ₽ — равна сумме цен всех сегментов её билетов
 */
public record Booking(String bookRef, Instant bookDate, BigDecimal totalAmount) {
    public Booking {
        Objects.requireNonNull(bookRef, "bookRef");
        Objects.requireNonNull(bookDate, "bookDate");
        Objects.requireNonNull(totalAmount, "totalAmount");
    }
}
