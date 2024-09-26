package Clase4.Actividad1;

import java.util.*;

public class CambioExacto {
    public static List<Integer> obtenerMonedas(int[] denominaciones, int monto) {
        List<Integer> monedasUsadas = new ArrayList<>();

        Arrays.sort(denominaciones);
        Collections.reverse(Arrays.asList(denominaciones));

        for (int moneda : denominaciones) {
            while (monto >= moneda) {
                monto -= moneda;
                monedasUsadas.add(moneda);
            }
        }
        return monto == 0 ? monedasUsadas : Collections.emptyList();
    }

    public static void main(String[] args) {
        int[] denominaciones = {1, 5, 10, 25};
        int monto = 36; 
        
        List<Integer> resultado = obtenerMonedas(denominaciones, monto);
        
        if (!resultado.isEmpty()) {
            System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
        } else {
            System.out.println("No es posible entregar el cambio exacto de " + monto);
        }
    }
}
