package Clase5.Actividad3;

import java.util.*;

class Arista {
    int destino;
    int peso;

    Arista(int d, int p) {
        destino = d;
        peso = p;
    }
}

class Grafo {
    private List<List<Arista>> adyacencia;
    private int vertices;

    Grafo(int v) {
        vertices = v;
        adyacencia = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    void agregarArista(int origen, int destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso)); 
    }

    void prim(int inicio) {
        boolean[] enMST = new boolean[vertices];
        int[] costo = new int[vertices];
        Arrays.fill(costo, Integer.MAX_VALUE);
        costo[inicio] = 0;

        PriorityQueue<Arista> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        cola.add(new Arista(inicio, 0));

        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        while (!cola.isEmpty()) {
            Arista actual = cola.poll();
            int vertice = actual.destino;

            if (enMST[vertice]) continue;
            enMST[vertice] = true;
            costoTotal += actual.peso; // Suma el peso de la arista

            if (actual.peso > 0) {
                resultado.add(actual);
            }

            for (Arista arista : adyacencia.get(vertice)) {
                if (!enMST[arista.destino]) {
                    cola.add(arista);
                }
            }
        }

        System.out.println("Conexiones resultantes:");
        for (Arista arista : resultado) {
            System.out.println("Estación " + arista.destino + " con costo: " + arista.peso);
        }
        System.out.println("Costo total: " + costoTotal);
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Crear un grafo con 5 estaciones
        grafo.agregarArista(0, 1, 2);
        grafo.agregarArista(0, 3, 6);
        grafo.agregarArista(1, 2, 3);
        grafo.agregarArista(1, 3, 8);
        grafo.agregarArista(1, 4, 5);
        grafo.agregarArista(2, 4, 7);
        grafo.agregarArista(3, 4, 9);

        grafo.prim(0); 
    }
}
