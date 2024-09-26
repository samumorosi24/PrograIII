package Clase3.Actividad4;

import java.util.Arrays;

public class ElementosNMasGrandes {

    public static int[] encontrarNElementosMaximos(int[] array, int n) {
        if (array.length <= n) {
            return array;
        }

        // Dividir el array en dos partes
        int mitad = array.length / 2;
        int[] izquierda = Arrays.copyOfRange(array, 0, mitad);
        int[] derecha = Arrays.copyOfRange(array, mitad, array.length);

        // Llamadas recursivas para encontrar los n elementos más grandes en cada mitad
        int[] maxIzquierda = encontrarNElementosMaximos(izquierda, n);
        int[] maxDerecha = encontrarNElementosMaximos(derecha, n);

        // Combinar los resultados y obtener los n elementos más grandes
        return combinarYObtenerMaximos(maxIzquierda, maxDerecha, n);
    }

    private static int[] combinarYObtenerMaximos(int[] izquierda, int[] derecha, int n) {
        // Combinar las dos listas
        int[] combinado = new int[izquierda.length + derecha.length];
        System.arraycopy(izquierda, 0, combinado, 0, izquierda.length);
        System.arraycopy(derecha, 0, combinado, izquierda.length, derecha.length);

        // Ordenar la lista
        Arrays.sort(combinado);

        // Tomar los últimos n elementos (los más grandes)
        return Arrays.copyOfRange(combinado, combinado.length - n, combinado.length);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 8, 2, 5, 10, 4, 6, 9};
        int n = 3; 

        int[] resultado = encontrarNElementosMaximos(array, n);

        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(resultado));
    }
}
