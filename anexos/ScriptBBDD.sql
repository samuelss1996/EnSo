CREATE DATABASE IF NOT EXISTS pruebasenso;

CREATE TABLE if not exists centros (
  id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE if not exists usuarios(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	idCentros INTEGER NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	correoUsuario VARCHAR(50) NOT NULL,
	tipoUsuario CHAR NOT NULL,
  	FOREIGN KEY(idCentros) REFERENCES centros(id)
  		on delete restrict on update cascade
);

CREATE TABLE if not exists solicitudes(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	estado VARCHAR(50) NOT NULL,
	contenido TEXT NOT NULL
);

CREATE TABLE if not exists pertenecer(
	idCentros INTEGER NOT NULL,
	idUsuarios INTEGER NOT NULL,
	idSolicitudes INTEGER NOT NULL,
	PRIMARY KEY(idCentros, idUsuarios, idSolicitudes),
  	FOREIGN KEY(idCentros) REFERENCES centros(id)
  		on delete restrict on update cascade,  		
  	FOREIGN KEY(idUsuarios) REFERENCES usuarios(id)
  		on delete restrict on update cascade,
  	FOREIGN KEY(idSolicitudes) REFERENCES solicitudes(id)
  		on delete restrict on update cascade
);

CREATE TABLE if not exists facturas(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	precioTotal FLOAT NOT NULL,
	fecha DATE NOT NULL,
	idUsuarios INTEGER NOT NULL,
	FOREIGN KEY(idUsuarios) REFERENCES usuarios(id)
		on delete restrict on update cascade
);

CREATE TABLE if not exists productos(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	cantidad INTEGER NOT NULL,
	disponible BOOLEAN NOT NULL
);

CREATE TABLE if not exists lineacompra(
	cantidad INTEGER NOT NULL,
	precioTotal FLOAT NOT NULL,
	numLinea INTEGER NOT NULL,
	idFacturas INTEGER NOT NULL,
	idProductos INTEGER NOT NULL,
	PRIMARY KEY(idFacturas, numLinea),
	FOREIGN KEY(idFacturas) REFERENCES facturas(id)
		on delete restrict on update cascade,
	FOREIGN KEY(idProductos) REFERENCES productos(id)
		on delete restrict on update cascade
);