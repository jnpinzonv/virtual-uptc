-- Cursos de Ingenieria de Sistemas y Computaci髇
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
values(8106174,'Profundizaci贸n de Bases de datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106179,'Investigaci贸n de Bases de datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108258,'Ingenieria de Requisitos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108261,'Electronica General',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105515,'Comunicaciones',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105524,'Microcontroladores',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108260,'Teoria General de Sistemas',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105430,'Matem醫icas Discretas',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105530,'Investigacion de Operaciones',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105517,'Ingenieria de Software I',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105526,'Ingenieria de Software II',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106173,'Profundizaci贸n de Software',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106178,'Investigaci贸n de Software',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105518,'Lenguajes Formales',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105523,'Sistemas Operativos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105519,'Arquitectura de Computadores',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106177,'Inteligencia Computacional',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105528,'Transmision de Datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105531,'Redes de Datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106175,'Profundizaci贸n de Redes de Datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106180,'Investigaci贸n de Redes de Datos',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106181,'Auditoria de Sistemas',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106176,'Gerencia Informatica',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8107230,'Seminario de Trabajo de Grado',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105529,'Simulaci髇 por computador',15);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108220,'Metodologia de la Investigacion y Dise駉 Experimental',15);

-- Grupos de Ingenieria de Sistemas y Computaci髇
-- Grupo Algoritmos y programacion
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (1,1,25,0,1,8107550,16);
-- Grupos Curso de programacion 1,2,3
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (2,1,25,0,2,8108255,16);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (3,1,25,0,3,8108256,16);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (4,1,25,0,4,8108257,16);
-- Grupo Bases de datos 1,2
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (5,1,25,0,5,8108259,16);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (6,1,25,0,6,8105534,16);
-- Grupo Profundizaci髇 de Bases de datos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (7,1,25,0,9,8106174,16);
-- Grupo Investigaci贸n de Bases de datos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (8,1,25,0,10,8106179,16);
-- Grupo Ingenieria de Requisitos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (9,1,25,0,5,8108258,16);
-- Grupo Electr髇ica General
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (10,1,25,0,5,8108261,16);
-- Grupo Comunicaciones
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (11,1,25,0,6,8105515,16);
-- Grupo Microcontroladores
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (12,1,25,0,8,8105524,16);
-- Grupo Teoria General de Sistemas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (13,1,25,0,5,8108260,16);
-- Grupo Matem醫icas Discretas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (14,1,25,0,6,8105430,16);
-- Grupo Investigacion de Operaciones
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (15,1,25,0,6,8105530,16);
-- Grupo Ingenieria Software 1,2
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (16,1,25,0,6,8105517,16);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (17,1,25,0,7,8105526,16);
-- Grupo Profundizaci贸n de Software
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (18,1,25,0,9,8106173,16);
-- Grupo Investigaci贸n de Software
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (19,1,25,0,10,8106178,16);
-- Grupo Lenguajes Formales
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (20,1,25,0,7,8105518,16);
-- Grupo Sistemas Operativos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (21,1,25,0,7,8105523,16);
-- Grupo Arquitectura de Computadores
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (22,1,25,0,8,8105519,16);
-- Grupo Inteligencia Computacional
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (23,1,25,0,8,8106177,16);
-- Grupo Transmision de Datos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (24,1,25,0,7,8105528,16);
-- Grupo Redes de Datos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (25,1,25,0,8,8105531,16);
-- Grupo Profundizaci贸n de Redes de Datos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (26,1,25,0,9,8106175,16);
-- Grupo Investigaci贸n de Redes de Datos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (27,1,25,0,10,8106180,16);
-- Grupo Auditoria de Sistemas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (28,1,25,0,9,8106181,16);
-- Grupo Gerencia Informatica
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (29,1,25,0,9,8106176,16);
-- Grupo Seminario de Trabajo de Grado
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (30,1,25,0,9,8107230,16);
-- Grupo Simulaci髇 por computador
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (31,1,25,0,9,8105529,16);
-- Grupo Metodologia de la Investigacion y Dise駉 Experimental 
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (32,1,25,0,3,8108220,16);


---- Cursos Ingenier韆 Agron髆ica
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105062,'Mercadeo Agricola',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105083,'Extension Rural',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105067,'Formulacon y Evaluacion de Proyectos',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108058,'Metodologia de la Investigacion',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108101,'Botanica Taxonomica',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105068,'Manejo Integral de Malezas',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108107,'Fisiologia Vegetal I',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108111,'Fisiologia Vegetal II',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106257,'Fitomejoramiento',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105065,'Fitopatologia',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106258,'Fitoproteccion Biologica',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108108,'Genesis y caracterizacion de suelos',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105058,'Genetica Agricola',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105066,'Hidraulica',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8107560,'Introduccion a las ciencias agrarias',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105069,'Manejo Integral de Insectos',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105070,'Manejo Integral de Enfermedades',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106260,'Manejo Animal',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105071,'Maquinaria y Mecanizacion Agricola',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105081,'Manejo de Cuencas Hidrograficas',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105089,'Manejo de Productos Fitosanitarios',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105087,'Produccion de Hortalizas',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105088,'Produccion de Frutas',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108112,'Quimica y Fertilidad de suelos',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108114,'Reproduccion Vegetal',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105063,'Entomologia',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108110,'Bioestadistica y Dise駉 Experimental',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8105057,'Administracion Empresas Agropecuarias',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8108054,'Econom韆 agrar韆',19);
insert into curso (codigo_curso,nombre_asignatura,id_ente_universitario) 
values(8106261,'Gerencia Empresarial Rural',19);

