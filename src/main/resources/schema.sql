drop table if exists datos_personales cascade ;
drop table if exists documento cascade ;
drop table if exists especialidad cascade ;
drop table if exists est_profesional cascade ;
drop table if exists estudio cascade ;
drop table if exists exp_laboral cascade ;
drop table if exists procedencia cascade ;
drop table if exists sede cascade ;
drop table if exists sexo cascade ;
drop table if exists titulo cascade ;
drop table if exists trabajo cascade ;
drop table if exists user_sede cascade ;
drop table if exists users cascade ;
drop sequence if exists datos_personales_seq;
drop sequence if exists documento_seq;
drop sequence if exists especialidad_seq;
drop sequence if exists est_profesional_seq;
drop sequence if exists estudio_seq;
drop sequence if exists exp_laboral_seq;
drop sequence if exists procedencia_seq;
drop sequence if exists sede_seq;
drop sequence if exists sexo_seq;
drop sequence if exists titulo_seq;
drop sequence if exists trabajo_seq;
drop sequence if exists user_sede_seq;
create sequence datos_personales_seq start with 1 increment by 50;
create sequence documento_seq start with 1 increment by 50;
create sequence especialidad_seq start with 1 increment by 50;
create sequence est_profesional_seq start with 1 increment by 50;
create sequence estudio_seq start with 1 increment by 50;
create sequence exp_laboral_seq start with 1 increment by 50;
create sequence procedencia_seq start with 1 increment by 50;
create sequence sede_seq start with 1 increment by 50;
create sequence sexo_seq start with 1 increment by 50;
create sequence titulo_seq start with 1 increment by 50;
create sequence trabajo_seq start with 1 increment by 50;
create sequence user_sede_seq start with 1 increment by 50;
create table datos_personales (
       personales_id bigint not null,
        celular varchar(255),
        materno varchar(255),
        nombres varchar(255),
        numero_documento varchar(255),
        paterno varchar(255),
        telef_fijo varchar(255),
        documento_documento_id bigint,
        sexo_sexo_id bigint,
        user_user_id bigint,
        primary key (personales_id)
    );
create table documento (
       documento_id bigint not null,
        descripcion varchar(255),
        primary key (documento_id)
    );
create table especialidad (
       especialidad_id bigint not null,
        descripcion varchar(255),
        primary key (especialidad_id)
    );
create table est_profesional (
       profesion_id varchar(255) not null,
        estudio_estudio_id bigint,
        user_user_id bigint,
        primary key (profesion_id)
    );
create table estudio (
       estudio_id bigint not null,
        ciudad varchar(255),
        fecha_culmina varchar(255),
        especialidad_especialidad_id bigint,
        titulo_titulo_id bigint,
        primary key (estudio_id)
    );
create table exp_laboral (
       experiencia_id bigint not null,
        estudio_estudio_id bigint,
        user_user_id bigint,
        primary key (experiencia_id)
    );
create table procedencia (
       procedencia_id bigint not null,
        descripcion varchar(255),
        primary key (procedencia_id)
    );
create table sede (
       sede_id bigint not null,
        nombre varchar(255),
        primary key (sede_id)
    );
create table sexo (
       sexo_id bigint not null,
        descripcion varchar(255),
        primary key (sexo_id)
    );
create table titulo (
       titulo_id bigint not null,
        descripcion varchar(255),
        primary key (titulo_id)
    );
create table trabajo (
       trabajo_id bigint not null,
        cargo varchar(255),
        tiempo_inicio varchar(255),
        timpo_final varchar(255),
        primary key (trabajo_id)
    );
create table user_sede (
       id bigint not null,
        procedencia_procedencia_id bigint not null,
        sede_sede_id bigint not null,
        user_user_id bigint,
        primary key (id)
    );
create table users (
       user_id bigint generated by default as identity,
        email varchar(255),
        password varchar(255),
        primary key (user_id)
    );
alter table if exists datos_personales 
       add constraint FKnqb1gn67jrfs4ca85abd37et9 
       foreign key (documento_documento_id) 
       references documento;
alter table if exists datos_personales 
       add constraint FKrc87y7ynsa916bfiou390pqt 
       foreign key (sexo_sexo_id) 
       references sexo;
alter table if exists datos_personales 
       add constraint FK1n8qjbjkhdgt23a122yakle0o 
       foreign key (user_user_id) 
       references users;
alter table if exists est_profesional 
       add constraint FK47q8c4fgvex4fm4xrgg3xqmdx 
       foreign key (estudio_estudio_id) 
       references estudio;
alter table if exists est_profesional 
       add constraint FKbeufcprxesn7493gwbk4y88a5 
       foreign key (user_user_id) 
       references users;
alter table if exists estudio 
       add constraint FKcdctqbsb582cn2xhrmellsblw 
       foreign key (especialidad_especialidad_id) 
       references especialidad;
alter table if exists estudio 
       add constraint FKsgohdpyq86es9fmjxlryx648h 
       foreign key (titulo_titulo_id) 
       references titulo;
alter table if exists exp_laboral 
       add constraint FK4urvf8chriq3im4e138bwoe7q 
       foreign key (estudio_estudio_id) 
       references estudio;
alter table if exists exp_laboral 
       add constraint FK1yx5e7q4ddbbh5wag5bpctu93 
       foreign key (user_user_id) 
       references users;
alter table if exists user_sede 
       add constraint FKm7rd7b1lco166ac0iovpfu1lg 
       foreign key (procedencia_procedencia_id) 
       references procedencia;
alter table if exists user_sede 
       add constraint FKm9dsw6j60nqelvct2yy3u1uuc 
       foreign key (sede_sede_id) 
       references sede;
alter table if exists user_sede 
       add constraint FKjirp1iyau30b8oo49qfkmfi7q 
       foreign key (user_user_id) 
       references users;