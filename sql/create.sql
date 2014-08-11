INSERT INTO user(id, login, password) VALUES (1, "admin", "admin");

INSERT INTO role(id, name) VALUES (1, "ROLE_USER");
INSERT INTO role(id, name) VALUES (2, "ROLE_ADMIN");

INSERT INTO user_role(userid, roleid) VALUES (1, 1);
INSERT INTO user_role(userid, roleid) VALUES (1, 2);

INSERT INTO distribution_category(id, name) VALUES(1, "Фильмы");
INSERT INTO distribution_category(id, name) VALUES(2, "Аудио");
INSERT INTO distribution_category(id, name) VALUES(3, "Игры");
INSERT INTO distribution_category(id, name) VALUES(4, "Книги");