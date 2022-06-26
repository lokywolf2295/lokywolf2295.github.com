package peliculas.ui;

import peliculas.modelo.*;//importamos todo del paquete modelo que contiene toda nuestra interfas
import javax.swing.JOptionPane;// para imprimir los mensajes en cuadro de dialogo

public class UIPeliculas {

    //creamos la funcion de interfas
    public static void interfazUsuario() {
        ICatalogoPeliculas peliculas = new ImplementacionCatalogoPeliculas(); //creamos una variable que sera un objeto de la implementación
        Pelicula pelicula; //variable tipo pelicula

        CERRAR://el sistema se cerrará cuando se lo indique
        while (true) {//bucle infinito hasta que se cambie el while

            String opcion = JOptionPane.showInputDialog(//creamos una variable que guarde la opción elegida
                    null, """
                          1 - Insertar Pelicula
                          2 - Listar Pelicula
                          3 - Buscar Pelicula
                          4 - Salir""",
                    "Ingrese una opción",
                    3
            );

            int opcionInt = 0;
            try {//realizamos el control de error para evitar el cierre brusco de la app
                opcionInt = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {//cuando se ingresa caracteres
                JOptionPane.showMessageDialog(
                        null,
                        "Las opciones tienen que ser números enteros\n",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (Exception e){//en caso de otros errores se crea una excepcion general
                JOptionPane.showMessageDialog(
                        null,
                        e,
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            switch (opcionInt) {//creamos un switch que lea la opción elegida e imprima lo que necesitamos ver
                case 1:
                    String nombrePelicula = JOptionPane.showInputDialog(
                            null,
                            "INGRESE EL NOMBRE DE LA PELICULA",
                            "Entrada",
                            3
                    );

                    pelicula = new Pelicula(nombrePelicula);//contruimos la pelicula guardando el nombre recibido mas arriba
                    peliculas.insertarPelicula(pelicula);//luego la pelicula se la inserta en el metodo instertar...
                    break;
                case 2:
                    peliculas.listarPelicula();//se ejecuta el metodo para que listen las peliculas
                    break;
                case 3:
                    nombrePelicula = JOptionPane.showInputDialog(
                            null,
                            "INGRESE EL NOMBRE DE LA PELICULA",
                            "Ingrese",
                            3
                    );
                    peliculas.buscarPelicula(nombrePelicula);//se pide que ingrese un nombre y luego se busca si está o no la pelicula
                    break;
                case 4:
                    break CERRAR;
                default://mensaje que aparecerá cada vez que la opcion que se ingrese no sea la solicitada
                    JOptionPane.showMessageDialog(null,
                            "OPCIÓN INCORRECTA\n"
                            + "VUEVE A IBGRESAR UNA \n"
                            + "OPCIÓN CORRECTA\n"
                            + "LAS OPCIONES SON DE 1 A 4",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE
                    );
            }
        }
    }

}