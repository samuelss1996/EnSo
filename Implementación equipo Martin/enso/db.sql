CREATE DATABASE ensop8;
CREATE USER 'enso'@'%' IDENTIFIED BY 'enso';
GRANT ALL PRIVILEGES ON ensop8.* TO 'enso'@'localhost' identified by 'enso';


CREATE TABLE IF NOT EXISTS Usuario (
	ID_User VARCHAR(11) PRIMARY KEY,
	nombre VARCHAR(30) UNIQUE NOT NULL,
	apellidos VARCHAR(100) NOT NULL,
	NIF VARCHAR(9) NOT NULL,
	fecha TIMESTAMP NOT NULL,
	tipo VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS Item (
	ID_Item VARCHAR(11) PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    stock int NOT NULL,
    fecha_disp TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS Pedido (
	ID_Pedido VARCHAR(11) PRIMARY KEY,
    estado VARCHAR(20) NOT NULL,
    ID_autor VARCHAR(11) NOT NULL,
    ID_validador VARCHAR(11) NULL,
	FOREIGN KEY (ID_autor) REFERENCES Usuario(ID_User),
    FOREIGN KEY (ID_validador) REFERENCES Usuario(ID_User)
);

CREATE TABLE IF NOT EXISTS Compra (
	ID_Compra VARCHAR(11) PRIMARY KEY,
    ID_Pedido VARCHAR(11) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    descuento float NULL,
	FOREIGN KEY (ID_Pedido) REFERENCES Pedido(ID_Pedido)
);

CREATE TABLE IF NOT EXISTS LineaCompra (
	ID_Item VARCHAR(11),
	ID_Pedido VARCHAR(11),
    precio float NOT NULL,
    cantidad int NOT NULL,
    PRIMARY KEY(ID_Item, ID_Pedido),
	FOREIGN KEY (ID_Item) REFERENCES Item(ID_Item),
	FOREIGN KEY (ID_Pedido) REFERENCES Pedido(ID_Pedido)
);

