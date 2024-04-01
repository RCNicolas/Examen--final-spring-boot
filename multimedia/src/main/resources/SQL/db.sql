CREATE DATABASE  IF NOT EXISTS multimedia;
USE multimedia;

CREATE TABLE tipo (
  id_tipo int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_tipo)
);

CREATE TABLE usuario (
  id_usuario int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY UK_cto7dkti4t38iq8r4cqesbd8k (nombre)
);

CREATE TABLE genero (
  id_genero int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_genero)
);

CREATE TABLE plataforma (
  id_plataforma int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_plataforma)
);

CREATE TABLE contenido_multimedia (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) DEFAULT NULL,
  id_genero int DEFAULT NULL,
  id_tipo int DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_thnhl8mov6cwn6el2kd99fego (id_tipo),
  KEY FKmkdy0ka0nvvxn378ad6anmnii (id_genero),
  CONSTRAINT FK6q7n5tnoh0u2psgd3pep669jx FOREIGN KEY (id_tipo) REFERENCES tipo (id_tipo),
  CONSTRAINT FKmkdy0ka0nvvxn378ad6anmnii FOREIGN KEY (id_genero) REFERENCES genero (id_genero)
); 

CREATE TABLE contenido_usuario (
  calificacion double NOT NULL,
  comentario varchar(255) NOT NULL,
  estado varchar(255) NOT NULL,
  id_contenido int NOT NULL,
  id_plataforma int DEFAULT NULL,
  id_usuario int NOT NULL,
  PRIMARY KEY (id_contenido,id_usuario),
  KEY FKmx7lltdd4ti0u3psblcrw56b9 (id_plataforma),
  KEY FKhw4cllq4fjvuapee2xi9889v6 (id_usuario),
  CONSTRAINT FK7esguldr2w95h2q15n83llvqe FOREIGN KEY (id_contenido) REFERENCES contenido_multimedia (id),
  CONSTRAINT FKhw4cllq4fjvuapee2xi9889v6 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  CONSTRAINT FKmx7lltdd4ti0u3psblcrw56b9 FOREIGN KEY (id_plataforma) REFERENCES plataforma (id_plataforma)
);