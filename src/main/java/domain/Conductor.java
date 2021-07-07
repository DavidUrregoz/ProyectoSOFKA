package domain;

public class Conductor {
    private String equipo;
    private double estadisticaConductor;
    private Carro carro;

    public Conductor(String equipo, double estadisticaConductor,double estadisticaCarro) {
        this.equipo = equipo;
        this.estadisticaConductor=estadisticaConductor;
        this.carro= new Carro(equipo,estadisticaCarro);   
        System.out.println("Has elegido el equipo: "+this.equipo+" las caracteristicas de tu conductor son: "+this.estadisticaConductor+
                "\nLas caracteristicas de tu carro son: "+carro.getEstadistica());       
    }

    public Conductor() {
    }

    public String getEquipo() {
        return equipo;
    }
    
    public double getEstadisticaConductor() {
        return estadisticaConductor;
    }    

    @Override
    public String toString() {
        return "Conductor " + "equipo=" + equipo ;
    }  


    
}
