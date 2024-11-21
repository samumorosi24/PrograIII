package Clase11;

public class OficinaDiseno {

    // Tamaño del tablero
    static final int SIZE = 4;

    // Matriz para representar el tablero
    static String[][] tablero = new String[SIZE][SIZE];

    public static void main(String[] args) {
        // Inicializar el tablero con espacios vacíos
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tablero[i][j] = "-"; // - representa un espacio vacío
            }
        }
        
        // Llamar a la función de backtracking para encontrar las configuraciones
        colocarEquipos(0, 0, 0, 0);
    }

    // Función de backtracking para encontrar las configuraciones válidas
    static void colocarEquipos(int filaComputadora, int columnaComputadora, int filaImpresora, int columnaImpresora) {
        // Base case: si hemos colocado todas las computadoras e impresoras, imprimimos la configuración
        if (filaComputadora == SIZE && filaImpresora == SIZE) {
            imprimirTablero();
            return;
        }

        // Intentar colocar computadoras
        if (filaComputadora < SIZE) {
            for (int i = 0; i < SIZE; i++) {
                if (esValido(filaComputadora, i, "Computadora")) {
                    tablero[filaComputadora][i] = "C"; // Colocamos una computadora
                    colocarEquipos(filaComputadora + 1, i, filaImpresora, columnaImpresora);
                    tablero[filaComputadora][i] = "-"; // Deshacemos la colocación
                }
            }
        }

        // Intentar colocar impresoras
        if (filaImpresora < SIZE) {
            for (int j = 0; j < SIZE; j++) {
                if (esValido(filaImpresora, j, "Impresora")) {
                    tablero[filaImpresora][j] = "I"; // Colocamos una impresora
                    colocarEquipos(filaComputadora, columnaComputadora, filaImpresora + 1, j);
                    tablero[filaImpresora][j] = "-"; // Deshacemos la colocación
                }
            }
        }
    }

    // Verifica si es válido colocar el equipo (computadora o impresora) en la posición dada
    static boolean esValido(int fila, int columna, String equipo) {
        // Comprobar si ya hay un equipo en la misma fila o columna
        for (int i = 0; i < SIZE; i++) {
            if (tablero[fila][i].equals(equipo.charAt(0) == 'C' ? "C" : "I") || tablero[i][columna].equals(equipo.charAt(0) == 'C' ? "C" : "I")) {
                return false;
            }
        }
        return true;
    }

    // Función para imprimir el tablero
    static void imprimirTablero() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
