CREATE DATABASE IF NOT EXISTS pruebasenso;

CREATE TABLE if not exists center (
  id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE if not exists user(
	id CHAR(11) PRIMARY KEY,
	idCenter INTEGER NOT NULL,
	fistName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	dateRegister DATE NOT NULL,
	email VARCHAR(50),
	nif CHAR(9) NOT NULL,
	type CHAR(1),
  	FOREIGN KEY(idCenter) REFERENCES center(id)
  		on delete restrict on update cascade
);

CREATE TABLE if not exists application(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	status VARCHAR(50) NOT NULL,
	content TEXT NOT NULL
);

CREATE TABLE if not exists belongTo(
	idCenter INTEGER NOT NULL,
	idUser CHAR(11) NOT NULL,
	idApplication INTEGER NOT NULL,
	PRIMARY KEY(idCenter, idUser, idApplication),
  	FOREIGN KEY(idCenter) REFERENCES center(id)
  		on delete restrict on update cascade,  		
  	FOREIGN KEY(idUser) REFERENCES user(id)
  		on delete restrict on update cascade,
  	FOREIGN KEY(idApplication) REFERENCES application(id)
  		on delete restrict on update cascade
);

CREATE TABLE if not exists products(
	id CHAR(11) NOT NULL PRIMARY KEY,
	name VARCHAR(255),
	stock INTEGER NOT NULL,
	available BOOLEAN NOT NULL,
	availableSince DATE NOT NULL,
	category VARCHAR(255),
	description TEXT(1024),
	currentPrice FLOAT(4,2) NOT NULL
);


CREATE TABLE if not exists Sell(
	id CHAR(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	totalPrice FLOAT(4,2) NOT NULL,
	sellDate DATE NOT NULL,
	idUser CHAR(11) NOT NULL,
	FOREIGN KEY(idUser) REFERENCES user(id)
		on delete restrict on update cascade
);


CREATE TABLE if not exists lineacompra(
	quantity INTEGER NOT NULL,
	totalPrice FLOAT(4,2) NOT NULL,
	unitPrice FLOAT(4,2) NOT NULL,
	lineSell INTEGER NOT NULL,
	idSell CHAR(11) NOT NULL,
	idProducts CHAR(11) NOT NULL,
	PRIMARY KEY(idSell, numLinea),
	FOREIGN KEY(idSell) REFERENCES Sell(id)
		on delete restrict on update cascade,
	FOREIGN KEY(idProducts) REFERENCES products(id)
		on delete restrict on update cascade
);