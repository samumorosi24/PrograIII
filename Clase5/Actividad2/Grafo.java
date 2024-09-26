package Clase5.Actividad2;

public class Grafo {
        private int[][] matriz; 
        private int numVertices;
    
        // Inicializar el grafo con un número dado de vertices
        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            this.matriz = new int[numVertices][numVertices];
        }
    
        // Agregar una arista
        public void agregarArista(int origen, int destino, int peso) {
            matriz[origen][destino] = peso; 
        }
    
        // Eliminar una arista
        public void eliminarArista(int origen, int destino) {
            matriz[origen][destino] = 0; 
        }
    
        // Verificar si existe una arista
        public boolean verificarArista(int origen, int destino) {
            return matriz[origen][destino] != 0; 
        }
    
        // Listar los adyacentes de un vertice
        public void listarAdyacentes(int vertice) {
            System.out.print("Adyacentes de " + vertice + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (matriz[vertice][j] != 0) {
                    System.out.print(j + " (peso: " + matriz[vertice][j] + ") ");
                }
            }
            System.out.println();
        }
    
        // Contar el grado de salida de un vertice
        public int contarGradoSalida(int vertice) {
            int gradoSalida = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matriz[vertice][j] != 0) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        }
    
        // Entrada de un vértice
        public int contarGradoEntrada(int vertice) {
            int gradoEntrada = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][vertice] != 0) {
                    gradoEntrada++;
                }
            }
            return gradoEntrada;
        }
    
        public static void main(String[] args) {
            Grafo grafo = new Grafo(3); 

            grafo.agregarArista(0, 1, 5); 
            grafo.agregarArista(0, 2, 10); 
            grafo.agregarArista(1, 2, 2); 

            grafo.listarAdyacentes(0); 
            grafo.listarAdyacentes(1); 
            grafo.listarAdyacentes(2); 

            System.out.println("¿Existe arista A -> B? " + grafo.verificarArista(0, 1));
            System.out.println("¿Existe arista B -> A? " + grafo.verificarArista(1, 0));
    
            // Contar grados
            System.out.println("Grado de salida de A: " + grafo.contarGradoSalida(0));
            System.out.println("Grado de entrada de C: " + grafo.contarGradoEntrada(2));
    
            // Eliminar una arista
            grafo.eliminarArista(0, 1);
            System.out.println("Después de eliminar la arista A -> B:");
            grafo.listarAdyacentes(0); 
        }
    }
    