package Clase2.Actividad1.src;

public class BinarySearchTree {
    // Clase interna que representa un nodo en el árbol
    private class Nodo {
        int valor; // Valor del nodo
        Nodo izquierdo, derecho; // Referencias a los nodos hijos

        // Constructor del nodo
        public Nodo(int valor) {
            this.valor = valor; // Asignamos el valor al nodo
            izquierdo = derecho = null; // Inicializamos los hijos como nulos
        }
    }

    private Nodo raiz; // Referencia a la raíz del árbol

    // Constructor del árbol binario de búsqueda
    public BinarySearchTree() {
        raiz = null; // Inicialmente, el árbol está vacío
    }

    // Método para insertar un nuevo valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor); // Llamamos al método recursivo para insertar
    }

    // Método recursivo para insertar un valor en el árbol
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor); // Creamos un nuevo nodo si llegamos a un lugar vacío
        }
        if (valor < nodo.valor) {
            // Si el valor es menor, lo insertamos en el subárbol izquierdo
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            // Si el valor es mayor, lo insertamos en el subárbol derecho
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo; // Devolvemos el nodo (sin cambios o actualizado)
    }

    // Método para calcular la altura del árbol
    public int getHeight() {
        return getHeightRecursivo(raiz); // Llamamos al método recursivo para calcular la altura
    }

    // Método recursivo para calcular la altura de un subárbol
    private int getHeightRecursivo(Nodo nodo) {
        if (nodo == null) {
            return -1; // La altura de un árbol vacío es -1
        }
        // Calculamos la altura de los subárboles izquierdo y derecho
        int alturaIzquierda = getHeightRecursivo(nodo.izquierdo);
        int alturaDerecha = getHeightRecursivo(nodo.derecho);
        // Devolvemos la altura máxima de los dos subárboles + 1 (por el nodo actual)
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(); // Creamos una nueva instancia del árbol
        // Insertamos algunos valores en el árbol
        bst.insertar(10);
        bst.insertar(5);
        bst.insertar(15);
        bst.insertar(3);
        bst.insertar(7);
        bst.insertar(12);
        bst.insertar(18);

        // Imprimimos la altura del árbol
        System.out.println("La altura del árbol es: " + bst.getHeight());
    }
}
