package com.oregom.mensajes;

import java.util.logging.Logger;

public class Mensaje {

    private int id;
    private String mensaje;
    private String autor;
    private String fecha;

    //crear constructor vacio
    public Mensaje() {
    }

    //constructorpara eliminar mensajes
    public Mensaje(int id) {
        this.id = id;
    }

    //constructor para agregar mensaje
    public Mensaje(String mensaje, String autor) {
        this.mensaje = mensaje;
        this.autor = autor;
    }

//constructor para actualizar mensaje
    public Mensaje(int id, String mensaje, String autor) {
        this.id = id;
        this.mensaje = mensaje;
        this.autor = autor;
    }

//constructor para construir un mensaje nuevo
    public Mensaje(int id, String mensaje, String autor, String fecha) {
        this.id = id;
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    //metodos Get and Set de todos para obtener y modificar los datos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mensaje{");
        sb.append("id=").append(id);
        sb.append(", mensaje=").append(mensaje);
        sb.append(", autor=").append(autor);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }

}
