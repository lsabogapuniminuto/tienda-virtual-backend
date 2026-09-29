-- =====================================================================
-- Tienda Virtual Uniminuto - Creación de la base de datos
-- Motor: MySQL 8.0
-- Base de datos: tienda_transaccional
-- Entidad JPA: edu.uniminuto.transacciones.model.Transaccion
-- =====================================================================

CREATE DATABASE IF NOT EXISTS tienda_transaccional
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE tienda_transaccional;

CREATE TABLE IF NOT EXISTS transacciones (
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    id_transaccion  VARCHAR(64)  NOT NULL,
    nombre          VARCHAR(120) NOT NULL,
    correo          VARCHAR(150) NOT NULL,
    producto        VARCHAR(100) NOT NULL,
    cantidad        INT          NOT NULL,
    fecha           DATETIME(6)  NOT NULL,
    estado          ENUM('PENDIENTE', 'CONFIRMADA', 'ERROR') NOT NULL,
    creado_en       DATETIME(6)  NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_transacciones_id_transaccion UNIQUE (id_transaccion)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- Verificación
SHOW TABLES;
DESCRIBE transacciones;
