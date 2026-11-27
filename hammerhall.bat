@echo off
REM ============================================================
REM  Hammerhall CLI — обёртка-загрузчик для Windows.
REM  Логика та же, что в hammerhall: скачать при первом запуске,
REM  сверить сумму, дальше просто запускать.
REM
REM  ── Как приезжает обновление ────────────────────────────────
REM  Версия закреплена ЗДЕСЬ и входит в имя файла. Подняли версию —
REM  обёртка не находит jar и качает новый, то есть обновление
REM  доезжает вместе с `git pull` кузницы.
REM
REM  НИКОГДА не перевыкладывайте один номер версии с другим
REM  содержимым: имя файла то же, обёртка считает клиент скачанным,
REM  и человек навсегда остаётся со старым.
REM
REM  ── Сумма — до первого запуска (с 0.2.0) ────────────────────
REM  Рядом с jar в релизе лежит cli-<версия>.jar.sha256 — одна строка
REM  формата sha256sum. PowerShell скачивает jar во временный файл,
REM  сверяет его Get-FileHash с этой строкой и только тогда даёт ему
REM  настоящее имя; не сошлось — файл удаляется, клиент не запускается.
REM  Адрес и путь PowerShell берёт из переменных окружения JAR и URL,
REM  а не из текста команды: апостроф в имени пользователя (O'Neil)
REM  не ломает кавычки. Коды выхода PowerShell: 2 — не скачался jar,
REM  4 — не скачалась сумма, 3 — сумма не сошлась.
REM
REM  `hammerhall update` — принудительно перекачать. Перехватывается
REM  ДО запуска java: на Windows работающий jar заблокирован, и сам
REM  себя клиент заменить не может.
REM
REM  ⚠️ EnableDelayedExpansion обязателен. Раньше URL собирался внутри
REM  блока if (...) через %URL%, а cmd подставляет переменные при
REM  разборе ВСЕГО блока — то есть до того, как set выполнится.
REM  В powershell уезжал пустой адрес, и загрузка молча не работала.
REM  Внутри блоков переменные читаются только как !URL!. И поэтому же
REM  в строке PowerShell нет восклицательных знаков.
REM
REM  ── Кодировка консоли ───────────────────────────────────────
REM  chcp 65001 переводит консоль в UTF-8 — с 0.2.0 сразу, первой
REM  командой: этот файл записан в UTF-8, и до переключения cmd читал
REM  русские строки самой обёртки («Загружаю клиент…») в cp866 —
REM  выходила каша. Клиент и без этого читаем: привязанный к консоли,
REM  он кодирует вывод её страницей сам; но в cp866 нет ни длинного
REM  тире, ни значков ✓ ⚠ ✗.
REM
REM  Страница меняется только в этом окне и только на время команды:
REM  прежняя запоминается и возвращается на любом выходе — все пути
REM  ведут в :end.
REM ============================================================
setlocal EnableDelayedExpansion

REM Номер страницы — из второго поля вывода chcp: текст вокруг переведён,
REM число — нет.
set PAGE=
for /f "tokens=2 delims=:" %%p in ('chcp') do set PAGE=%%p
set PAGE=%PAGE: =%
chcp 65001 >nul

set VERSION=0.2.0
set REPO=Hammerhall/hammerhall-cli

set ROOT=%~dp0
set DIR=%ROOT%.hammerhall
set JAR=%DIR%\cli-%VERSION%.jar
set URL=https://github.com/%REPO%/releases/download/v%VERSION%/cli-%VERSION%.jar
set CODE=0

where java >nul 2>nul
if errorlevel 1 (
    echo Нужна Java. Она же нужна, чтобы решать задачи — поставьте JDK 25.
    set CODE=1
    goto :end
)

if /i "%~1"=="update" (
    if exist "%DIR%" del /q "%DIR%\cli-*.jar" 2>nul
    if exist "%DIR%" del /q "%DIR%\*.part" 2>nul
    call :download
    if errorlevel 1 (
        set CODE=1
        goto :end
    )
    echo Клиент обновлён до %VERSION%.
    goto :end
)

if not exist "%JAR%" (
    call :download
    if errorlevel 1 (
        set CODE=1
        goto :end
    )
)

java -jar "%JAR%" %*
set CODE=%errorlevel%

:end
if not "%PAGE%"=="" chcp %PAGE% >nul
exit /b %CODE%

:download
echo Загружаю клиент %VERSION%...
if not exist "%DIR%" mkdir "%DIR%"
REM Во временный файл, потом переименование: оборвётся связь на середине —
REM останется мусор с временным именем, а не битый jar под правильным.
REM Имя jar получает только после сверки суммы.
powershell -NoProfile -Command "$ErrorActionPreference='Stop'; $ProgressPreference='SilentlyContinue'; try { [Net.ServicePointManager]::SecurityProtocol = [Net.ServicePointManager]::SecurityProtocol -bor 3072 } catch {}; $w = New-Object Net.WebClient; $p = $env:JAR + '.part'; try { $w.DownloadFile($env:URL, $p) } catch { Remove-Item -Force -ErrorAction SilentlyContinue -LiteralPath $p; exit 2 }; try { $s = $w.DownloadString($env:URL + '.sha256') } catch { Remove-Item -Force -LiteralPath $p; exit 4 }; $want = ($s.Trim() -split '\s+')[0].ToLower(); $got = (Get-FileHash -Algorithm SHA256 -LiteralPath $p).Hash.ToLower(); if (($want -notmatch '^[0-9a-f]{64}$') -or ($got -ne $want)) { Remove-Item -Force -LiteralPath $p; [Console]::Error.WriteLine('  want: ' + $want); [Console]::Error.WriteLine('  got:  ' + $got); exit 3 }; Move-Item -Force -LiteralPath $p -Destination $env:JAR; exit 0"
set DL=%errorlevel%
if "%DL%"=="0" goto :downloaded
if "%DL%"=="3" (
    echo Скачанный клиент не совпал с опубликованной суммой — файл удалён, запускать не буду.
    echo Повторите позже. Не проходит — напишите нам: это может быть подмена по дороге.
    exit /b 1
)
if "%DL%"=="4" (
    echo Не удалось скачать сумму клиента — проверьте связь: %URL%.sha256
    exit /b 1
)
echo Не удалось скачать клиент — проверьте связь: %URL%
exit /b 1

:downloaded
REM Прошлые версии больше не нужны: обёртка запускает только свою.
for %%f in ("%DIR%\cli-*.jar") do (
    if /i not "%%~nxf"=="cli-%VERSION%.jar" del /q "%%f" >nul 2>nul
)
exit /b 0
