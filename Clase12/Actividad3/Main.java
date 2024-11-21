package Clase12.Actividad3;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Almacen centroDistribucion = new Almacen(0);
        Almacen almacenA = new Almacen(1);
        Almacen almacenB = new Almacen(2);
        Almacen almacenC = new Almacen(3);

        grafo.agregarAlmacen(centroDistribucion);
        grafo.agregarAlmacen(almacenA);
        grafo.agregarAlmacen(almacenB);
        grafo.agregarAlmacen(almacenC);

        grafo.conectarAlmacenes(0, 1);  
        grafo.conectarAlmacenes(0, 2); 
        grafo.conectarAlmacenes(1, 3);  
        grafo.conectarAlmacenes(2, 3);  

        grafo.DFS(0);  
        grafo.BFS(0);  
    }
}
