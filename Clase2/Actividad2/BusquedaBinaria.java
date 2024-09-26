package Clase2.Actividad2;

public class BusquedaBinaria {

    public static int busquedaBinaria(int[] array, int objetivo) {
        int izquierda = 0; 
        int derecha = array.length - 1; 

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2; 

            // Verificar si el objetivo está en el medio
            if (array[medio] == objetivo) {
                return medio; 
            }
            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (array[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                // Si el objetivo es menor, ignorar la mitad derecha
                derecha = medio - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arrayOrdenado = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // Elemento a buscar
        int objetivo = 7;

        
        int resultado = busquedaBinaria(arrayOrdenado, objetivo);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado en el array.");
        }
    }
}
