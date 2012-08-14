-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'

-- admin password is blank
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (1,'Tipo EnteUniversitario' ,'Ente Universiatio',null);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (2,'Tipos de identificacion de Usuarios' ,'Identificacion',null);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (3,'Cedula de ciudadania' ,'CC',2);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (4,'Tarjeta Identidad' ,'TI',2);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (5,'Cedula Extranjeria' ,'CE',2);

insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (6,'Tipos de mensajeria' ,'Mensajeria',null);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (7,'Foro' ,'Foros',6);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (8,'Cafeteria' ,'Cafeteria',6);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (9,'Mensaje' ,'Mensaje',6);

insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (10,'Tipo Actividades' ,'Actividad',null);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (11,'Foro' ,'Foro',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (12,'Cargar archivos' ,'Cargar Archivos',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (13,'Autoevaluacion' ,'Autoevaluacion',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (14,'VideoConferencia' ,'VideoConferencia',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (15,'AudioConferencia' ,'AudioConferencia',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (16,'Anuncios' ,'Anuncios',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (17,'Enlace Externo' ,'Enlace Externo',10);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (18,'Objeto de Aprendizaje' ,'Objeto de Apendizaje',10);

insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (19,'Tipo Facultad Universitaria' ,'Facultad',1);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (20,'Tipo Escuela Universitaria' ,'Escuela',1);

insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (21,'Tipo Repositorio Virtual' ,'Repositorio Virtual',null);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (22,'Tipo Repositorio de Objetos de Aprendizaje' ,'Objeto de Aprendizaje',21);
insert into `tipo` (`id_tipo`,`descripcion`,`nombre`,`id_tipo_padre`) values (23,'Tipo Repositorio de Bibliotecas Virtuales' ,'Biblioteca Virtual',21);

insert into user_account (id_user_account, enabled, password_hash, username, fecha_creacion) values (1, 1, 'Ss/jICpf9c9GeJj8WKqx1hUClEE=', 'admin','2012-07-23');
insert into user_role (id_user_role, conditional, name) values (1, false, 'admin');
insert into user_role (id_user_role, conditional, name) values (2, false, 'docente');
insert into user_role (id_user_role, conditional, name) values (3, false, 'estudiante');
insert into user_role (id_user_role, conditional, name) values (4, true, 'visitante');
insert into ente_universitario (id_ente_universitario,nombre_ente_universitario,descripcion_ente_universitario,id_tipo_ente_universitario,id_ente_universitario_padre,codigo_ente_universitario)		
values(1,'No Aplica','Aplica cuando el usuario no pertenece a la Universidad',19,null,1000);		
insert into usuario(id_usuario,apellidos,codigo_usuarios,correo_electronico,primer_nombre,documento_identidad,id_tipo,id_ente_universitario, fecha_creacion)		
values(1,'admin',000000,'admin@uptc.edu.co','admin',00000,3,1,'2012-07-23');
insert into cuentas_usuario(id_usuarios,id_user_account,id_cuenta_usuario) values (1,1,1);

insert into user_account_role (account_id, member_of_role) values (1, 1);

insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(1,'C://Program Files (x86)//xampp//htdocs//archivos','pathArchivos');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(2,'archivosCargasExcel','pathArchivosExcel');

insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(3,'1','enteUniversiarioPadre');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(4,'2','enteUniversiarioHijo');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(5,'3','cursosEscuela');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(6,'4','grupoCursos');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(7,'estudiante','Roles');		
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(8,'cargaArchivosCurso','pathArchivosCurso');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(9,'lordnipin@gmail.com','correoElectronico');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(10,'870317','contraseniaCorreo');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(11,'true','mail.smtp.auth');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(12,'true','mail.smtp.starttls.enable');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(13,'smtp.gmail.com','mail.smtp.host');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(14,'587','mail.smtp.port');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(15,'Recuperación de Contraseña','asuntoMail');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(16,'Cordial saludo. 
Señor(a):  Usuario.  

Por favor no devolver ningún mensaje a este correo, este medio es administrado por el servidor de la plataforma.

Su contraseña es: ' ,'cuerpoMensaje');

insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(17,'imagenesUsario','imagenUsuario');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(18,'objetosAprendizaje','objetoUsuario');
insert into configuraciones_sistema(id_configuraciones_sistema,detalles_propiedad,nombre_propiedad) values(19,'http://localhost//archivos//','rutaServidorLocal');



-- admin password is blank

