/**Un youtuber ofrecer videos y podscats en linea para lo cual requiere una base de datos que contenga los Contenidos,
 Podcasts y Videos . Un Video tiene un título, un resumen y el año. Mientras que un podcast tiene título,
 número de temporadas y número de episodios. Adicionalmente, cada video tiene un Editor(sólo uno), del cual 
 se desea guardar su nombre, apellido y nacionalidad. Además, el Usuario tendrá nombres, apellidos, email, 
 celular, alias, contraseña, y fecha de nacimiento. El alias o "username" será el identificador único del usuario. 
 Por último la base de datos debe poseer un Registro de los Estrenos de los podcasts o videos vistos
 por los usuarios en su respectiva fecha y hora.*/

drop schema multimedia;
CREATE SCHEMA multimedia;

USE multimedia;
/*ASI SE DEBERIAN CREAR LAS TABLAS PERO COMO EN EL EVALUDAR QUE SE ENVIO USABAN SQLLITE,LAS LLAVES PRIMARIAS SE INCREMENTAN AUTOMATICAMENTE*/
CREATE TABLE CONTENIDO(
cont_id_contenido INTEGER NOT NULL PRIMARY KEY auto_increment,
cont_titulo varchar(80) NOT NULL
);

CREATE TABLE DIRECTOR(
 dir_id_director INTEGER NOT NULL PRIMARY KEY auto_increment,
 dir_nombre varchar(20)NOT NULL,
 dir_apellido varchar(20)NOT NULL,
 dir_nacionalidad varchar(20)NOT NULL
);
CREATE TABLE USUARIO(
 usr_username varchar(20)NOT NULL PRIMARY KEY,
 usr_nombre varchar(20) NOT NULL,
 usr_apellido varchar(20) NOT NULL,
 usr_email varchar(20) UNIQUE NOT NULL,
 usr_celular BIGINT NOT NULL,
 usr_contraseña varchar(40)NOT NULL,
 usr_fecha_nacimiento date NOT NULL
);

CREATE TABLE VIDEO(
 vid_id_video integer NOT NULL PRIMARY KEY auto_increment,
 vid_anio int NOT NULL ,
 vid_resumen varchar(300) NOT NULL,
 cont_id_contenido INTEGER NOT NULL,
 vid_id_director INTEGER NOT NULL,
 FOREIGN KEY(vid_id_director) REFERENCES DIRECTOR(dir_id_director),
 FOREIGN KEY(cont_id_contenido) REFERENCES CONTENIDO(cont_id_contenido)
);

CREATE TABLE PODCAST(
 pod_id_podcast integer NOT NULL PRIMARY KEY auto_increment,
 pod_numero_episodios INTEGER NOT NULL ,
 pod_numero_temporadas INTEGER NOT NULL,
 cont_id_contenido INTEGER NOT NULL,
 FOREIGN KEY(cont_id_contenido) REFERENCES CONTENIDO(cont_id_contenido)
);

CREATE TABLE PUBLICACION (
pub_id_publicacion INTEGER PRIMARY KEY auto_increment,
usr_username varchar(20)NOT NULL,
cont_id_contenido INTEGER NOT NULL,
pub_fecha DATETIME NOT NULL,
FOREIGN KEY(cont_id_contenido) REFERENCES CONTENIDO(cont_id_contenido),
FOREIGN KEY(usr_username) REFERENCES USUARIO(usr_username)
/*PRYMARY KEY(pub_id_publicacion) */
);
/*3.1 Insertando contenido /titulos del los contenidos*/
/*resetear autoincrement alter table nombre_de_la_tabla AUTO_INCREMENT=1;**/

