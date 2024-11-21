package Clase11;

public class Backtracking {
    
    // Método para imprimir el tablero
    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Método para realizar la búsqueda en profundidad (Backtracking)
    public static void generarCombinaciones(char[][] tablero, int fila, boolean[] columnasEscritorio, boolean[] columnasSilla) {
        if (fila == 4) {
            imprimirTablero(tablero);  // Si hemos colocado todos los escritorios y sillas, imprimimos el tablero
            return;
        }

        for (int colE = 0; colE < 4; colE++) {
            if (!columnasEscritorio[colE]) {  // Si no hay escritorio en esa columna
                tablero[fila][colE] = 'E';  // Colocamos el escritorio
                columnasEscritorio[colE] = true;

                for (int colS = 0; colS < 4; colS++) {
                    if (!columnasSilla[colS] && colS != colE) {  // Si no hay silla en esa columna y no está en la misma columna que el escritorio
                        tablero[fila][colS] = 'S';  // Colocamos la silla
                        columnasSilla[colS] = true;
                        generarCombinaciones(tablero, fila + 1, columnasEscritorio, columnasSilla);  // Llamada recursiva para la siguiente fila
                        columnasSilla[colS] = false;  // Volver atrás (backtracking)
                        tablero[fila][colS] = '-';  // Limpiamos la silla en el tablero
                    }
                }

                columnasEscritorio[colE] = false;  // Volver atrás (backtracking)
                tablero[fila][colE] = '-';  // Limpiamos el escritorio en el tablero
            }
        }
    }

    public static void main(String[] args) {
        char[][] tablero = new char[4][4];  // Tablero de 4x4
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tablero[i][j] = '-';  // Inicializamos el tablero vacío
            }
        }

        boolean[] columnasEscritorio = new boolean[4];  // Para saber si ya hay un escritorio en una columna
        boolean[] columnasSilla = new boolean[4];  // Para saber si ya hay una silla en una columna

        generarCombinaciones(tablero, 0, columnasEscritorio, columnasSilla);  // Llamamos al método de backtracking
    }
}
