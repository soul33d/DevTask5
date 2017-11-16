CREATE SCHEMA homework5;
USE homework5;

CREATE TABLE manufacturers (
  id   BINARY(16) PRIMARY KEY NOT NULL,
  name VARCHAR(50)
);
CREATE TABLE products (
  id              BINARY(16) PRIMARY KEY NOT NULL,
  name            VARCHAR(50)            NOT NULL,
  price           DECIMAL                NOT NULL,
  manufacturer_id BINARY(16)             NOT NULL,
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)