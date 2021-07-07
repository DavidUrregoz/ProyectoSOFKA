package domain;

import java.util.Scanner;

public class Jugador {
    private String nombreJugador;
    private int idJgador;
    private Carril carril;
    private Conductor conductor;
    private double estadisticaCarro;
    private double estadisticaConductor;
    private double distanciaRecorrida = 0;
    private boolean llegada;

    public Jugador(String nombreJugador, int idJgador) {
        this.llegada=false;
        this.nombreJugador = nombreJugador;
        this.idJgador = idJgador;
        int opcion=0;
        String equipo=null;
        
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Elije el numero del equipo con el que vas a participar en la competencia,\n" 
                + "segun el equipo que elijas Automaticamente se asignara un conductor y un carro\n" 
                + "Estos son lo equipos disponibles:\n" 
                + "1. BMW\n" 
                + "2. Audi\n" 
                + "3. Mercedes\n" 
                + "4. Ferrari\n"
                + "5. Escarabajo");
        opcion=sc4.nextInt();
        switch(opcion){
            case 1:
                this.estadisticaCarro  = Math.random()*20;
                this.estadisticaConductor = Math.random()*10-10;
                equipo="BMW";
                break;
            case 2:
                this.estadisticaCarro  = Math.random()*10;
                this.estadisticaConductor = Math.random()*10;
                equipo="Audi";
                break;
            case 3:
                this.estadisticaCarro  = Math.random()*15;
                this.estadisticaConductor = Math.random()*5-5;
                equipo="Mercedes";
                break;
            case 4:
                this.estadisticaCarro  = Math.random()*20;
                this.estadisticaConductor = Math.random()*15-15;
                equipo="Ferrari";
                break;
            case 5:
                this.estadisticaCarro  = Math.random()*40;
                this.estadisticaConductor = Math.random()*20; 
                equipo="Escarabajo";
                break;                
        }        
        conductor = new Conductor(equipo,this.estadisticaConductor,this.estadisticaCarro);        
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getIdJgador() {
        return idJgador;
    }

    public void setIdJgador(int idJgador) {
        this.idJgador = idJgador;
    }

    public Carril getCarril() {
        return carril;
    }
    

    public void setCarril(Carril carril) {
        this.carril = carril;
    }

    public double getEstadisticaCarro() {
        return estadisticaCarro;
    }

    public void setEstadisticaCarro(double estadisticaCarro) {
        this.estadisticaCarro = estadisticaCarro;
    }

    public double getEstadisticaConductor() {
        return estadisticaConductor;
    }
    
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }
    
    public boolean isLlegada() {
        return llegada;
    }

    public void setLlegada(boolean llegada) {
        this.llegada = llegada;
    }
 
    

    @Override
    public String toString() {
        return "Jugador{" + "nombreJugador=" + nombreJugador + ", idJgador=" + idJgador 
                + ", carril=" + carril + ", conductor=" + conductor + ", estadisticaCarro=" 
                + estadisticaCarro + ", estadisticaConductor=" + estadisticaConductor + '}';
    }
           
}
