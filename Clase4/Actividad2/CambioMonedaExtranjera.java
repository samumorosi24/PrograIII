package Clase4.Actividad2;

import java.util.*;

public class CambioMonedaExtranjera {
    // Encontrar la combinación mínima de comprobantes
    public static List<Integer> encontrarMinimoComprobantes(int[] comprobantes, int monto) {
        // Ordenar los comprobantes de mayor a menor
        Arrays.sort(comprobantes);
        
        List<Integer> resultado = new ArrayList<>();

        for (int i = comprobantes.length - 1; i >= 0; i--) {
            while (monto >= comprobantes[i]) {
                monto -= comprobantes[i];
                resultado.add(comprobantes[i]);
            }
        }

        if (monto > 0) {
            System.out.println("No se puede realizar el cambio exacto con los comprobantes disponibles.");
            return new ArrayList<>(); 
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        int[] comprobantes = {1, 5, 10, 20, 50, 100};
        int monto = 155;
        List<Integer> resultado = encontrarMinimoComprobantes(comprobantes, monto);
        
        if (!resultado.isEmpty()) {
            System.out.println("Comprobantes usados para hacer " + monto + ": " + resultado);
        }
    }
}
