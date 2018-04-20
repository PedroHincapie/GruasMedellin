CREATE DATABASE motos_gruas;

use motos_gruas;


CREATE TABLE clientes
(
id_cliente INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
nom_cliente VARCHAR(50) NOT NULL,
telefono VARCHAR(25) NOT NULL
);

CREATE TABLE motos
(
id_moto INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
marca  VARCHAR(50) NOT NULL
);

CREATE TABLE servicios
(
id_servicio INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
id_moto INT UNSIGNED,
id_cliente INT UNSIGNED,
ubicacion VARCHAR(50) NOT NULL,
destino VARCHAR(50) NOT NULL,
costo DOUBLE(7,1) NOT NULL,
estado VARCHAR(50) NOT NULL,
FOREIGN KEY (id_moto) REFERENCES motos(id_moto),
FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);


INSERT INTO clientes ( nom_cliente, telefono) VALUES ('Pedro Jesus Hincapie Garcia', '3003481990');
INSERT INTO clientes ( nom_cliente, telefono) VALUES ('Carlos Mario Moreno', '3011154154');

INSERT INTO motos ( marca) VALUES ('Honda 100');
INSERT INTO motos ( marca) VALUES ('KTM 1000');
INSERT INTO motos ( marca) VALUES ('C90');

INSERT INTO servicios (
	id_moto,
	id_cliente,
	ubicacion,
	destino,
	costo,
	estado)
VALUES (1,1, 'Bello', 'Girardota', '200000', 'COMPLETO');

INSERT INTO servicios (
	id_moto,
	id_cliente,
	ubicacion,
	destino,
	costo,
	estado)
VALUES (2,1, 'Estadio', 'Girardota', '200000', 'PROCESO');