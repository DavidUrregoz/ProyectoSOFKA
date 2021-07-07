package juego;

import java.util.Scanner;
import datos.*;

public class CarrosxConsola {
    public static void main(String[] args) {
        Estructura estructura = new Estructura();
        JugadorDAO jugadorDAO = new JugadorDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Esto es Carros por consola\n"
                + "que desea hacer?\n"
                + "1. Jugar.\n"
                + "2. Ver base de datos de ganadores.\n"
                + "3. Eliminar base de datos.\n");
        
        int opcion1=sc.nextInt();
        switch(opcion1){
            case 1:
                Estructura.jugar();
                break;
            case 2:
                jugadorDAO.seleccionar();
                break;
                
            case 3:
                System.out.println("No disponible ");
                break;                
        }
        
    }
}
