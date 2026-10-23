package io.hammerhall.streamforge.domain.air;

/** Класс обслуживания: эконом, комфорт, бизнес. В данных — {@code Economy}, {@code Comfort}, {@code Business}. */
public enum FareConditions {
    ECONOMY("Economy"),
    COMFORT("Comfort"),
    BUSINESS("Business");

    private final String label;

    FareConditions(String label) {
        this.label = label;
    }

    /** Как класс записан в данных. */
    public String label() {
        return label;
    }

    /** Класс по записи в данных: {@code Economy} → {@link #ECONOMY}. */
    public static FareConditions of(String label) {
        for (FareConditions value : values()) {
            if (value.label.equals(label)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Нет такого класса обслуживания: " + label);
    }
}
