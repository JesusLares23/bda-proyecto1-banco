-- Creación de la base de datos
drop database db_banco;
CREATE DATABASE db_banco;
use db_banco;

-- Cuenta para los domicilios
CREATE TABLE Domicilios (
	id_domicilio BIGINT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(50),
    colonia VARCHAR(50),
    numero_exterior VARCHAR(15)
);

-- Tabla para los clientes
CREATE TABLE Clientes (
  id_cliente BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombres VARCHAR(50),
  apellido_paterno VARCHAR(50),
  apellido_materno VARCHAR(50),
  fecha_nacimiento DATE,
  id_domicilio BIGINT NOT NULL,
  FOREIGN KEY (id_domicilio)
	REFERENCES Domicilios (id_domicilio)
);

-- Tabla para las cuentas bancarias
CREATE TABLE Cuentas (
  id_cuenta BIGINT PRIMARY KEY AUTO_INCREMENT,
  numero_cuenta BIGINT,
  fecha_apertura DATE,
  saldo DECIMAL(10,2),
  contra VARCHAR(200),
  estado ENUM('Abierta', 'Cancelada'),
  id_cliente BIGINT NOT NULL,
  FOREIGN KEY (id_cliente) 
	REFERENCES clientes (id_cliente)
);

-- Tabla para registrar los movimientos entre cuentas
CREATE TABLE Transferencias (
  id_transferencia BIGINT PRIMARY KEY AUTO_INCREMENT,
  id_cuenta_origen BIGINT NOT NULL, 
  id_cuenta_destino BIGINT NOT NULL,
  monto DECIMAL(10,2),
  fecha DATETIME,
  FOREIGN KEY (id_cuenta_origen) 
	REFERENCES cuentas (id_cuenta),
  FOREIGN KEY (id_cuenta_destino) 
	REFERENCES cuentas (id_cuenta)
);

-- Tabla para los retiros sin cuenta
CREATE TABLE Retiros (
  id_retiro BIGINT PRIMARY KEY AUTO_INCREMENT, 
  id_cuenta_origen BIGINT,
  folio VARCHAR(10) AUTO_INCREMENT,
  contrasena VARCHAR(8),
  monto DECIMAL(10,2),
  fecha DATETIME,
  cobrado BOOLEAN, -- Indica si ya fue cobrado o no
  FOREIGN KEY (id_cuenta_origen) 
	REFERENCES cuentas (id_cuenta)
);