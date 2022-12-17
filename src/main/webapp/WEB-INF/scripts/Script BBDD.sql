CREATE TABLE `usuarios` 
(
`email` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`nombre` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`apellidos` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`cumple` DATE NOT NULL,
`primres` DATE NOT NULL,
`pass` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`tipo` ENUM( 'admin', 'user' ) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
PRIMARY KEY (email)
)TYPE = INNODB CHARACTER SET utf8 COLLATE utf8_spanish_ci COMMENT = 'TABLA DE USUARIOS';


CREATE TABLE `pistas` 
(
`nombre` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`disponible` ENUM( 'true', 'false' ) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`maxcarts` INT NOT NULL,
`dificultad` ENUM( 'adult', 'child', 'family' ) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
PRIMARY KEY (nombre)
)TYPE = INNODB CHARACTER SET utf8 COLLATE utf8_spanish_ci COMMENT = 'TABLA DE PISTAS';

CREATE TABLE `bonos` 
(
`nbono` INT NULL AUTO_INCREMENT,
`email` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`tipo` ENUM( 'adult', 'child', 'family' ) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`restantes` INT NOT NULL,
`primres` DATE NULL,
`caducidad` DATE NULL,
PRIMARY KEY (nbono),
FOREIGN KEY (email) REFERENCES usuarios(email)
)TYPE = INNODB CHARACTER SET utf8 COLLATE utf8_spanish_ci COMMENT = 'TABLA DE BONOS';

CREATE TABLE `karts` 
(
`id` INT NULL AUTO_INCREMENT,
`tipo` ENUM( 'true', 'false' ) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`estado` ENUM( 'reservado', 'mantenimiento', 'disponible' ) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`pista` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NULL,
PRIMARY KEY (id),
FOREIGN KEY (pista) REFERENCES pistas(nombre)
)TYPE = INNODB CHARACTER SET utf8 COLLATE utf8_spanish_ci COMMENT = 'TABLA DE KARTS';


CREATE TABLE `reservas` 
(
`id` INT NULL AUTO_INCREMENT,
`email` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`descuento` INT NULL,
`duracion` INT NOT NULL,
`pista` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`adultos` INT NULL,
`ninos` INT NULL,
`nbono` INT NULL,
`precio` INT NOT NULL,
`tipo` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
`fecha` DATETIME NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (email) REFERENCES usuarios(email),
FOREIGN KEY (pista) REFERENCES pistas(nombre),
FOREIGN KEY (nbono) REFERENCES bonos(nbono)
)TYPE = INNODB CHARACTER SET utf8 COLLATE utf8_spanish_ci COMMENT = 'TABLA DE RESERVAS';

    -- Usuarios default
    
insert into usuarios
values ('alfonso@gmail.com', 'Alfonso', 'Cabezas Fernandez', '2002/10/10', '2022/11/10', 'alfonso', 'admin');
insert into usuarios
values ('mari32@gmail.com', 'Maria', 'Dolores Castillo', '1975/12/06', '1923/07/12', 'password', 'user');
insert into usuarios
values ('alfonsodlt@gmail.com', 'Alfonso', 'de la Torre', '1953/06/24', '1934/10/12', 'alfonso', 'admin');
insert into usuarios
values ('eduardo@gmail.com', 'Eduardo', 'Martines Rojo', '1912/07/12', '1970/09/22', 'password', 'user');
insert into usuarios
values ('apaco@gmail.com', 'Paco', 'Cordoba Fernandez', '1987/11/09', '1934/10/12', 'password', 'user');
insert into usuarios
values ('cliente@uco.es', 'Juan', 'Cabezas Fernandez', '1987/11/09', '2022/10/12', 'cliente', 'user');
insert into usuarios
values ('admin@uco.es', 'Pedro', 'Cabezas Fernandez', '1987/11/09', '2022/10/12', 'admin', 'admin');

    -- Pistas default

