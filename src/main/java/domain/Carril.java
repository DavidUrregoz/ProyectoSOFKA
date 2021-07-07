package domain;

public class Carril {
    private int numeroCarril;
    private static int contadorCarriles;
    
    public Carril(){ 
        Carril.contadorCarriles++;
        this.numeroCarril=Carril.contadorCarriles;
        
    }

    public int getNumeroCarril() {
        return numeroCarril;
    }

    public void setNumeroCarril(int numeroCarril) {
        this.numeroCarril = numeroCarril;
    }

    @Override
    public String toString() {
        return "Carril{" + "numeroCarril=" + numeroCarril + '}';
    } 
}
