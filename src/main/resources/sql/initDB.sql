CREATE SCHEMA IF NOT EXISTS homework5;
USE homework5;

CREATE TABLE IF NOT EXISTS manufacturers (
  id   BINARY(16) PRIMARY KEY NOT NULL,
  name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS products (
  id              BINARY(16) PRIMARY KEY NOT NULL,
  name            VARCHAR(50)            NOT NULL,
  price           DECIMAL(18, 2)         NOT NULL,
  manufacturer_id BINARY(16)             NOT NULL,
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS roles (
  id   BINARY(16) PRIMARY KEY NOT NULL,
  name VARCHAR(50)            NOT NULL
);
CREATE TABLE IF NOT EXISTS users (
  id         BINARY(16) PRIMARY KEY NOT NULL,
  first_name VARCHAR(50)            NOT NULL,
  last_name  VARCHAR(50)            NOT NULL,
  email      VARCHAR(50)            NOT NULL,
  password   VARCHAR(255)           NOT NULL
);
CREATE TABLE IF NOT EXISTS users_roles (
  user_id BINARY(16) NOT NULL,
  role_id BINARY(16) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  UNIQUE (user_id, role_id)
)