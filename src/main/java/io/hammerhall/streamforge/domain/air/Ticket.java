package io.hammerhall.streamforge.domain.air;

import java.util.Objects;

/**
 * Билет одного пассажира в одну сторону; перелёты билета — его {@link Segment сегменты}.
 * Поездка туда и обратно — два билета в одной брони.
 *
 * @param ticketNo      номер билета, 13 цифр
 * @param bookRef       номер брони
 * @param passengerId   документ пассажира: код страны и номер, {@code IT 2425980678984}
 * @param passengerName имя и фамилия латиницей
 * @param outbound      {@code true} — билет «туда», {@code false} — «обратно»
 */
public record Ticket(String ticketNo, String bookRef, String passengerId, String passengerName, boolean outbound) {
    public Ticket {
        Objects.requireNonNull(ticketNo, "ticketNo");
        Objects.requireNonNull(bookRef, "bookRef");
        Objects.requireNonNull(passengerId, "passengerId");
        Objects.requireNonNull(passengerName, "passengerName");
    }
}
