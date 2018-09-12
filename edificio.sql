﻿--
-- Script was generated by Devart dbForge Studio for MySQL, Version 8.0.40.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 9/12/2018 7:14:08 AM
-- Server version: 5.5.5-10.1.34-MariaDB
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

--
-- Set default database
--
USE edificio;

--
-- Drop table `pagos`
--
DROP TABLE IF EXISTS pagos;

--
-- Drop table `alquiler`
--
DROP TABLE IF EXISTS alquiler;

--
-- Drop table `inquilino`
--
DROP TABLE IF EXISTS inquilino;

--
-- Drop table `detalles`
--
DROP TABLE IF EXISTS detalles;

--
-- Drop table `expensa`
--
DROP TABLE IF EXISTS expensa;

--
-- Drop table `oficina`
--
DROP TABLE IF EXISTS oficina;

--
-- Drop table `titular`
--
DROP TABLE IF EXISTS titular;

--
-- Set default database
--
USE edificio;

--
-- Create table `titular`
--
CREATE TABLE titular (
  nroTitular int(11) NOT NULL AUTO_INCREMENT,
  CI int(11) NOT NULL,
  nombre varchar(255) NOT NULL,
  teléfono int(11) NOT NULL,
  dirección varchar(50) NOT NULL,
  NIT int(11) NOT NULL,
  PRIMARY KEY (nroTitular)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `oficina`
--
CREATE TABLE oficina (
  nroOficina int(11) NOT NULL AUTO_INCREMENT,
  nroTitular int(11) NOT NULL,
  dimensión varchar(255) NOT NULL,
  nroPlanta int(11) NOT NULL,
  estado varchar(255) NOT NULL,
  PRIMARY KEY (nroOficina)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE oficina
ADD CONSTRAINT FK_oficina_titular_nroTitular FOREIGN KEY (nroTitular)
REFERENCES titular (nroTitular) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `expensa`
--
CREATE TABLE expensa (
  nroOficina int(11) NOT NULL AUTO_INCREMENT,
  costoTeléfono int(11) NOT NULL,
  costoLuz int(11) NOT NULL,
  costoAgua int(11) NOT NULL,
  PRIMARY KEY (nroOficina)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE expensa
ADD CONSTRAINT FK_expensa_oficina_nroOficina FOREIGN KEY (nroOficina)
REFERENCES oficina (nroOficina) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `detalles`
--
CREATE TABLE detalles (
  nroAlquiler int(11) NOT NULL AUTO_INCREMENT,
  nroOficina int(11) NOT NULL,
  precioOficina double NOT NULL,
  PRIMARY KEY (nroAlquiler)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create index `FK_detalles_expensa_nroOficina` on table `detalles`
--
ALTER TABLE detalles
ADD INDEX FK_detalles_expensa_nroOficina (nroOficina);

--
-- Create foreign key
--
ALTER TABLE detalles
ADD CONSTRAINT FK_detalles_oficina_nroOficina FOREIGN KEY (nroOficina)
REFERENCES oficina (nroOficina) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `inquilino`
--
CREATE TABLE inquilino (
  nroInquilino int(11) NOT NULL AUTO_INCREMENT,
  CI int(11) NOT NULL,
  nombre varchar(30) NOT NULL,
  teléfono int(11) NOT NULL,
  dirección varchar(50) NOT NULL,
  NIT int(11) NOT NULL,
  PRIMARY KEY (nroInquilino)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `alquiler`
--
CREATE TABLE alquiler (
  nroAlquiler int(11) NOT NULL AUTO_INCREMENT,
  nroInquilino int(11) NOT NULL,
  fecha varchar(100) NOT NULL,
  PRIMARY KEY (nroAlquiler)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE alquiler
ADD CONSTRAINT FK_alquiler_detalles_nroAlquiler FOREIGN KEY (nroAlquiler)
REFERENCES detalles (nroAlquiler) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE alquiler
ADD CONSTRAINT FK_alquiler_inquilino_nroInquilino FOREIGN KEY (nroInquilino)
REFERENCES inquilino (nroInquilino) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `pagos`
--
CREATE TABLE pagos (
  nroPago int(11) NOT NULL,
  nroAlquiler int(11) NOT NULL,
  fechaPago varchar(255) NOT NULL,
  monto decimal(8, 2) NOT NULL,
  PRIMARY KEY (nroPago)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE pagos
ADD CONSTRAINT FK_pagos_alquiler_nroAlquiler FOREIGN KEY (nroAlquiler)
REFERENCES alquiler (nroAlquiler) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- 
-- Dumping data for table titular
--
-- Table edificio.titular does not contain any data (it is empty)

-- 
-- Dumping data for table oficina
--
-- Table edificio.oficina does not contain any data (it is empty)

-- 
-- Dumping data for table inquilino
--
-- Table edificio.inquilino does not contain any data (it is empty)

-- 
-- Dumping data for table detalles
--
-- Table edificio.detalles does not contain any data (it is empty)

-- 
-- Dumping data for table alquiler
--
-- Table edificio.alquiler does not contain any data (it is empty)

-- 
-- Dumping data for table pagos
--
-- Table edificio.pagos does not contain any data (it is empty)

-- 
-- Dumping data for table expensa
--
-- Table edificio.expensa does not contain any data (it is empty)

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;