
Для запуска приложения необходимы JDK 1.8 и СУБД PostgeSQL
Для работы приложения необходима БД "directors"
Скрипт для создания БД в файле DDL.sql
Настройки доступа к БД в файле \src\main\resources\application.properties
Для запуска приложения необходимо открыть проект в InelliJ IDEA и запустить файл \src\main\java\by\godel\petrushenko\Runner.java
Интерфейс приложения после запуска будет доступен по адресу http://localhost:8080/
Чтобы проинициализировать БД тестовыми данными необходимо перейти по адресу http://localhost:8080/init
Добавить режиссера можно по адресу http://localhost:8080/adddirector
Добавить фильм можно по адресу http://localhost:8080/addfilm
Также приложение задеплоено на сервис Heroku по адресу https://godir.herokuapp.com/
