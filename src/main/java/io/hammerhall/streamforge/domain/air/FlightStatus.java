package io.hammerhall.streamforge.domain.air;

/**
 * Статус рейса на «сейчас» набора данных.
 *
 * <p>{@link #SCHEDULED} — до вылета больше суток; {@link #ON_TIME} — вылет в ближайшие сутки,
 * по расписанию; {@link #DELAYED} — в ближайшие сутки, но задерживается; {@link #BOARDING} —
 * идёт посадка; {@link #DEPARTED} — вылетел, ещё в воздухе; {@link #ARRIVED} — прилетел;
 * {@link #CANCELLED} — отменён.
 */
public enum FlightStatus {
    SCHEDULED("Scheduled"),
    ON_TIME("On Time"),
    DELAYED("Delayed"),
    BOARDING("Boarding"),
    DEPARTED("Departed"),
    ARRIVED("Arrived"),
    CANCELLED("Cancelled");

    private final String label;

    FlightStatus(String label) {
        this.label = label;
    }

    /** Как статус записан в данных. */
    public String label() {
        return label;
    }

    /** Статус по записи в данных: {@code On Time} → {@link #ON_TIME}. */
    public static FlightStatus of(String label) {
        for (FlightStatus value : values()) {
            if (value.label.equals(label)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Нет такого статуса рейса: " + label);
    }
}
