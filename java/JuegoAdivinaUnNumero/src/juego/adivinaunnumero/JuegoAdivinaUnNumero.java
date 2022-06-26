package juego.adivinaunnumero;

import java.util.Scanner;

public class JuegoAdivinaUnNumero {

    public static void main(String[] args) {
        OUTER:
        while(true){
            System.out.println("======================================");
            System.out.println("|       JUEGO ADIVINA EL NÚMERO       |");
            System.out.println("======================================\n");
            System.out.println("1 - Nivel Facil\n"
                             + "2 - Nivel Intermedio \n"
                             + "3 - Nivel Dificil\n"
                             + "4 - Salir\n");
            
            System.out.print("INGRESE UNA OPCIÓN: ");
            Scanner leer = new Scanner(System.in);
            int opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                        jugar(10);
                        break;
                case 2:
                        jugar(7);
                        break;
                case 3:
                        jugar(5);
                        break;
                case 4:
                        System.out.println("CERRANDO EL JUEGO");
                        break OUTER;
                default:
                        System.out.println("OPCIÓN INCORRECTA\n");
                        break;
            }
        }
    }
    
    /**
     * <h2>Función Jugar</h2>
     * 
     * Genera un numero random que debe ser adividano por el usuario
     * para adivinar ingresa numeros y luego verifica mediante condicionales si los numeros son iguales o no 
     * @param vidas las vidas permiten al programa saber cuantas veces el usuario podrá intentar adivinar el numero hasta ganar o no
     */
    static void jugar(int vidas){
        int numeroRandom = (int)(Math.random()*101);
        int numeroElegido = -1;
        
        Scanner leer = new Scanner(System.in);
        
        while (numeroElegido != numeroRandom){
            System.out.print("Ingrese un número entre 0 y 100: ");
            numeroElegido = leer.nextInt();
            
            if(numeroRandom < numeroElegido){
                System.out.println("\n El Número pensado es mas pequeño");
                vidas--;
            }else if(numeroRandom > numeroElegido){
                System.out.println("\n El Número pensado es mas grande");
                vidas--;
            }
            
            if(vidas == 0){
                System.out.println("\n======================================");
                System.out.println("|              GAME OVER              |");
                System.out.println("======================================\n");
                break;
            }
            System.out.println("\n-------------------------");
            System.out.printf("|   Te quedan %d vidas    |\n",vidas);
            System.out.println("-------------------------\n");
        }
        
        if(numeroElegido == numeroRandom){
            System.out.println("======================================");
            System.out.println("|   FELICITACIONES GANASTE EL JUEGO   |");
            System.out.println("======================================\n");
        }
    }
}
