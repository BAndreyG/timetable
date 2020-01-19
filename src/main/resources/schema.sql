DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS clents CASCADE;
DROP TABLE IF EXISTS history CASCADE;
DROP SEQUENCE IF EXISTS GLOBAL_SEQ CASCADE;

CREATE SEQUENCE global_seq START WITH 100000;
CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR(50)                       NOT NULL,
    password   VARCHAR(255)                      NOT NULL,
    registered TIMESTAMP           DEFAULT NOW() NOT NULL,
    enabled    BOOLEAN             DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_name_password_idx
    ON USERS (name, password);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(50),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE clients
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR(50)                       NOT NULL,
    adres       VARCHAR                           NOT NULL,
    enabled     BOOLEAN             DEFAULT TRUE  NOT NULL,
    registered  TIMESTAMP           DEFAULT NOW() NOT NULL,
    tel         INTEGER,
    description VARCHAR
);

CREATE TABLE historys
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    client_id   INTEGER                           NOT NULL,
    name        VARCHAR(50)                       NOT NULL,
    description VARCHAR,
    registered  TIMESTAMP           DEFAULT NOW() NOT NULL,
    FOREIGN KEY (client_id) REFERENCES USERS (id) ON DELETE CASCADE
);
