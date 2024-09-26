package Clase5.Actividad2;

public class Grafo {
        private int[][] matriz; // Matriz de adyacencia
        private int numVertices; // Número de vértices
    
        // Constructor para inicializar el grafo con un número dado de vértices
        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            this.matriz = new int[numVertices][numVertices];
        }
    
        // Método para agregar una arista
        public void agregarArista(int origen, int destino, int peso) {
            matriz[origen][destino] = peso; // Asignar el peso en la matriz
        }
    
        // Método para eliminar una arista
        public void eliminarArista(int origen, int destino) {
            matriz[origen][destino] = 0; // Eliminar la arista
        }
    
        // Método para verificar si existe una arista
        public boolean verificarArista(int origen, int destino) {
            return matriz[origen][destino] != 0; // Retorna verdadero si existe una arista
        }
    
        // Método para listar los adyacentes de un vértice
        public void listarAdyacentes(int vertice) {
            System.out.print("Adyacentes de " + vertice + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (matriz[vertice][j] != 0) {
                    System.out.print(j + " (peso: " + matriz[vertice][j] + ") ");
                }
            }
            System.out.println();
        }
    
        // Método para contar el grado de salida de un vértice
        public int contarGradoSalida(int vertice) {
            int gradoSalida = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matriz[vertice][j] != 0) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        }
    
        // Método para contar el grado de entrada de un vértice
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
            Grafo grafo = new Grafo(3); // Crear un grafo con 3 vértices (A, B, C)
    
            // Agregar aristas con pesos
            grafo.agregarArista(0, 1, 5); // A -> B con peso 5
            grafo.agregarArista(0, 2, 10); // A -> C con peso 10
            grafo.agregarArista(1, 2, 2); // B -> C con peso 2
    
            // Listar adyacentes de cada vértice
            grafo.listarAdyacentes(0); // A
            grafo.listarAdyacentes(1); // B
            grafo.listarAdyacentes(2); // C
    
            // Verificar aristas
            System.out.println("¿Existe arista A -> B? " + grafo.verificarArista(0, 1));
            System.out.println("¿Existe arista B -> A? " + grafo.verificarArista(1, 0));
    
            // Contar grados
            System.out.println("Grado de salida de A: " + grafo.contarGradoSalida(0));
            System.out.println("Grado de entrada de C: " + grafo.contarGradoEntrada(2));
    
            // Eliminar una arista
            grafo.eliminarArista(0, 1);
            System.out.println("Después de eliminar la arista A -> B:");
            grafo.listarAdyacentes(0); // A
        }
    }
    