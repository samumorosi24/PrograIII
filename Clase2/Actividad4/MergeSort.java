package Clase2.Actividad4;

public class MergeSort {

    // divido y ordena el array
    public static void mergeSort(int[] array, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            mergeSort(array, izquierda, medio);
            mergeSort(array, medio + 1, derecha);

            merge(array, izquierda, medio, derecha);
        }
    }

    // combinar dos subarrays ordenados
    private static void merge(int[] array, int izquierda, int medio, int derecha) {
        // Tamaños de las sublistas
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Arrays para almacenar las dos mitades
        int[] izquierdaArray = new int[n1];
        int[] derechaArray = new int[n2];

        // copiar los datos a los arrays 
        for (int i = 0; i < n1; i++) {
            izquierdaArray[i] = array[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            derechaArray[j] = array[medio + 1 + j];
        }

        // Combinar los arrays en el array original
        int i = 0, j = 0; 
        int k = izquierda; 

        while (i < n1 && j < n2) {
            if (izquierdaArray[i] <= derechaArray[j]) {
                array[k] = izquierdaArray[i];
                i++;
            } else {
                array[k] = derechaArray[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de izquierdaArray si es que quedan
        while (i < n1) {
            array[k] = izquierdaArray[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de derechaArray si es que quedan
        while (j < n2) {
            array[k] = derechaArray[j];
            j++;
            k++;
        }
    }

    public static void imprimirArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Array antes de ordenar:");
        imprimirArray(array);

        // Merge Sort
        mergeSort(array, 0, array.length - 1);

        System.out.println("Array después de ordenar:");
        imprimirArray(array);
    }
}
