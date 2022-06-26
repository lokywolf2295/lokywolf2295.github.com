package peliculas.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Pelicula implements Serializable{//se utiliza para java beans
     private String nombre;

    //creamos un constructor vacio para que al momento de crear el objero sin necesidad de mandar argumentos
    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
     
    //para javaBeans necesitamos tambien los metodos get y set 
    public String getNombre() {//obtiene la información
        return nombre;
    }

    public void setNombre(String nombre) {//modifica la información obtenida
        this.nombre = nombre;
    }
    
    //ademas debemos tener los metodos toString hashcode y equals

    @Override//retorna la variable
    public String toString() {
        return this.nombre;
    }

    @Override//genera un numero unico para cada objeto
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override//realiza las comparaciones entre objetos
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
}
