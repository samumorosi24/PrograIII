package Clase3.Actividad2;

import java.util.Arrays;

public class DosMayores {

    public static int[] encontrarDosMayores(int[] numeros, int inicio, int fin) {
        if (inicio == fin) {
            return new int[] {numeros[inicio], Integer.MIN_VALUE}; 
        }


        int mitad = (inicio + fin) / 2;

        int[] mayoresIzquierda = encontrarDosMayores(numeros, inicio, mitad);
        int[] mayoresDerecha = encontrarDosMayores(numeros, mitad + 1, fin);

        int[] resultado = new int[2];

        // Encontrar el mayor entre los cuatro (los dos mayores de cada sublista)
        resultado[0] = Math.max(mayoresIzquierda[0], mayoresDerecha[0]);
        
        // Para encontrar el segundo mayor:
        if (mayoresIzquierda[0] == resultado[0]) {
            resultado[1] = Math.max(mayoresIzquierda[1], mayoresDerecha[0]);
        } else {
            resultado[1] = Math.max(mayoresDerecha[1], mayoresIzquierda[0]);
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {12, 35, 1, 10, 34, 1};

        int[] dosMayores = encontrarDosMayores(numeros, 0, numeros.length - 1);

        System.out.println("Los dos números más grandes son: " + Arrays.toString(dosMayores));
    }
}
