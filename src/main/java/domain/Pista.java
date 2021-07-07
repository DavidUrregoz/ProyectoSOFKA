package domain;

import java.util.Scanner;

public class Pista {

    double largoPista;

    public Pista() {

    }

    public double getLargoPista() {
        return this.largoPista;
    }

    public void ingresaLargo() {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Elija entre que rango de kilometros desea la pista  \n"
        +"1. 1 - 2 Km  \n"
        +"2. 2 - 5 Km   \n"
        +"3. 5 - 10 Km   \n");

        int opcion2 = sc3.nextInt();
        
        switch (opcion2) {
            case 1:
                this.largoPista = (Math.random() * 2 + 1) * 1000;
                System.out.println(this.largoPista);
                
                break;

            case 2:
                this.largoPista = (Math.random() * 2 + 3) * 1000;

                break;
            case 3:
                this.largoPista = (Math.random() * 5 + 5) * 1000;
                break;

        }
    }

    @Override
    public String toString() {
        return "Pista{" + "largo Pista=" + largoPista + '}';
    }

}
