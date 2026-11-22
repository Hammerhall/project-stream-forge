package io.hammerhall.streamforge.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.GZIPInputStream;

/**
 * Чтение таблицы TSV.gz потоком: строка за строкой, без загрузки файла в память.
 *
 * <p>Формат наборов {@code hammerhall-data}: UTF-8, разделитель — табуляция, первая строка —
 * заголовок, пустое поле — NULL, файл сжат gzip. Заголовок сверяется с ожидаемым: поменялся
 * формат — падение сразу, с понятным текстом, а не странные значения в задаче.
 *
 * <p>Поток закрывает файл сам, когда строки кончились. Если поток бросили на полпути
 * ({@code findFirst}, {@code limit}), файл закроется по {@code close()} — то есть в
 * {@code try (var rows = …)}; без него — когда до объекта доберётся сборщик мусора.
 */
public final class Tsv {

    private Tsv() {
    }

    /**
     * Строки таблицы — массивы полей; пустое поле — пустая строка.
     *
     * @param file   файл {@code .tsv.gz}
     * @param header ожидаемый заголовок, по порядку
     */
    public static Stream<String[]> rows(Path file, List<String> header) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new GZIPInputStream(Files.newInputStream(file), 1 << 16), StandardCharsets.UTF_8), 1 << 16);
        } catch (IOException e) {
            throw new UncheckedIOException("Не открыть " + file, e);
        }
        try {
            String first = reader.readLine();
            List<String> actual = first == null ? List.of() : List.of(first.split("\t", -1));
            if (!actual.equals(header)) {
                throw new IllegalStateException("Заголовок " + file.getFileName() + " не тот: " + actual
                        + " вместо " + header);
            }
        } catch (IOException | RuntimeException e) {
            closeQuietly(reader);
            if (e instanceof IOException io) {
                throw new UncheckedIOException("Не прочитать заголовок " + file, io);
            }
            throw (RuntimeException) e;
        }
        int width = header.size();
        Spliterator<String[]> lines = new Spliterators.AbstractSpliterator<>(Long.MAX_VALUE,
                Spliterator.ORDERED | Spliterator.NONNULL) {
            private boolean done;

            @Override
            public boolean tryAdvance(Consumer<? super String[]> action) {
                if (done) {
                    return false;
                }
                String line;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    done = true;
                    closeQuietly(reader);
                    throw new UncheckedIOException("Ошибка чтения " + file, e);
                }
                if (line == null) {
                    done = true;
                    closeQuietly(reader);
                    return false;
                }
                String[] fields = line.split("\t", -1);
                if (fields.length != width) {
                    throw new IllegalStateException("В " + file.getFileName() + " строка из " + fields.length
                            + " полей вместо " + width + ": " + line);
                }
                action.accept(fields);
                return true;
            }
        };
        return StreamSupport.stream(lines, false).onClose(() -> closeQuietly(reader));
    }

    private static void closeQuietly(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException ignored) {
            // закрываем при выходе — ошибка закрытия ничего уже не меняет
        }
    }
}
