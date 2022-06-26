package peliculas;

//import java.util.ArrayList;//se utiliza para implementar los arraylist
import javax.swing.JOptionPane;//se utiliza para aplicar los cuadros de dialogo
import peliculas.ui.UIPeliculas;

public class Main {

    public static void main(String[] args) {
        
        //instanciamos la interfas de usuario
        UIPeliculas.interfazUsuario();
        
        /*
        // ArrayList almacena una lista de objetos
        ArrayList<String> meses = new ArrayList<>();//así definimos un arrayList
        //esto lo que permite es no definir de entrada la cantidad de datos a introducir sino que
        //podemos ingresar una cantidad indefinida de datos
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        
        System.out.println(meses);
        
        for(String dato : meses){
            System.out.println(dato);
        }
    */
     /*   
        //cuadro de input
        String valor = JOptionPane.showInputDialog(//valor lo que hace es guardar lo que se obtenga del input
                null,
                "Ingrese texto",
                "Entrada",
                3);
        
        //cuadro de dialogo
        JOptionPane.showMessageDialog(
                null,//nulo por el momento ya que se utiliza para cuadros mas abanzados
                valor,//mensaje a imprimir
                "Mi Mensaje",//titulo del mensaje
                2);//representa al icono que aparecerá (se puede colocar en numero o en la opcion)
    */
    }
}