insert into pistas
values ('Mallorca', 'true', 10, 'adult');
insert into pistas
values ('Pamplona', 'true', 12, 'child');
insert into pistas
values ('Sevilla', 'true', 12, 'child');
insert into pistas
values ('Cordoba', 'true', 15, 'family');
insert into pistas
values ('Madrid', 'false', 6, 'family');
insert into pistas
values ('Roma', 'true', 18, 'adult');

    -- Bonos default

insert into bonos
values (NULL, 'alfonso@gmail.com', 'child', 4, '2022/12/10', '2023/03/10');
insert into bonos
values (NULL, 'mari32@gmail.com', 'adult', 4, '2022/12/10', '2023/03/10');
insert into bonos
values (NULL, 'alfonsodlt@gmail.com', 'child', 3, '2022/10/02', '2023/06/02');
insert into bonos
values (NULL, 'eduardo@gmail.com', 'family', 5, NULL, NULL);
insert into bonos
values (NULL, 'apaco@gmail.com', 'family', 2, '2022/10/11', '2023/07/11');

    -- Karts default

insert into karts
values(NULL, 'false', 'disponible','Mallorca');
insert into karts
values(NULL, 'false', 'disponible','Mallorca');
insert into karts
values(NULL, 'false', 'disponible','Mallorca');
insert into karts
values(NULL, 'false', 'disponible','Mallorca');
insert into karts
values(NULL, 'false', 'disponible','Mallorca');
insert into karts
values(NULL, 'false', 'disponible','Pamplona');
insert into karts
values(NULL, 'false', 'disponible','Pamplona');
insert into karts
values(NULL, 'false', 'disponible','Pamplona');
insert into karts
values(NULL, 'false', 'disponible','Sevilla');
insert into karts
values(NULL, 'false', 'disponible','Sevilla');
insert into karts
values(NULL, 'false', 'disponible','Sevilla');
insert into karts
values(NULL, 'false', 'disponible','Sevilla');
insert into karts
values(NULL, 'false', 'disponible','Cordoba');
insert into karts
values(NULL, 'false', 'disponible','Cordoba');
insert into karts
values(NULL, 'false', 'disponible','Cordoba');
insert into karts
values(NULL, 'false', 'disponible','Cordoba');
insert into karts
values(NULL, 'false', 'disponible', 'Madrid');
insert into karts
values(NULL, 'false', 'disponible', 'Madrid');
insert into karts
values(NULL, 'false', 'disponible', 'Madrid');
insert into karts
values(NULL, 'false', 'disponible', 'Madrid');
insert into karts
values(NULL, 'false', 'reservado','Roma');
insert into karts
values(NULL, 'false', 'reservado','Roma');
insert into karts
values(NULL, 'false', 'reservado','Roma');
insert into karts
values(NULL, 'false', 'mantenimiento','Roma');
insert into karts
values(NULL, 'false', 'mantenimiento','Roma');
insert into karts
values(NULL, 'false', 'mantenimiento','Roma');
insert into karts
values(NULL, 'false', 'mantenimiento','Sevilla');
insert into karts
values(NULL, 'false', 'mantenimiento','Sevilla');
insert into karts
values(NULL, 'false', 'mantenimiento','Sevilla');
insert into karts
values(NULL, 'false', 'mantenimiento','Sevilla');
insert into karts
values(NULL, 'false', 'mantenimiento','Pamplona');

    -- Reservas default

insert into reservas
values (null, 'alfonsodlt@gmail.com', 0, 60 , 'Sevilla', null, 3, null, 20, 'class business.reserva.ReservaInfantil', '2023/11/09 10:20');
insert into reservas
values (null, 'alfonso@gmail.com', 0, 120 , 'Sevilla', null, 4, 1, 40, 'class business.reserva.ReservaInfantil', '2023/12/12 16:50');
insert into reservas
values (null, 'eduardo@gmail.com', 0, 60 , 'Madrid', 3, 3, 4, 20, 'class business.reserva.ReservaFamiliar', '2024/12/12 09:10');