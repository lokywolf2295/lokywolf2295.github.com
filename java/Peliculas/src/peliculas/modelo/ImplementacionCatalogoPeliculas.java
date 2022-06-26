package peliculas.modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ImplementacionCatalogoPeliculas implements ICatalogoPeliculas{

    //creamos el array donde guardaremos la lista de peliculas
    private final ArrayList<String> listaPeliculas;
    
    //geeramos su constructor
    public ImplementacionCatalogoPeliculas() {
        this.listaPeliculas = new ArrayList<>();//creamos un objeto para asignar en el constructor
    }

    //se asignará a la lista los nombres
    @Override
    public void insertarPelicula(Pelicula nombrePelicula) {
        this.listaPeliculas.add(nombrePelicula.toString());//obtiene el nombre de la pelicula y lo guarda en el array
    }

    //modificamos el metodo con la impresion de mensajes por cuadro de dialogo
     @Override 
    public void listarPelicula() {
        JOptionPane.showMessageDialog(
                null,
                this.listaPeliculas,
                "LISTA DE PELICULAS",
                JOptionPane.INFORMATION_MESSAGE);
    }

    //modificamos el metodo  y colocamos la condicional que verifica si la pelicula ingresada es igual a la guardada
    @Override
    public void buscarPelicula(String nombrePelicula) {
        String resultado = null;
        for (var pelicula : this.listaPeliculas) {
            if (pelicula.equals(nombrePelicula)) {
                resultado = pelicula;
                break;
            } else {
                resultado = pelicula;
            }
        }

        if (nombrePelicula.equals(resultado)) {//si es verdad imprime un mensaje con el nombre de la pelicula
            JOptionPane.showMessageDialog(
                    null,
                    "La Pelicula -> " + resultado + " Si está listada",
                    "BUSCAR PELICULA",
                    JOptionPane.QUESTION_MESSAGE
            );
        } else {//sino informa que la pelicula no se encontró
            JOptionPane.showMessageDialog(
                    null,
                    "No se encontro la Pelicula -> " + nombrePelicula,
                    "BUSCAR PELICULA",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

}