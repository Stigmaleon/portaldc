INSERT INTO user(id, login, password) VALUES (1, "admin", "admin");

INSERT INTO role(id, name) VALUES (1, "ROLE_USER");

INSERT INTO user_role(userid, roleid) VALUES (1, 1);