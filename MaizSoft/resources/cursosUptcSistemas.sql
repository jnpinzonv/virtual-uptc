-- cursos de sistemas
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8107550,'Algoritmos y programacion',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108255,'Programacion I',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108256,'Programacion II',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108257,'Programacion III',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108259,'Bases de datos I',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105534,'Bases de datos II',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106174,'Profundización de Bases de datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106179,'Investigación de Bases de datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108258,'Ingenieria de requisitos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108261,'Electronica General',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108260,'Teoria General de Sistemas',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105517,'Ingenieria de Software I',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105526,'Ingenieria de Software II',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106173,'Profundización de Software',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105518,'Lenguajes Formales',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105528,'transmision de Datos',15);


--Grupos Curso de programacion 1,2,3
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_Total)
values (1,1,25,0,1,8108255,0);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_Total)
values (2,1,25,0,1,8108256,0);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_Total)
values (3,1,25,0,1,8108257,0);
