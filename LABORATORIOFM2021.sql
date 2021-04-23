CREATE SCHEMA IF NOT EXISTS `LaboratioFM2021A` DEFAULT CHARACTER SET utf8 ;
USE `LaboratioFM2021A` ;


CREATE TABLE IF NOT EXISTS `LaboratioFM2021A`.`tbl_cliente` (
  `PK_id_cliente` INT NOT NULL ,
  `nombre_cliente` VARCHAR(45)NOT NULL,
   `apellido_cliente` VARCHAR(45)NOT NULL,
  `edad` VARCHAR(200) NOT NULL,
  `CodigoCorreo` VARCHAR(200) NOT NULL,
  `CodigoDireccion` VARCHAR(200) NOT NULL,
   `CodigoTelefono` VARCHAR(200) NOT NULL,
  `DPI` VARCHAR(200) NOT NULL,
 PRIMARY KEY (`PK_id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE tbl_Registrosatrasados
(

ID INT(30) not null primary key, 
Nombre VARCHAR (60) NOT NULL , 
Apellido Varchar (60) NOT NULL ,
DPI VARCHAR (45) NOT NULL,
Tipo VARCHAR (10) NOT NULL,
Genero varchar (45)NOT NULL,
FechaAlquiler VARCHAR (10) NOT NULL,
FechaCaducidad VARCHAR (10) NOT NULL,
 FechaTarde VARCHAR (10) NOT NULL,
 ImporteCargo VARCHAR (10) NOT NULL,
 Total VARCHAR (10) NOT NULL
 
)ENGINE = InnoDB DEFAULT 
CHARSET = latin1;


create database LaboratioFM2021A;
use LaboratioFM2021A;
create table registroproductovideos
(
ID  int (15) auto_increment primary key,
Nombre varchar (40),
Codigo varchar (40),
Valor varchar (10)
) ENGINE=InnoDB;

create table registroproductodvid
(
ID  int (15) auto_increment primary key,
Nombre varchar (40),
Codigo varchar (40),
Valor varchar (10)
) ENGINE=InnoDB;

