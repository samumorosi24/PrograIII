package Clase7.Actividad1;

public class FloydWarshall {
    final static int INF = Integer.MAX_VALUE;  
    
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = { 
            {0, 8, 5},
            {3, 0, INF},
            {INF, 2, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Uso del algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF  ");
                else
                    System.out.print(dist[i][j] + "    "); 
            }
            System.out.println();
        }
    }
}
