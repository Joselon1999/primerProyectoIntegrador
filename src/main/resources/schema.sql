create table users (
   userId integer not null AUTO_INCREMENT,
   email varchar(255) not null,
   password varchar(255) not null,
   primary key(userId)
);

create table sede (
   sede_id integer not null AUTO_INCREMENT,
   nombre varchar(255) not null,
   primary key(sede_id)
);

CREATE TABLE sexo (
sexo_id INT NOT NULL AUTO_INCREMENT ,
descripcion VARCHAR(255) NOT NULL ,
PRIMARY KEY (sexo_id));

CREATE TABLE titulo (
titulo_id INT NOT NULL AUTO_INCREMENT ,
descripcion VARCHAR(255) NOT NULL ,
PRIMARY KEY (titulo_id));

CREATE TABLE documento (
documento_id INT NOT NULL AUTO_INCREMENT ,
descripcion VARCHAR(255) NOT NULL ,
PRIMARY KEY (documento_id));

CREATE TABLE especialidad (
especialidad_id INT NOT NULL AUTO_INCREMENT ,
descripcion VARCHAR(255) NOT NULL ,
PRIMARY KEY (especialidad_id));

CREATE TABLE procedencia (
procedencia_id INT NOT NULL AUTO_INCREMENT ,
descripcion VARCHAR(255) NOT NULL ,
PRIMARY KEY (procedencia_id));

CREATE TABLE trabajo (
trabajo_id INT NOT NULL AUTO_INCREMENT , 
cargo VARCHAR(255) NOT NULL , 
tiempo_inicio VARCHAR(255) NOT NULL , 
timpo_final VARCHAR(255) NOT NULL , 
PRIMARY KEY (trabajo_id))

--FALTA CREAR LAS TABLAS COMPLICADAS Y SU RESPECTIVA LOGICA