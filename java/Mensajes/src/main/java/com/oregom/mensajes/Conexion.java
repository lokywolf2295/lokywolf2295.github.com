package com.oregom.mensajes;

import java.sql.*;

public class Conexion {

    //variables de tipo privada y que no se pueden modificar
    private static final String URL = "jdbc:mysql://db.subdindetec.lan/pruebajava?serverTimezone=UTC";//direccion de enlace con el servidor junto con zona horaria
    private static final String USER = "mcarballo"; //usuario ara la conexion
    private static final String PASS = "test1234"; //contraseña

    /**
     * Metodo que permite la coneccion de la base de datos con java
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //configuracion del driver a uutilizar
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Metodo que permite cerrar las conexiones abiertas
     */
    public static void cerrar(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void cerrar(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void cerrar(Connection conn) throws SQLException {
        conn.close();
    }

}
