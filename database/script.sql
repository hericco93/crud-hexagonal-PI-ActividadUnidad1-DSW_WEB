CREATE DATABASE IF NOT EXISTS mibasededatos;
USE mibasededatos;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) NOT NULL
    );

INSERT INTO usuarios (nombre, email, password, tipo)
VALUES ('Admin Principal', 'admin@correo.com', '123456', 'ADMIN');