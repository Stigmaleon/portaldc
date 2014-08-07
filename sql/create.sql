INSERT INTO user(id, login, password) VALUES (1, "admin", "admin");

INSERT INTO role(id, name) VALUES (1, "ROLE_USER");
INSERT INTO role(id, name) VALUES (2, "ROLE_ADMIN");

INSERT INTO user_role(userid, roleid) VALUES (1, 1);
INSERT INTO user_role(userid, roleid) VALUES (1, 2);