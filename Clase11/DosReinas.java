package Clase11;

public class DosReinas {
    public static void main(String[] args) {
        int n = 4; // Tamaño del tablero (4x4)
        resolverDosReinas(n);
    }

    public static void resolverDosReinas(int n) {
        int[] tablero = new int[2]; // Usamos solo 2 reinas
        resolver(tablero, 0, n);
    }

    // Función recursiva de backtracking
    public static void resolver(int[] tablero, int fila, int n) {
        if (fila == 2) { // Hemos colocado las dos reinas
            mostrarTablero(tablero, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            // Verificamos si es seguro colocar una reina en la fila y columna
            if (esValido(tablero, fila, col, n)) {
                tablero[fila] = col;
                resolver(tablero, fila + 1, n);
            }
        }
    }

    // Verifica si es válido colocar una reina en (fila, col)
    public static boolean esValido(int[] tablero, int fila, int col, int n) {
        for (int i = 0; i < fila; i++) {
            // Verificamos si las reinas están en la misma columna o en la misma diagonal
            if (tablero[i] == col || Math.abs(tablero[i] - col) == Math.abs(i - fila)) {
                return false;
            }
        }
        return true;
    }

    // Función para mostrar el tablero
    public static void mostrarTablero(int[] tablero, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[0] == j && i == 0) {
                    System.out.print(" R "); // Primera reina
                } else if (tablero[1] == j && i == 1) {
                    System.out.print(" R "); // Segunda reina
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
