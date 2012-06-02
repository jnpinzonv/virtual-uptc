-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'

-- admin password is blank
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (1,'Tipo EnteUniversitario' ,'Ente Universiatio',null);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (2,'Tipos de identificacion de Usuarios' ,'Identificacion',null);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (3,'Cedula de ciudadania' ,'CC',2);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (4,'Tarjeta Identidad' ,'TI',2);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (5,'Cedula Extranjeria' ,'CE',2);

insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (6,'Tipos de mensajeria' ,'Mensajeria',null);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (7,'Foro' ,'Foros',6);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (8,'Cafeteria' ,'Cafeteria',6);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (9,'Mensaje' ,'Mensaje',6);

insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (10,'Tipo Actividades' ,'Actividad',null);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (11,'Foro' ,'Foro',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (12,'Cargar archivos' ,'Cargar Archivos',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (13,'Autoevaluacion' ,'Autoevaluacion',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (14,'VideoConferencia' ,'VideoConferencia',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (15,'AudioConferencia' ,'AudioConferencia',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (16,'Anuncios' ,'Anuncios',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (17,'Enlace Externo' ,'Enlace Externo',10);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (18,'Objeto de Aprendizaje' ,'Objeto de Apendizaje',10);

insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (19,'Tipo Facultad Universitaria' ,'Facultad',1);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (20,'Tipo Escuela Universitaria' ,'Escuela',1);

insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (21,'Tipo Repositorio Virtual' ,'Repositorio Virtual',null);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (22,'Tipo Repositorio de Objetos de Aprendizaje' ,'Objeto de Aprendizaje',21);
insert into `tipo` (`idTipo`,`descripcion`,`nombre`,`tipo_idTipo`) values (23,'Tipo Repositorio de Bibliotecas Virtuales' ,'Biblioteca Virtual',21);

insert into user_account (id, username, password_hash, enabled) values (1, 'admin', 'Ss/jICpf9c9GeJj8WKqx1hUClEE=', 1);
insert into user_role (id, name, conditional) values (1, 'admin', false);
insert into user_role (id, name, conditional) values (2, 'docente', false);
insert into user_role (id, name, conditional) values (3, 'estudiante', false);
insert into user_role (id, name, conditional) values (4, 'visitante', true);
insert into user_account_role (account_id, member_of_role) values (1, 1);
insert into user_role_group (role_id, member_of_role) values (1, 2);
insert into user_role_group (role_id, member_of_role) values (1, 3);

insert into configuraciones_sistema(id,nombre_propiedad,detalles_propiedades) values(1,'pathArchivos','C://archivos');



--insert into ente_universitario(`idEnteUniversitario`,`descripcionEnteUniversitario`,`enteUniversitario_idEnteUniversitario`,`nombreEnteUniversitario`,`tipoEnteUniversitario_idTipo`) values (1,'Aplica cuando el usuario no pertenece a la Universidad',null,'No Aplica',1);

-- admin password is blank

