# Host: localhost  (Version 5.5.24-log)
# Date: 2016-07-27 07:38:14
# Generator: MySQL-Front 5.3  (Build 5.39)

/*!40101 SET NAMES latin1 */;

#
# Structure for table "producto"
#

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `codigoProducto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(18,2) NOT NULL,
  `imagen` varchar(20) NOT NULL,
  PRIMARY KEY (`codigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "producto"
#

INSERT INTO `producto` VALUES (1,'Falda-negra',22.20,'falda-negra.jpg'),(2,'Pantalon-Lineas',24.45,'pantalon-azul.jpg'),(3,'Pantalon-Flor',50.55,'pantalon-flores.jpg'),(4,'Pantalon-top',43.90,'pantalon-top.jpg'),(5,'Polo-mangas',28.80,'polo-mangas.jpg'),(6,'Short-polo',56.80,'short-polo.jpg'),(7,'Short-top',76.70,'short-top.jpg'),(8,'camisa',43.00,'camisa.jpg'),(9,'casa-dama',23.00,'casaca-dama.jpg');

#
# Structure for table "usuarios"
#

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `codUsu` int(11) NOT NULL AUTO_INCREMENT,
  `Apeusu` varchar(30) NOT NULL,
  `nomUsu` varchar(30) NOT NULL,
  `Ditrito` varchar(100) NOT NULL,
  `perfil` varchar(15) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `claveUsu` varchar(30) NOT NULL,
  PRIMARY KEY (`codUsu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "usuarios"
#

INSERT INTO `usuarios` VALUES (1,'Grau Seminario','Miguel','Lima','Admin','Grau@gmail.com','111111'),(2,'Lopez Ruiz','Jenifer','Callao','Cliente','jeny@gmail.com','a1a1a1'),(3,'Aguilera Moreno','Cristina','Miraflores','Cliente','Cristi@gmail.com','a3a3a3');

#
# Structure for table "venta"
#

DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `codigoVenta` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`codigoVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "venta"
#

INSERT INTO `venta` VALUES (1,'JENIFER LOPEZ RUIZ\r\n','2016-06-05 00:00:00'),(2,'Luis','2016-06-30 00:00:00'),(3,'CYNTHIA','2016-06-30 00:00:00'),(4,'ANA','2016-06-30 00:00:00'),(5,'NOMBRE','2016-06-30 00:00:00'),(6,'ANA','2016-06-30 00:00:00'),(7,'NOMBRE','2016-06-30 00:00:00');

#
# Structure for table "detalleventa"
#

DROP TABLE IF EXISTS `detalleventa`;
CREATE TABLE `detalleventa` (
  `codigoVenta` int(11) NOT NULL,
  `codigoProducto` int(11) NOT NULL,
  `cantidad` decimal(18,2) NOT NULL,
  `descuento` decimal(18,2) NOT NULL,
  PRIMARY KEY (`codigoVenta`,`codigoProducto`),
  KEY `FK_DetalleVenta_Producto` (`codigoProducto`),
  CONSTRAINT `FK_DetalleVenta_Producto` FOREIGN KEY (`codigoProducto`) REFERENCES `producto` (`codigoProducto`),
  CONSTRAINT `FK_DetalleVenta_Venta` FOREIGN KEY (`codigoVenta`) REFERENCES `venta` (`codigoVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "detalleventa"
#

INSERT INTO `detalleventa` VALUES (1,2,3.00,3.75),(1,5,2.00,2.88),(2,3,5.00,0.00),(2,4,5.00,0.00),(3,2,1.00,0.00),(3,7,1.00,3.84),(3,8,2.00,4.30),(4,4,2.00,4.39),(4,9,2.00,0.00),(5,9,1.00,0.00),(6,8,1.00,0.00),(6,9,2.00,0.00),(7,8,2.00,4.30),(7,9,2.00,0.00);

#
# Procedure "listarProductos"
#

DROP PROCEDURE IF EXISTS `listarProductos`;
CREATE PROCEDURE `listarProductos`()
SELECT p.codigoProducto,p.nombre,p.precio, p.imagen
FROM producto p ORDER BY P.nombre;

#
# Procedure "sp_actualizarPro"
#

DROP PROCEDURE IF EXISTS `sp_actualizarPro`;
CREATE PROCEDURE `sp_actualizarPro`(cod int ,nom varchar(100),pre decimal(18, 2))
UPDATE producto SET   nombre = nom,  precio = pre
WHERE codigoProducto = cod;

#
# Procedure "sp_detalleVenta"
#

DROP PROCEDURE IF EXISTS `sp_detalleVenta`;
CREATE PROCEDURE `sp_detalleVenta`(num int)
SELECT * from detalleventa WHERE codigoventa=num;

#
# Procedure "sp_insertarPro"
#

DROP PROCEDURE IF EXISTS `sp_insertarPro`;
CREATE PROCEDURE `sp_insertarPro`(
   nom  varchar(100) ,
   pre  decimal(18, 2),
   img  varchar(100)
)
BEGIN
declare cod int;
SELECT IFNULL(MAX(codigoProducto),0)+1 into cod FROM producto;
INSERT INTO producto VALUES (cod,nom,pre,img);
END;

#
# Procedure "sp_loguin"
#

DROP PROCEDURE IF EXISTS `sp_loguin`;
CREATE PROCEDURE `sp_loguin`(usu varchar(10), clave varchar(10))
select * from usuarios where nomUsu=usu and claveUsu=clave;

#
# Procedure "sp_ProductoCod"
#

DROP PROCEDURE IF EXISTS `sp_ProductoCod`;
CREATE PROCEDURE `sp_ProductoCod`(cod int)
SELECT p.codigoProducto, p.nombre, p.precio, p.imagen
FROM producto p WHERE p.codigoProducto =cod ORDER BY P.nombre;

#
# Procedure "sp_RegistrarDetalle"
#

DROP PROCEDURE IF EXISTS `sp_RegistrarDetalle`;
CREATE PROCEDURE `sp_RegistrarDetalle`(
   codVenta  int , codPro int ,
   can decimal(18, 2) , dscto  decimal(18, 2))
BEGIN
INSERT INTO detalleventa VALUES (codVenta,codPro,can,dscto);
END;

#
# Procedure "sp_RegistrarVenta"
#

DROP PROCEDURE IF EXISTS `sp_RegistrarVenta`;
CREATE PROCEDURE `sp_RegistrarVenta`(
   INOUT cod  int ,
   cli  varchar(100) 
)
BEGIN
SELECT IFNULL(MAX(codigoVenta),0)+1 into cod FROM venta;
INSERT INTO venta VALUES ( cod, cli, CURDATE());
END;

#
# Procedure "sp_ventas"
#

DROP PROCEDURE IF EXISTS `sp_ventas`;
CREATE PROCEDURE `sp_ventas`()
SELECT * FROM venta;
