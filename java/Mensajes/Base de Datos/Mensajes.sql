/*Crear base de datos */
CREATE DATABASE mensajes_db 

/*Listar bases de datos*/
SHOW DATABASES; 

/*Eliminar base de datos*/
DROP DATABASE mensajes_db 

/*Seleccionar todos los registros de la tabla*/
SELECT * FROM mensajes_db.mensajes;

/*Para ingresar registros*/
INSERT INTO mensajes_db.mensajes(mensaje,autor,fecha)
/*agregar valores a las columnas*/
VALUES ('Hola como estas', 'Matias',current_time()/*hora y fecha actual*/);

/*nueva inserción*/
INSERT INTO mensajes_db.mensajes(mensaje,autor,fecha)
VALUES ('Hola, todo bien', 'Esequiel',current_time());

/*Modificar valores */
UPDATE mensajes_db.mensajes
SET mensaje='hola, bien y tu', autor='carballo'
WHERE id_mensaje = 2;

/*eliminar valores*/
DELETE FROM mensajes_db.mensajes
WHERE id_mensaje = 3;
