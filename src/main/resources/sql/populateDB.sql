USE homework5;

INSERT INTO manufacturers VALUES (1, 'ZAZ');
INSERT INTO manufacturers VALUES (2, 'Mercedes');

INSERT INTO products VALUES (1, 'VIDA', 10000, 1);
INSERT INTO products VALUES (2, 'Sens', 7000, 1);
INSERT INTO products VALUES (3, 'Lanos Cargo', 9000, 1);

INSERT INTO products VALUES (4, 'Mercedes-AMG C 43 4MATIC', 50000, 2);
INSERT INTO products VALUES (5, 'Mercedes-AMG C 63', 750000, 2);
INSERT INTO products VALUES (6, 'Mercedes-Benz E 220 d', 450000, 2);
INSERT INTO products VALUES (7, 'Mercedes-AMG E 43 Sport', 750000, 2);
INSERT INTO products VALUES (8, 'MERCEDES-MAYBACH S 560 4MATIC', 1800000, 2);

INSERT INTO roles VALUES (1, 'Admin');
INSERT INTO roles VALUES (2, 'User');

#BCrypt(10) password=A12345!
INSERT INTO users
VALUES (1, 'Vitaliy', 'Ostapenko', 'soul33d@gmail.com', '$2a$10$NXAFCmvGh1sb8iZkY..D5.pGjXKuMGFSmoTbSqYaJ0wJ.pwDpAO0C');

#BCrypt(10) password=U12345!
INSERT INTO users
VALUES (2, 'Vasya', 'Pupkin', 'pupkin@gmail.com', '$2a$10$YFpZ9Q.MwPmwnfK0UPYDp.DiBCJLxFCtoNoqL/doYWviaxKQUo1y.');

INSERT INTO users_roles VALUES (1, 1);
INSERT INTO users_roles VALUES (2, 2);