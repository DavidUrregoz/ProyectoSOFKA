package domain;

import java.util.ArrayList;
import java.util.List;

public class Podio {
    private final List<Jugador> puestos;
    
    public Podio(){
        this.puestos = new ArrayList<>();
    }

    
    public void ingresar(Jugador puesto){
        this.puestos.add(puesto);
    }

    public List <Jugador> getPuestos() {
        return puestos;
    }

    
    public void imprimirPodio(){
        for (int i = 0; i < puestos.size(); i++) {
            System.out.println("Lugar #"+(i+1)+" : "+ puestos.get(i).getNombreJugador());                
        }
    }       
}