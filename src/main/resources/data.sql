DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM clients;
DELETE FROM historys;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, password) VALUES
  ('User', '$2a$10$8E9T8IrsfJllvBHDhsFR4Ovv6I6NsjKqbNss7LvTziVZwAvMKpuSW'),
  ('Admin', '$2a$10$DIweDRnnDQ43mtxsgbwfq.WjhOpYRZ39BKGBc8zso5mpEhATV.jZe'),
  ('demo',  '$2a$10$Ep78NcvgFIBd4HbnRQrkb.L0lYfeist9Q.erk.lGdgCQWnKiJNyZi');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO clients (name, adres,registered,tel,description,user_id)
VALUES ('Манка',10.5,'2015-05-30 10:00:00', 100004,'fsdf',100000),
       ('Гречка',200,'2015-05-30 13:00:00', 100004,'fsdf',100001),
       ('Ужин', 500,'2015-05-30 20:00:00',  100004,'fsdf',100001),
       ('Завтрак', 500,'2015-05-31 10:00:00', 100004,'fsdf',100001),
       ('Обед', 1000,'2015-05-31 13:00:00',  100003,'fsdf',100001)

INSERT INTO historys (ID,client_id,name,description,REGISTERED)
VALUES (100013,100001,'history 1','ksjadkasdhkahdkjhaskdhaskjdhkjashdkjahskdhadh','2015-05-30 10:00:00');
