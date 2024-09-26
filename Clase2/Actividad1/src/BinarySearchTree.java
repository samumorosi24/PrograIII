package Clase2.Actividad1.src;

public class BinarySearchTree {
    private class Nodo {
        int valor; 
        Nodo izquierdo, derecho; 

        // Constructor del nodo
        public Nodo(int valor) {
            this.valor = valor; 
            izquierdo = derecho = null; 
        }
    }

    private Nodo raiz; 

    // Constructor del árbol binario de búsqueda
    public BinarySearchTree() {
        raiz = null; 
    }

    // Método para insertar un nuevo valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor); 
    }

    // Método recursivo para insertar un valor en el árbol
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor); 
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo; 
    }

    // Calcular la altura del árbol
    public int getHeight() {
        return getHeightRecursivo(raiz); 
    }

    // Método recursivo para calcular la altura de un subárbol
    private int getHeightRecursivo(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        // Se calcula la altura de los subárboles izquierdo y derecho
        int alturaIzquierda = getHeightRecursivo(nodo.izquierdo);
        int alturaDerecha = getHeightRecursivo(nodo.derecho);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertar(10);
        bst.insertar(5);
        bst.insertar(15);
        bst.insertar(3);
        bst.insertar(7);
        bst.insertar(12);
        bst.insertar(18);

        System.out.println("La altura del árbol es: " + bst.getHeight());
    }
}
