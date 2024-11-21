package Clase12.Actividad3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
    private ArrayList<Almacen> almacenes; 

    public Grafo() {
        almacenes = new ArrayList<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        almacenes.add(almacen);
    }

    public void conectarAlmacenes(Integer idOrigen, Integer idDestino) {
        Almacen origen = almacenes.get(idOrigen);
        origen.agregarDestino(idDestino);
    }

    public void DFS(int inicio) {
        boolean[] visitado = new boolean[almacenes.size()];
        System.out.print("Recorrido DFS desde el almacén " + inicio + ": ");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(v + " ");  

        for (int destino : almacenes.get(v).getDestinos()) {
            if (!visitado[destino]) {
                DFSUtil(destino, visitado);
            }
        }
    }

    public void BFS(int inicio) {
        boolean[] visitado = new boolean[almacenes.size()];
        LinkedList<Integer> cola = new LinkedList<>();
        System.out.print("Recorrido BFS desde el almacén " + inicio + ": ");
        
        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(v + " ");  

            for (int destino : almacenes.get(v).getDestinos()) {
                if (!visitado[destino]) {
                    visitado[destino] = true;
                    cola.add(destino);
                }
            }
        }
        System.out.println();
    }
}
