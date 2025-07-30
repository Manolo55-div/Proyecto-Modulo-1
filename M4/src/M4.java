public class M4 extends Arma implements Recargable {
      private int municion;
      private String reticula;
      private String cargador;
      private final int CAPACIDAD_MAXIMA = 30;

      public M4(int municion, String reticula, String cargador, int calibre, String nombre) {
            super(calibre, nombre); // Llama al constructor de Arma
            this.municion = municion;
            this.reticula = reticula;
            this.cargador = cargador;
      }


      public void disparar(int balas) {
            if (balas <= 0) {
                  System.out.println("Cantidad inválida de balas.");
                  return;
            }
            if (municion >= balas) {
                  municion -= balas;
                  System.out.println("Disparaste " + balas + " balas. Munición restante: " + municion);
            } else {
                  System.out.println("No hay suficientes balas. Disparaste " + municion + " balas.");
                  municion = 0;
            }
      }

      @Override
      public void recargar() {
            municion = CAPACIDAD_MAXIMA;
            System.out.println("Arma recargada. Munición: " + municion);
      }

      public int getMunicion() {
            return municion;
      }
}
