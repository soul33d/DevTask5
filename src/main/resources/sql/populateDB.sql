USE homework5;

INSERT INTO manufacturers (id, name) VALUES (1, 'ZAZ');
INSERT INTO manufacturers (id, name) VALUES (2, 'Mercedes');

INSERT INTO products (id, name, price, manufacturer_id) VALUES (1, 'VIDA', 10000, 1);
INSERT INTO products (id, name, price, manufacturer_id) VALUES (2, 'Sens', 7000, 1);
INSERT INTO products (id, name, price, manufacturer_id) VALUES (3, 'Lanos Cargo', 9000, 1);

INSERT INTO products (id, name, price, manufacturer_id) VALUES (4, 'Mercedes-AMG C 43 4MATIC', 50000, 2);
INSERT INTO products (id, name, price, manufacturer_id) VALUES (5, 'Mercedes-AMG C 63', 750000, 2);
INSERT INTO products (id, name, price, manufacturer_id) VALUES (6, 'Mercedes-Benz E 220 d', 450000, 2);
INSERT INTO products (id, name, price, manufacturer_id) VALUES (7, 'Mercedes-AMG E 43 Sport', 750000, 2);
INSERT INTO products (id, name, price, manufacturer_id) VALUES (8, 'MERCEDES-MAYBACH S 560 4MATIC', 1800000, 2);