INSERT INTO CONTENIDO (cont_titulo) VALUES("Los Vengadores");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Interestelar");
INSERT INTO CONTENIDO (cont_titulo) VALUES("El viaje de Chihiro");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Parasitos");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Mas alla de los sueños");
INSERT INTO CONTENIDO (cont_titulo) VALUES("The walking dead");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Viaje a las estrellas: la serie original");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Glow");
INSERT INTO CONTENIDO (cont_titulo) VALUES("La casa de papel");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Friends");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Arrow");
INSERT INTO CONTENIDO (cont_titulo) VALUES("The big bang theory");
INSERT INTO CONTENIDO (cont_titulo) VALUES("Vikingos");
/*3.2 INSERTANDO DIRECTOR*/
/*resetear autoincrement alter table nombre_de_la_tabla AUTO_INCREMENT=1;**/
INSERT INTO DIRECTOR (dir_nombre,dir_apellido,dir_nacionalidad) VALUES ("Hayo","Miyazaki","japones");
INSERT INTO DIRECTOR (dir_nombre,dir_apellido,dir_nacionalidad) VALUES ("Joss","Whedon","estadounidense");
INSERT INTO DIRECTOR (dir_nombre,dir_apellido,dir_nacionalidad) VALUES ("Christopher","Nolan","estadounidense");
INSERT INTO DIRECTOR (dir_nombre,dir_apellido,dir_nacionalidad) VALUES ("Bong","Joon-ho","coreano");
INSERT INTO DIRECTOR (dir_nombre,dir_apellido,dir_nacionalidad) VALUES ("Vincent","Ward","neozelandes");
/*3.1 INSERTANDO VIDEO*/
INSERT INTO VIDEO (vid_anio,vid_resumen,cont_id_contenido,vid_id_director) VALUES(
"1990","Video de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.",
(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Los Vengadores"),
(SELECT dir_id_director FROM DIRECTOR WHERE concat_ws(' ', dir_nombre, dir_apellido) ="Joss Whedon")
);
INSERT INTO VIDEO (vid_anio,vid_resumen,cont_id_contenido,vid_id_director) VALUES(
"2014","Video de ciencia fición, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajana traves de un agujero de gusano en busca de un nuevo hogar. ",
(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Interestelar"),
(SELECT dir_id_director FROM DIRECTOR WHERE concat_ws(' ', dir_nombre, dir_apellido) ="Christopher Nolan")
);
INSERT INTO VIDEO (vid_anio,vid_resumen,cont_id_contenido,vid_id_director) VALUES(
"2001","Video de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.",
(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="El viaje de Chihiro"),
(SELECT dir_id_director FROM DIRECTOR WHERE concat_ws(' ', dir_nombre, dir_apellido) ="Hayo Miyazaki")
);
INSERT INTO VIDEO (vid_anio,vid_resumen,cont_id_contenido,vid_id_director) VALUES(
"2019","Video de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano.",
(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Parasitos"),
(SELECT dir_id_director FROM DIRECTOR WHERE concat_ws(' ', dir_nombre, dir_apellido) ="Bong Joon-ho")
);
INSERT INTO VIDEO (vid_anio,vid_resumen,cont_id_contenido,vid_id_director) VALUES(
"1998","Libro de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.",
(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Mas alla de los sueños"),
(SELECT dir_id_director FROM DIRECTOR WHERE concat_ws(' ', dir_nombre, dir_apellido) ="Vincent Ward")
);
/*3.1 INSERTANDO PODCAST*/
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(153,11,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="The walking dead")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(80,3,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Viaje a las estrellas: la serie original")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(30,3,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Glow")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(31,4,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="La casa de papel")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(236,10,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Friends")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(170,8,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Arrow")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(279,12,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="The big bang theory")
);
INSERT INTO PODCAST (pod_numero_episodios,pod_numero_temporadas,cont_id_contenido)
VALUES(79,6,(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo ="Vikingos")
);
/*3.3 INSERTANDO usuarios
/*INSERT INTO usuarios VALUES('usuario',SHA('contraseña'));*/
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("lucky","Pedro","Perez","correo1@gmail.com",3123456789,SHA('1'),'1991-01-01');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("malopez","Maria","Lopez","correo2@gmail.com",3123456791,SHA('contrasena'),'1995-03-07');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("diva","Ana","Diaz","correo3@gmail.com",3123456792,SHA('contrasena1'),'1992-04-01');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("dreamer","Luis","Rojas","correo4@gmail.com",3123456794,SHA('contrasena2'),'1994-01-05');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("ninja","Andres","Cruz","correo5@gmail.com",3123456795,SHA('contrasena2'),'2001-06-09');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("neon","Nelson","Ruiz","correo6@gmail.com",3123456796,SHA('contrasena2'),'2011-11-19');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("rose","Claudia","Mendez","correo7@gmail.com",3123456797,SHA('contrasena2'),'2008-9-1');
INSERT INTO usuario (usr_username,usr_nombre,usr_apellido,usr_email,usr_celular,usr_contraseña,usr_fecha_nacimiento)
VALUES("green","Jorge","Rodriguez","correo8@gmail.com",3123456798,SHA('contrasena2'),'2006-6-7');
/*resetear autoincrement alter table nombre_de_la_tabla AUTO_INCREMENT=1;**/

/* INSERTANDO publicaciones de videos y podcast*/
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"lucky",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Los Vengadores"),
'2017-10-25 20:00:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"lucky",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Parasitos"),
'2019-03-15 18:30:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"lucky",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "La casa de papel"),
'2019-05-20 20:30:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"malopez",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Los Vengadores"),
'2018-05-20 20:30:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"malopez",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "La casa de papel"),
'2020-01-20 20:30:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"diva",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Interestelar"),
'2019-05-20 20:30:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"diva",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "El viaje de Chihiro"),
'2018-06-22 21:30:00'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"diva",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "The walking dead"),
'2020-03-17 15:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"dreamer",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "The walking dead"),
'2020-03-17 15:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"dreamer",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Viaje a las estrellas: la serie original"),
'2020-04-10 18:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"ninja",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Glow"),
'2020-02-17 20:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"ninja",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "La casa de papel"),
'2020-02-20 16:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"ninja",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Arrow"),
'2020-03-27 18:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"rose",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Friends"),
'2020-03-20 21:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"green",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Interestelar"),
'2020-01-10 17:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"green",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Parasitos"),
'2020-02-15 20:30:20'
);
INSERT INTO PUBLICACION (usr_username,cont_id_contenido,pub_fecha) VALUES(
"green",(SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Mas alla de los sueños"),
'2020-03-17 18:30:20'
);

/*4.1 Cambiar  el año del video "Los vengadores" por 2012*/
update video set vid_anio = 2012 where cont_id_contenido = (SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Los Vengadores");
/*4.2 Cambiar el teléfono del usuario "ninja" por 3115678432*/
update usuario set usr_celular ="3115678432" where usr_username = "ninja";
/*4.3 Borrar la publicación del usuario "green" del libro "Parasitos"*/
delete from publicacion where usr_username="green" and cont_id_contenido = (SELECT cont_id_contenido FROM CONTENIDO WHERE cont_titulo = "Parasitos");

/*5.1 Mostrar la información del título de todas los videos y y podcast ordenadas alfabéticamente.*/
select cont_titulo from CONTENIDO AS CONT  
INNER JOIN VIDEO AS VID ON CONT.cont_id_contenido = VID.cont_id_contenido 
union select cont_titulo from CONTENIDO AS CONT 
INNER JOIN PODCAST AS POD ON CONT.cont_id_contenido = POD.cont_id_contenido
ORDER BY cont_titulo asc;
/*OPcion 2*/
select distinct CONTENIDO.cont_titulo
from CONTENIDO,VIDEO,PODCAST
where (CONTENIDO.cont_id_contenido= VIDEO.cont_id_contenido) or (CONTENIDO.cont_id_contenido =PODCAST.cont_id_contenido)
order by CONTENIDO.cont_titulo asc
;
/*5.2 Mostrar la información de las Videos (título, resumen, año) que se han estrenado posteriormente al año 2000, 
ordenadas por título*/
select cont_titulo, vid_resumen,vid_anio from CONTENIDO AS CONT
INNER JOIN VIDEO AS VID on CONT.cont_id_contenido = VID.cont_id_contenido
WHERE (vid_anio) > 2000
order by cont_titulo asc;
/*5.3 Mostrar los títulos de Videos dirigidas por el editor Vincent Ward */
select cont_titulo AS "Titulos Vicent ward"from CONTENIDO AS CONT
INNER JOIN VIDEO AS VID on CONT.cont_id_contenido = VID.cont_id_contenido
INNER JOIN DIRECTOR AS DIR ON VID.vid_id_director = DIR.dir_id_director
WHERE (concat_ws(' ',dir_nombre,dir_apellido) = "Vincent Ward");
/*5.4  Mostrar la información de los podcasts y videos ( solo los títulos) que vio alias "lucky", ordenadas por título*/
SELECT cont_titulo FROM CONTENIDO AS CONT
INNER JOIN PUBLICACION AS PUB ON CONT.cont_id_contenido = PUB.cont_id_contenido
WHERE PUB.usr_username="lucky"
ORDER BY cont_titulo ASC;
/*5.5 Mostrar la información de los usuarios (alias y nombre y apellidos) que vieron el video "Interestelar" ordenados alfabéticamente*/
SELECT PUB.usr_username,usr_nombre,usr_apellido FROM PUBLICACION AS PUB
INNER JOIN USUARIO AS USR ON PUB.usr_username=USR.usr_username
INNER JOIN CONTENIDO AS CONT ON PUB.cont_id_contenido = CONT.cont_id_contenido
WHERE (cont_titulo="Interestelar")
ORDER BY usr_username ASC;
/*5.6 Mostrar cuantos videos se han estrenado después del año 2000*/
SELECT COUNT(*) FROM VIDEO
WHERE vid_anio >2000;