package Clase3.Actividad1;

class Cliente {
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Scoring: " + scoring;
    }
}

public class MaxScoringCliente {

    public static Cliente encontrarMaximo(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return clientes[inicio];
        }

        // Dividir el array en dos partes
        int medio = (inicio + fin) / 2;
        
        // Llamada recursiva para las dos mitades
        Cliente maxIzquierda = encontrarMaximo(clientes, inicio, medio);
        Cliente maxDerecha = encontrarMaximo(clientes, medio + 1, fin);
        
        // Combinar 
        return (maxIzquierda.scoring > maxDerecha.scoring) ? maxIzquierda : maxDerecha;
    }

    public static void main(String[] args) {
        Cliente[] listaClientes = {
            new Cliente(1, "Juan", 85),
            new Cliente(2, "Maria", 90),
            new Cliente(3, "Pedro", 88),
            new Cliente(4, "Samuel", 95),
            new Cliente(5, "Luis", 91)
        };

        Cliente clienteMaxScoring = encontrarMaximo(listaClientes, 0, listaClientes.length - 1);
        System.out.println("Cliente con el mayor scoring: " + clienteMaxScoring);
    }
}
