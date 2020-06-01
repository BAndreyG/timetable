DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM clients;
DELETE
FROM historys;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, password)
VALUES ('user', '$2a$10$8E9T8IrsfJllvBHDhsFR4Ovv6I6NsjKqbNss7LvTziVZwAvMKpuSW'),
       ('admin', '$2a$10$DIweDRnnDQ43mtxsgbwfq.WjhOpYRZ39BKGBc8zso5mpEhATV.jZe'),
       ('demo', '$2a$10$Ep78NcvgFIBd4HbnRQrkb.L0lYfeist9Q.erk.lGdgCQWnKiJNyZi');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001),
       ('ROLE_USER', 100001);

INSERT INTO clients (name, adres, tel, description, user_id)
VALUES ('Первый', 'st1', 12345, 'fsdf', 100001),
       ('Второй', 'st2', 415798, 'fsdf', 100001),
       ('Третий', 'st3', 12346, 'fsdf', 100001),
       ('Четвёртый', 'st4', 45132, 'fsdf', 100001),
       ('Пятый', 'st5', 45789, 'fsdf', 100001);

INSERT INTO historys (client_id, date, description)
VALUES (100003,'2020-06-01 12:00:00' , 'ksjadkasdhkahdkjhaskdhaskjdhkjashdkjahskdhadh'),
       (100003,'2020-06-03 16:00:00', 'ksjadkasdhkahdkjhaskdhaskjdhkjashdkjahskdhadh'),
       (100005, '2020-06-03 18:00:00', 'ksjadkasdhkahdkjhaskdhaskjdhkjashdkjahskdhadh');
