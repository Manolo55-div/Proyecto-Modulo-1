public class Arma {
    private int municion;
    private String cargador;

    public Arma(int municion, String cargador) {
        this.municion = municion;
        this.cargador = cargador;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

    public void disparar() {
        if (municion > 0) {
            municion--;
            System.out.println("Bang! Munición restante: " + municion);
        } else {
            System.out.println("Sin munición!");
        }
    }

    public void mostrarInfo() {
        System.out.println("Arma [Munición: " + municion + ", Cargador: " + cargador + "]");
    }
}
