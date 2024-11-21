package Clase7.Actividad2;

public class FloydWarshall {
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
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

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
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