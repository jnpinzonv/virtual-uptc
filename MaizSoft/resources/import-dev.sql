-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'

-- admin password is blank
insert into user_account (id, username, password_hash, enabled) values (1, 'admin', 'Ss/jICpf9c9GeJj8WKqx1hUClEE=', 1);
insert into user_role (id, name, conditional) values (1, 'admin', false);
insert into user_role (id, name, conditional) values (2, 'docente', false);
insert into user_role (id, name, conditional) values (3, 'estudiante', true);
insert into user_account_role (account_id, member_of_role) values (1, 1);
insert into user_role_group (role_id, member_of_role) values (1, 2);
