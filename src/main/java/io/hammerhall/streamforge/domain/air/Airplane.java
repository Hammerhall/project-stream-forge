package io.hammerhall.streamforge.domain.air;

import java.util.Objects;

/**
 * Модель самолёта. Две грузовые модели в справочнике есть, но мест и маршрутов у них нет.
 *
 * @param code     код модели IATA: {@code 77W}
 * @param modelEn  модель по-английски
 * @param modelRu  модель по-русски
 * @param rangeKm  наибольшая дальность полёта, км
 * @param speedKmh крейсерская скорость, км/ч
 */
public record Airplane(String code, String modelEn, String modelRu, int rangeKm, int speedKmh) {
    public Airplane {
        Objects.requireNonNull(code, "code");
        Objects.requireNonNull(modelEn, "modelEn");
        Objects.requireNonNull(modelRu, "modelRu");
    }
}
