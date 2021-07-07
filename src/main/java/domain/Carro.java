package domain;

public class Carro {
    private String marca;
    private double estadistica;
    
    public Carro(){        
    }

    public Carro(String marca, double estadistica) {
        this.marca = marca;
        this.estadistica = estadistica;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(double estadistica) {
        this.estadistica = estadistica;
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", estadistica=" + estadistica + '}';
    }
    
}
