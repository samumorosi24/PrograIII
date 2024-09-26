package Clase2.Actividad3;

public class QuickSort {

    // intercambiar elementos en el array
    private static void intercambiar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quicksort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(array, inicio, fin);

            quicksort(array, inicio, indicePivote - 1);
            quicksort(array, indicePivote + 1, fin);
        }
    }

    // encontrar el pivote y dividir el array
    private static int particionar(int[] array, int inicio, int fin) {
        int pivote = array[fin]; 
        int i = inicio - 1; 

        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivote) {
                i++;
                intercambiar(array, i, j);
            }
        }

        
        intercambiar(array, i + 1, fin);
        return i + 1; 
    }

   
    public static void imprimirArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 4, 7, 9, 1, 15, 3};

        System.out.println("Array antes de ordenar:");
        imprimirArray(array);

        // Ordenar el array con Quicksort
        quicksort(array, 0, array.length - 1);

        System.out.println("Array después de ordenar:");
        imprimirArray(array);
    }
}
