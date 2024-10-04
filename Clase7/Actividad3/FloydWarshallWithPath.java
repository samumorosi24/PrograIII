package Clase7.Actividad3;

import java.util.Scanner;

public class FloydWarshallWithPath {
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int path[][] = new int[V][V];

        // Inicializar la matriz de distancias y la matriz de caminos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1; // No hay camino
                }
            }
        }

        // Actualizar la matriz de distancias y la matriz de caminos
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k; // Actualiza el camino
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);

        try (// Obtener el camino más corto entre dos nodos
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nodo de origen (0 a " + (V - 1) + "):");
            int source = scanner.nextInt();
            System.out.println("Ingrese el nodo de destino (0 a " + (V - 1) + "):");
            int destination = scanner.nextInt();

            System.out.print("El camino más corto de " + source + " a " + destination + " es: ");
            printPath(path, source, destination);
        }
        System.out.println();
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printPath(int path[][], int u, int v) {
        if (path[u][v] == -1) {
            System.out.print("No hay camino.");
            return;
        }
        if (path[u][v] == u) {
            System.out.print(u + " ");
            return;
        }
        printPath(path, u, path[u][v]);
        System.out.print(path[u][v] + " ");
    }

    public static void main(String[] args) {
        FloydWarshallWithPath fw = new FloydWarshallWithPath();
        // Grafo representado como matriz de adyacencia
        int graph[][] = {
            {0, 2, INF, 5},
            {INF, 0, INF, 4},
            {INF, INF, 0, INF},
            {INF, INF, 2, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }
}
