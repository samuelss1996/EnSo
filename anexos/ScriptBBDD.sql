CREATE USER 'enso'@'localhost' IDENTIFIED BY 'enso';
CREATE DATABASE IF NOT EXISTS enso CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
GRANT USAGE ON *.* to 'enso'@'localhost' IDENTIFIED BY 'enso';
GRANT ALL PRIVILEGES ON enso.* to 'enso'@'localhost';
USE enso;

CREATE TABLE if not exists center (
  id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE if not exists user(
	id CHAR(11) PRIMARY KEY,
	idCenter INTEGER NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	dateRegister DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	email VARCHAR(50),
	nif CHAR(9) NOT NULL,
	type CHAR(1), -- E, P, D
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
	currentPrice FLOAT NOT NULL
);


CREATE TABLE if not exists Sell(
	id CHAR(11) NOT NULL PRIMARY KEY,
	totalPrice FLOAT NOT NULL,
	sellDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	idUser CHAR(11) NOT NULL,
	FOREIGN KEY(idUser) REFERENCES user(id)
		on delete restrict on update cascade
);


CREATE TABLE if not exists lineacompra(
	quantity INTEGER NOT NULL,
	totalPrice FLOAT NOT NULL,
	unitPrice FLOAT NOT NULL,
	lineSell INTEGER NOT NULL,
	idSell CHAR(11) NOT NULL,
	idProducts CHAR(11) NOT NULL,
	PRIMARY KEY(idSell, lineSell),
	FOREIGN KEY(idSell) REFERENCES Sell(id)
		on delete restrict on update cascade,
	FOREIGN KEY(idProducts) REFERENCES products(id)
		on delete restrict on update cascade
);

INSERT into center(name) values ('ETSE');

INSERT into user(id, idCenter, firstName, lastName, email, nif, type) values ('U-AAAA-000', 1, 'Usuario1', 'Usuario', 'email@email.com', '12345678A', 'E');
INSERT into user(id, idCenter, firstName, lastName, email, nif, type) values ('U-AAAA-001', 1, 'Usuario2', 'Usuario', 'email2@email.com', '09876543A', 'E');

INSERT into application(status, content) values ('pending', 'Request for I-AAAA-000');

INSERT into belongto(idCenter, idUser, idApplication) values (1, 'U-AAAA-000', 1);

INSERT into products(id, name, stock, available, availableSince, category, description, currentPrice)
       values ('I-AAAA-000', 'Producto1', '100', true, '2017-03-01', 'categoria', 'Descripcion del producto', 99.99);
INSERT into products(id, name, stock, available, availableSince, category, description, currentPrice)
       values ('I-AAAA-001', 'Producto2', '100', true, '2017-02-15', 'categoria', 'Descripcion del producto', 49.99);
	   
INSERT into sell(id, totalPrice, sellDate, idUser) 
	VALUES (1, 10.00, '2017-04-22 11:00:00', 'U-AAAA-000');
INSERT into sell(id, totalPrice, sellDate, idUser)
	VALUES (2, 24.50, '2017-03-22 11:00:00', 'U-AAAA-000');
INSERT into sell(id, totalPrice, sellDate, idUser)
	VALUES (3, 24.50, '2017-03-23 11:00:00', 'U-AAAA-000');