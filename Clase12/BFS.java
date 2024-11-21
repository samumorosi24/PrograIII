package Clase12;

import java.util.*;

class Grafo {
    Map<Integer, List<Integer>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }

    public void agregarArista(int nodo1, int nodo2) {
        grafo.computeIfAbsent(nodo1, _ -> new ArrayList<>()).add(nodo2);
        grafo.computeIfAbsent(nodo2, _ -> new ArrayList<>()).add(nodo1);
    }

    public List<Integer> obtenerVecinos(int nodo) {
        return grafo.getOrDefault(nodo, new ArrayList<>());
    }
}

class BFS {
    public void recorridoBFS(Grafo grafo, int nodoInicial) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        cola.offer(nodoInicial);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();

            if (!visitados.contains(nodo)) {
                System.out.print(nodo + " ");
                visitados.add(nodo);
            }

            for (int vecino : grafo.obtenerVecinos(nodo)) {
                if (!visitados.contains(vecino)) {
                    cola.offer(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);

        BFS bfs = new BFS();
        System.out.print("Recorrido BFS: ");
        bfs.recorridoBFS(grafo, 0);
    }
}
