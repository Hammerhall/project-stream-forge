package io.hammerhall.streamforge.domain.air;

import java.time.ZoneId;
import java.util.Objects;

/**
 * Аэропорт. В справочнике — все аэропорты мира (5 501), рейсы летают между 73 из них.
 *
 * @param code      код IATA, три буквы: {@code SVO}
 * @param nameEn    название по-английски
 * @param nameRu    название по-русски
 * @param cityEn    город по-английски
 * @param cityRu    город по-русски
 * @param countryEn страна по-английски
 * @param countryRu страна по-русски
 * @param longitude долгота, градусы: восток — плюс
 * @param latitude  широта, градусы: север — плюс
 * @param timezone  часовой пояс аэропорта — по нему местное время вылетов и прилётов
 */
public record Airport(String code, String nameEn, String nameRu, String cityEn, String cityRu,
                      String countryEn, String countryRu, double longitude, double latitude, ZoneId timezone) {
    public Airport {
        Objects.requireNonNull(code, "code");
        Objects.requireNonNull(nameEn, "nameEn");
        Objects.requireNonNull(nameRu, "nameRu");
        Objects.requireNonNull(cityEn, "cityEn");
        Objects.requireNonNull(cityRu, "cityRu");
        Objects.requireNonNull(countryEn, "countryEn");
        Objects.requireNonNull(countryRu, "countryRu");
        Objects.requireNonNull(timezone, "timezone");
    }
}
