package Clase5.Actividad4;

import java.util.*;

class Grafo {
    private final int vertices;
    private final List<List<Arista>> adyacencia;

    public Grafo(int v) {
        vertices = v;
        adyacencia = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso)); // Para grafos no dirigidos
    }

    public void dijkstra(int inicio) {
        int[] tiempos = new int[vertices];
        Arrays.fill(tiempos, Integer.MAX_VALUE);
        tiempos[inicio] = 0;

        PriorityQueue<Arista> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        cola.add(new Arista(inicio, 0));

        while (!cola.isEmpty()) {
            Arista actual = cola.poll();
            int vertice = actual.destino;

            for (Arista arista : adyacencia.get(vertice)) {
                int nuevoTiempo = tiempos[vertice] + arista.peso;
                if (nuevoTiempo < tiempos[arista.destino]) {
                    tiempos[arista.destino] = nuevoTiempo;
                    cola.add(new Arista(arista.destino, nuevoTiempo));
                }
            }
        }

        System.out.println("Tiempos mínimos de entrega desde el centro de distribución " + inicio + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Centro " + i + ": " + tiempos[i] + " minutos");
        }
    }

    class Arista {
        int destino;
        int peso;

        Arista(int d, int p) {
            destino = d;
            peso = p;
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Crear un grafo con 5 centros de distribución
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 5);
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(2, 1, 3);
        grafo.agregarArista(2, 3, 9);
        grafo.agregarArista(2, 4, 2);
        grafo.agregarArista(3, 4, 4);
        grafo.agregarArista(4, 3, 6);

        grafo.dijkstra(0); // Iniciar desde el centro de distribución principal (0)
    }
}
