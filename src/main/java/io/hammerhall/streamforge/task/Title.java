package io.hammerhall.streamforge.task;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Название задачи — то, что видит пользователь в каталоге и над классом.
 *
 * <p>Лежит рядом с {@link Base}: название едет к пользователю вместе с задачей, а служебные аннотации кузни
 * при публикации вырезаются вместе со своими пакетами (ADR-003, пересмотр 19.11.2026). Тестовый фреймворк для
 * названия не нужен — в основном коде кузни его нет.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Title {

    /** Название задачи. */
    String value();
}
