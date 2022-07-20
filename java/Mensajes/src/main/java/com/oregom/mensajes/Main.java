package com.oregom.mensajes;

import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        Conexion.getConnection();
        System.out.println("Conexion Extosa");

        MensajeDao mensajeDao = new MensajeDao();

        List<Mensaje> mensajes = mensajeDao.seleccionar(); //devuelve la lista que la almaceno en mensajes

        for (Mensaje mensaje : mensajes) {//recupera datos de tipo Mensaje en la variable mensaje de la lista mensajes
            System.out.println(mensaje);
        }
    }
}
