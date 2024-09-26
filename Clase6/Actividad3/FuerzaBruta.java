package Clase6.Actividad3;

public class FuerzaBruta {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int maxBeneficio = calcularMaxBeneficio(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo (Fuerza Bruta): " + maxBeneficio);
    }

    public static int calcularMaxBeneficio(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int maxBeneficio = 0;

        // Genera todas las combinaciones de proyectos
        for (int i = 0; i < (1 << n); i++) {
            int costoTotal = 0;
            int beneficioTotal = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    costoTotal += costos[j];
                    beneficioTotal += beneficios[j];
                }
            }

            // Verifica si esta dentro del presupuesto
            if (costoTotal <= presupuesto) {
                maxBeneficio = Math.max(maxBeneficio, beneficioTotal);
            }
        }

        return maxBeneficio;
    }
}
