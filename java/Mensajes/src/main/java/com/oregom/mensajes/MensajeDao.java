package com.oregom.mensajes;

import static com.oregom.mensajes.Conexion.*;
import java.sql.*;
import java.util.*;

public class MensajeDao {
    //dao significa Objeto de Acceso a Datos
    //maneja el acceso a los datos del sql

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Mensaje mensaje;

    public List<Mensaje> seleccionar() throws ClassNotFoundException {
        String sql = "SELECT * FROM mensajes";
        List<Mensaje> mensajes = new ArrayList<>(); //lista vacia donde se almacenan los mensajes a crear

        try {
            this.conn = getConnection(); //preparar para la conexion
            this.ps = this.conn.prepareStatement(sql); //preparamos para la consuta sql
            this.rs = this.ps.executeQuery(); //resultado de la conexion

            while (this.rs.next()) {
                int id = this.rs.getInt("id_mensaje");
                String msm = this.rs.getString("mensaje");
                String autor = this.rs.getString("autor");
                String fecha = this.rs.getString("fecha");

                this.mensaje = new Mensaje(id, msm, autor, fecha); //creamos un objeto
                mensajes.add(this.mensaje); //el cual se almacenara en la listaantes creada
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.rs);
                cerrar(this.ps);
                cerrar(this.conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return mensajes;
    }
}
