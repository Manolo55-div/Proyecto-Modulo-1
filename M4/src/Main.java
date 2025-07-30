//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear un array de M4
        M4[] arsenal = new M4[3];

        arsenal[0] = new M4(30, "Retícula Roja", "Cargador Estándar", 5, "M4A1");
        arsenal[1] = new M4(15, "Retícula Verde", "Cargador Largo", 5, "M4 Carbine");
        arsenal[2] = new M4(5, "Retícula Azul", "Cargador Rápido", 5, "M4 CQB");


        // Simular disparos en todas las armas
        for (int i = 0; i < arsenal.length; i++) {
            System.out.println("\nArma " + (i + 1) + ":");
            arsenal[i].disparar(10); // Dispara 10 balas en cada arma
        }

        // Recargar todas las armas usando la interfaz
        System.out.println("\nRecargando todas las armas...");
        for (M4 arma : arsenal) {
            arma.recargar();
        }
    }
}
