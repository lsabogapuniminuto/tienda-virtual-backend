-- =====================================================================
-- Tienda Virtual Uniminuto - Datos de prueba
-- Ejecutar después de 01_crear_base_datos.sql
-- =====================================================================

USE tienda_transaccional;

INSERT INTO transacciones (id_transaccion, nombre, correo, producto, cantidad, fecha, estado, creado_en) VALUES
    ('0b6e2f3a-1c4d-4e5f-8a9b-000000000001', 'Cliente Prueba Uno',  'cliente1@ejemplo.com', 'Gorra',     1, NOW(6), 'CONFIRMADA', NOW(6)),
    ('0b6e2f3a-1c4d-4e5f-8a9b-000000000002', 'Cliente Prueba Dos',  'cliente2@ejemplo.com', 'Camiseta',  2, NOW(6), 'PENDIENTE',  NOW(6)),
    ('0b6e2f3a-1c4d-4e5f-8a9b-000000000003', 'Cliente Prueba Tres', 'cliente3@ejemplo.com', 'Camiseta',  1, NOW(6), 'ERROR',      NOW(6));

-- Verificación
SELECT * FROM transacciones ORDER BY id;
SELECT estado, COUNT(*) AS total FROM transacciones GROUP BY estado;
