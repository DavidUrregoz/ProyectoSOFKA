package juego;

import datos.JugadorDAO;
import domain.*;
import java.util.*;

public class Estructura {
//    private static Set <Jugador> listaJugadores;

    private static int numeroJugadores;

    public Estructura() {
    }

    public static void jugar() {
        Set<Jugador> listaJugadores = new HashSet<>();
        Pista pista = new Pista();
        pista.ingresaLargo();
        System.out.println("Ingrese el numero de participantes :");
        Scanner sc1 = new Scanner(System.in);
        String nombre;
        int id;
        Estructura.numeroJugadores = sc1.nextInt();
        for (int i = 1; i <= Estructura.numeroJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador: " + i);
            nombre = sc1.next();
            System.out.println("Ingrese el id");
            id = sc1.nextInt();
            Jugador jugador = new Jugador(nombre, id);
            listaJugadores.add(jugador);
        }
        agregarCarril(listaJugadores);
        System.out.println("la pista mide : " + pista.getLargoPista());

        turnos(listaJugadores, pista);

    }

    private static void agregarCarril(Collection<Jugador> coleccion) {
        int contador = 1;
        coleccion.forEach(elemento -> {
            Carril carril = new Carril();
            elemento.setCarril(carril);
            System.out.println("Carril del jugador = " + elemento.getNombreJugador() + " " + carril);
        });
    }

    private static double dado() {
        double numero2 = Math.random() * 6 + 1;
        int numero = (int) numero2;
        System.out.println("Sacaste un = " + numero + " eso te suma : " + numero * 100 + " metros.");
        return numero * 100;
    }

    private static void turnos(Collection<Jugador> listaJugadores, Pista pista) {
        JugadorDAO jugadorDAO = new JugadorDAO();
        boolean bandera = true;
        int contador = 0;
        Podio podio = new Podio();
        Scanner sc2 = new Scanner(System.in);
        double dadoVariable;
        while (bandera) {
            for (Jugador turno : listaJugadores) {
                if (turno.isLlegada() == false) {
                    String enter;
                    System.out.println("\nJugador : " + turno.getNombreJugador() + " Tira el dado con enter");
                    enter = sc2.nextLine();
                    if (enter != null) {
                        dadoVariable = dado();
                        turno.setDistanciaRecorrida(turno.getDistanciaRecorrida() + dadoVariable + turno.getEstadisticaCarro() + turno.getEstadisticaConductor());
                        System.out.println("El total de distancia que llevas de corrida es: " + turno.getDistanciaRecorrida());
                        if (turno.getDistanciaRecorrida() >= pista.getLargoPista()) {
                            podio.ingresar(turno);
                            System.out.println("EL JUGADOR : " + turno.getNombreJugador() + " LLEGO A LA META ");
                            turno.setLlegada(true);
                            contador++;
                            if (contador == 2) {
                                bandera = false;
                                break;
                            }
                            else if(contador == 1){
                                jugadorDAO.desicion(turno);
                            }

                        }

                    }
                }
            }

        }
        podio.imprimirPodio();

    }
}