---- Grupos Ingenier韆 Agron髆ica
-- Grupo Introduccion a las ciencias agrarias
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (33,1,25,0,1,8107560,16);
-- Grupo Botanica Taxonomica
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (34,1,25,0,2,8108101,16);
-- Grupo Genesis y caracterizacion de suelos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (35,1,25,0,3,8108108,16);
-- Grupo Fisiologia Vegetal 1,2
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (36,1,25,0,3,8108107,16);
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (37,1,25,0,4,8108111,16);
-- Grupo Metodologia de la Investigacion
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (38,1,25,0,4,8108058,16);
-- Grupo Quimica y Fertilidad de suelos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (39,1,25,0,4,8108112,16);
-- Grupo Reproducci髇 Vegetal
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (40,1,25,0,4,8108114,16);
-- Grupo Hidraulica
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (41,1,25,0,5,8105066,16);
-- Grupo Bioestadistica y Dise駉 Experimental
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (42,1,25,0,5,8108110,16);
-- Grupo Econom韆 agrar韆
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (43,1,25,0,5,8108054,16);
-- Grupo Fitopatologia 
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (44,1,25,0,6,8105065,16);
-- Grupo Administracion Empresas Agropecuarias
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (45,1,25,0,6,8105057,16);
-- Grupo Entomologia
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (46,1,25,0,6,8105063,16);
-- Grupo Fitoproteccion Biologica
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (47,1,25,0,6,8106258,16);
-- Grupo 7enetica agricola
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (48,1,25,0,6,8105058,16);
-- Grupo Formulacion y Evaluacion de Proyectos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (49,1,25,0,7,8105067,16);
-- Grupo Manejo Integral de Malezas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (50,1,25,0,7,8105068,16);
-- Grupo Fitomejoramiento
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (51,1,25,0,7,8106257,16);
-- Grupo Mercadeo Agricola
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (52,1,25,0,8,8105062,16);
-- Grupo Extension Rural
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (53,1,25,0,8,8105083,16);
-- Grupo Manejo Integral de Insectos
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (54,1,25,0,7,8105069,16);
-- Grupo Manejo Integral de Enfermedades
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (55,1,25,0,7,8105070,16);
-- Grupo Manejo Animal
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (56,1,25,0,7,8106260,16);
-- Grupo Manejo de Cuencas Hidrograficas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (57,1,25,0,8,8105081,16);
-- Grupo Manejo de Productos Fitosanitarios
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (58,1,25,0,8,8105089,16);
-- Grupo Maquinaria y mecanizacion agricola
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (59,1,25,0,8,8105071,16);
-- Grupo Gerencia Empresarial Rural
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (60,1,25,0,9,8106261,16);
-- Grupo Produccion Frutas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (61,1,25,0,9,8105088,16);
-- Grupo Produccion Hortalizas
insert into grupo_curso(id_grupo, id_codigo_grupo, cupos, inscritos, semestre, id_curso_grupo,numero_total)
values (62,1,25,0,9,8105087,16);

