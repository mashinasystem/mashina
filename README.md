Docker

Для установки docker на windows:
Для pro версий скачать Docker и подключить X-Hyper
Для версии home и ниже используется Docker Toolbox и Oracle VM

Поднятие машины производится через Docker quickstart terminal
docker-compose -f <путь\файл.yml> up
Либо с помощью cd команды перейти в нужную директорию, и после вызвать команду выше уже без указания пути
ВАЖНО: в указании путей не должно быть русских букв и пробелов

Для входа в контейнер:
docker exec -it <container_name> /bin/bash - заходит в выбранный контейнер.

Для доступа к базе:
docker ps -a для проверки всех подключенных контейнеров
psql -U <user> <basa> для входа в базу данных
-l для вывода всех таблиц в БД

ВАЖНО: Необходимо прокинуть порты на ВМ. Делается это следующим образом:
<VM> -> Настроить -> Сеть -> Дополнительно -> Проброс портов
Для хоста указывается любой свободный порт на локальной машине
Для гостя порт 5432

По всем вопросам писать в слак или на корпоративную почту:
emil_ivochkin@epam.com

Установка lombok:
Необходимые строки добавлены в билд градл.
Необходимо скачать плагин:
Setting -> Plugins -> lombok -> download;
После утановки необходимо перезагрузить IDEA;
для использования необходимо импортировать в нужный класс.



Gradle instrctions

The way it works:

1. Clone / download / pull the repository from a remote repo

2. Open as a gradle project and switch to the branch with gradle project

3. Type "gradle build" to a command line to build a project (maybe optional)

4. Type "gradle appStart" or "gradle appRun" to a command line tu run a app
(or click that task in gretty tasks)

5. Type "gradle appStop" to a command line to stop the app
(or click that task in gretty tasks)



FlyWay instrctions

There are two .sql files in src/main/resources/db/migrations. The first one creates the database, the second one fills it with data.

To execute database creation and filling you should run "flywayMigrate" task. To drop the database you should run "flywayClean"
