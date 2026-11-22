package io.hammerhall.streamforge.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.HexFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Набор данных из выпуска репозитория {@code hammerhall-data} — скачивается один раз,
 * дальше читается с диска.
 *
 * <p><b>Зачем.</b> Данные авиа — 790 МБ: в git им не место, в выпуск кузницы они не влезают.
 * Они лежат в выпуске GitHub ({@code air-data-v1}), а здесь — только паспорт набора: какие файлы,
 * какого размера, с какой контрольной суммой ({@code /data/<версия>.files} в ресурсах). Файл
 * качается при первом обращении к нему и только он: задача про аэропорты не тянет билеты.
 *
 * <p><b>Куда.</b> {@code ~/.hammerhall/data/<версия>/}. Переопределяется свойством
 * {@code -Dhammerhall.data.dir=…} или переменной {@code HAMMERHALL_DATA_DIR}; откуда качать —
 * {@code -Dhammerhall.data.url=…} или {@code HAMMERHALL_DATA_URL} (зеркало, тесты).
 *
 * <p><b>Почему не испортится.</b> Файл пишется во временный рядом, сумма SHA-256 считается на
 * лету и сверяется с паспортом; только совпавший файл переименовывается в настоящее имя.
 * Оборвалась связь, закончилось место, подменили файл — настоящего имени у битого файла не будет,
 * при следующем запуске он скачается заново. На диске файл признаётся своим по размеру; полная
 * сверка — {@link #verify(String)}.
 *
 * <p>Класс не знает ни про авиа, ни про Stream Forge — только про выпуск и паспорт. Им может
 * пользоваться любая кузница, которой нужны те же данные.
 */
public final class DataSet {

    /** Выпуски открытых наборов данных Hammerhall. */
    public static final String DEFAULT_URL = "https://github.com/Hammerhall/hammerhall-data/releases/download/";

    private final String version;
    private final Map<String, FileInfo> files;
    private final URI baseUrl;
    private final Path dir;

    /** Файл набора по паспорту: имя, размер в байтах, SHA-256 файла, число строк данных. */
    public record FileInfo(String name, long bytes, String sha256, long rows) {
        public FileInfo {
            Objects.requireNonNull(name, "name");
            Objects.requireNonNull(sha256, "sha256");
        }
    }

    private DataSet(String version, List<FileInfo> files, URI baseUrl, Path dir) {
        this.version = Objects.requireNonNull(version, "version");
        Map<String, FileInfo> byName = new LinkedHashMap<>();
        for (FileInfo f : files) {
            byName.put(f.name(), f);
        }
        this.files = Map.copyOf(byName);
        this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl");
        this.dir = Objects.requireNonNull(dir, "dir");
    }

    /**
     * Набор по версии выпуска: паспорт — из ресурса {@code /data/<версия>.files}, папка и адрес —
     * из настроек (см. описание класса).
     */
    public static DataSet of(String version) {
        String base = setting("hammerhall.data.url", "HAMMERHALL_DATA_URL", DEFAULT_URL);
        String root = setting("hammerhall.data.dir", "HAMMERHALL_DATA_DIR",
                Path.of(System.getProperty("user.home"), ".hammerhall", "data").toString());
        return new DataSet(version, readPassport(version),
                URI.create(base.endsWith("/") ? base : base + "/"), Path.of(root).resolve(version));
    }

    /**
     * Набор с явным паспортом, адресом и папкой — для тестов и зеркал. Обычный путь — {@link #of(String)}.
     *
     * @param baseUrl адрес выпусков; файл качается с {@code baseUrl + версия + "/" + имя}
     */
    public static DataSet of(String version, List<FileInfo> files, URI baseUrl, Path dir) {
        return new DataSet(version, files, baseUrl, dir);
    }

    public String version() {
        return version;
    }

    /** Папка набора на диске. */
    public Path dir() {
        return dir;
    }

    /** Паспорт файла — размер, сумма, число строк. */
    public FileInfo info(String name) {
        FileInfo info = files.get(name);
        if (info == null) {
            throw new IllegalArgumentException("В наборе " + version + " нет файла " + name
                    + "; есть: " + files.keySet());
        }
        return info;
    }

    /**
     * Путь к файлу набора на диске; если файла нет — скачивает и сверяет.
     *
     * @throws IllegalStateException если скачать не удалось — с адресом, по которому файл можно
     *                               взять руками, и папкой, куда его положить
     */
    public synchronized Path file(String name) {
        FileInfo info = info(name);
        Path target = dir.resolve(name);
        try {
            if (Files.isRegularFile(target) && Files.size(target) == info.bytes()) {
                return target;
            }
            Files.createDirectories(dir);
            download(info, target);
            return target;
        } catch (IOException e) {
            throw new IllegalStateException(failure(info, e.getMessage()), e);
        }
    }

    /** Полная сверка файла на диске с паспортом: скачивает, если нужно, и считает SHA-256 заново. */
    public boolean verify(String name) {
        Path path = file(name);
        try (InputStream in = Files.newInputStream(path)) {
            MessageDigest digest = sha256();
            byte[] buffer = new byte[1 << 16];
            for (int n; (n = in.read(buffer)) > 0; ) {
                digest.update(buffer, 0, n);
            }
            return HexFormat.of().formatHex(digest.digest()).equals(info(name).sha256());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void download(FileInfo info, Path target) throws IOException {
        URI url = baseUrl.resolve(version + "/" + info.name());
        System.out.printf("Набор %s: скачиваю %s (%s) — один раз, дальше он берётся с диска: %s%n",
                version, info.name(), megabytes(info.bytes()), dir);
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .proxy(ProxySelector.getDefault())
                .connectTimeout(Duration.ofSeconds(30))
                .build();
        HttpResponse<InputStream> response;
        try {
            response = client.send(HttpRequest.newBuilder(url).GET().build(),
                    HttpResponse.BodyHandlers.ofInputStream());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("скачивание прервано", e);
        }
        if (response.statusCode() != 200) {
            response.body().close();
            throw new IOException("сервер ответил " + response.statusCode() + " на " + url);
        }
        Path part = Files.createTempFile(dir, info.name() + ".", ".part");
        try {
            MessageDigest digest = sha256();
            long written = 0;
            int shownPercent = 0;
            try (InputStream in = response.body(); OutputStream out = Files.newOutputStream(part)) {
                byte[] buffer = new byte[1 << 16];
                for (int n; (n = in.read(buffer)) > 0; ) {
                    out.write(buffer, 0, n);
                    digest.update(buffer, 0, n);
                    written += n;
                    int percent = info.bytes() > 0 ? (int) (written * 100 / info.bytes()) : 100;
                    if (percent >= shownPercent + 10 && info.bytes() >= (8L << 20)) {
                        shownPercent = percent - percent % 10;
                        System.out.printf("  %s: %d %%%n", info.name(), shownPercent);
                    }
                }
            }
            String sha = HexFormat.of().formatHex(digest.digest());
            if (written != info.bytes() || !sha.equals(info.sha256())) {
                throw new IOException("файл не совпал с паспортом: " + written + " байт вместо "
                        + info.bytes() + ", сумма " + sha);
            }
            try {
                Files.move(part, target, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(part, target, StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.printf("  %s: готово%n", info.name());
        } finally {
            Files.deleteIfExists(part);
        }
    }

    private String failure(FileInfo info, String reason) {
        return "Не удалось получить файл " + info.name() + " набора " + version + ": " + reason + ".\n"
                + "Проверь интернет и запусти ещё раз. Или скачай файл руками:\n  "
                + baseUrl.resolve(version + "/" + info.name()) + "\n"
                + "и положи его сюда:\n  " + dir.resolve(info.name());
    }

    private static List<FileInfo> readPassport(String version) {
        String resource = "/data/" + version + ".files";
        InputStream in = DataSet.class.getResourceAsStream(resource);
        if (in == null) {
            throw new IllegalStateException("Нет паспорта набора в ресурсах: " + resource);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .filter(line -> !line.isBlank() && !line.startsWith("#"))
                    .map(line -> {
                        String[] f = line.split("\t");
                        if (f.length != 4) {
                            throw new IllegalStateException("Строка паспорта " + resource + " — не 4 поля: " + line);
                        }
                        return new FileInfo(f[0], Long.parseLong(f[1]), f[2], Long.parseLong(f[3]));
                    })
                    .toList();
        } catch (IOException e) {
            throw new UncheckedIOException("Не прочитан паспорт " + resource, e);
        }
    }

    private static String setting(String property, String env, String fallback) {
        String value = System.getProperty(property);
        if (value == null || value.isBlank()) {
            value = System.getenv(env);
        }
        return value == null || value.isBlank() ? fallback : value;
    }

    private static MessageDigest sha256() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String megabytes(long bytes) {
        return bytes >= (1L << 20) ? "%.0f МБ".formatted(bytes / 1e6) : "%d КБ".formatted(Math.max(1, bytes / 1000));
    }
}
