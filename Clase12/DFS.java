package Clase12;

import java.util.*;

class Grafo {
    Map<Integer, List<Integer>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }

    // agregar aristas bidireccionales al grafo
    public void agregarArista(int nodo1, int nodo2) {
        grafo.computeIfAbsent(nodo1, _ -> new ArrayList<>()).add(nodo2);
        grafo.computeIfAbsent(nodo2, _ -> new ArrayList<>()).add(nodo1);
    }

    // obtener los vecinos de un nodo
    public List<Integer> obtenerVecinos(int nodo) {
        return grafo.getOrDefault(nodo, new ArrayList<>());
    }
}

class DFS {
    public void recorridoDFS(Grafo grafo, int nodoInicial) {
        Set<Integer> visitados = new HashSet<>();
        Stack<Integer> pila = new Stack<>();

        pila.push(nodoInicial);

        while (!pila.isEmpty()) {
            int nodo = pila.pop();

            if (!visitados.contains(nodo)) {
                System.out.print(nodo + " ");
                visitados.add(nodo);
            }

            // Agregar los vecinos del nodo actual a la pila
            for (int vecino : grafo.obtenerVecinos(nodo)) {
                if (!visitados.contains(vecino)) {
                    pila.push(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar las aristas al grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);

        DFS dfs = new DFS();
        System.out.print("Recorrido DFS: ");
        dfs.recorridoDFS(grafo, 0);
    }
}
