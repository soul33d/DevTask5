Домашнее задание #6
===================

Predefined data:
---------------
User: soul33d@gmail.com, password: A12345!, role: ADMIN;
Some manufacturers and products for demonstration purposes.
Also you may create new account with role: USER at registration page
and any data with ADMIN user accept creating users.

Instructions for running application on local machine:
-----------------------------------------------------
Project database settings are configured for remote heroku postgres database, also
database is configured with liquibase, so you don't need to manually run any scripts.
For lunching is required tomcat installed on your machine. You can run it with your
IDE run configuration to run war exploded it tomcat. Other option is to use `mvn clean package`
and then `java -jar ./target/dependency/webapp-runner.jar ./target/DevTask5.war`.
If there is some problems with connecting to database you need to visit 
https://productmanagementsystem.herokuapp.com/ becouse heroku may stop app if there
is no request for 30 minutes.

Необходимо создать веб-приложение, которое позволяет:
1. Выполнять регистрацию пользоваталей
2. Выполнять авторизацию пользователей
3. Выполнять CRUD операции над следующими объектами:

==========================<br>
Product:<br>
UUID id;<br>
String name;<br>
BigDecimal price;<br>
Manufacturer manufacturer;<br>
==========================<br>
Manufacturer<br>
UUID id;<br>
String name;<br>
Set<Product> products;<br>
==========================<br>
Role<br>
UUID id;<br>
String name;<br>
==========================
User<br>
UUID id;<br>
String email;<br>
String password;<br>
String firstName;<br>
String lastName;<br>
Set<Role> roles;<br>
==========================<br>

Роли пользователей:
1. Admin - имеет возможность выполнять все CRUD операции
2. User - имеет доступ только для чтения

В базе данных хранятся данные о производителях (Manufacturer) и товарах (Product).
Каждый товар имеет одного производителя, и каждый производитель имеет набор товаров.

Страницы:
1. Manufacturers (список производителей + возможность создавать новых, редактировать и удалять созданных производителей)
2. Products (список товаров + возможность создавать новых, редактировать и удалять созданные товары)
3. Users (список всех ползователей приложения + возможность создавать новых, редактировать и удалять созданных пользователей) - ТОЛЬКО для ADMIN (и чтение и редактирование)

При создании товара выбор производителя реализовать с помощью выпадающего меню.

Результатом выполнения задания должны быть:
- рабочее приложение, развернутое на heroku - https://www.heroku.com/
- отдельный репозиторий с описанием задачи,
подробными инструкциями по запуску приложения на локальной машине,
файлами для инициализации и заполнения БД и ссылкой на видео с демонстрацией работы приложения.

Необходимо придерживаться паттерна MVC (model, view, controller).
Все классы должны быть грамотно разложены по пакетам и грамотно именованы (model, dao, controller).

Технологии:
Java, SQL, Spring (MVC, Data, Security), JSP, Maven, Tomcat, Git