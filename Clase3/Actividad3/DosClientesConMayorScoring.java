package Clase3.Actividad3;

import java.util.Arrays;

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
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class DosClientesConMayorScoring {

    // encontrar los dos clientes con el scoring más alto
    public static Cliente[] encontrarDosClientesMayores(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return new Cliente[] {clientes[inicio], null}; 
        }

        int mitad = (inicio + fin) / 2;

        Cliente[] mayoresIzquierda = encontrarDosClientesMayores(clientes, inicio, mitad);
        Cliente[] mayoresDerecha = encontrarDosClientesMayores(clientes, mitad + 1, fin);

        Cliente[] resultado = new Cliente[2];

        // Comparar los máximos scoring de ambas mitades
        if (mayoresIzquierda[0].scoring > mayoresDerecha[0].scoring) {
            resultado[0] = mayoresIzquierda[0];
            resultado[1] = (mayoresIzquierda[1] != null && mayoresIzquierda[1].scoring > mayoresDerecha[0].scoring) ? mayoresIzquierda[1] : mayoresDerecha[0];
        } else {
            resultado[0] = mayoresDerecha[0];
            resultado[1] = (mayoresDerecha[1] != null && mayoresDerecha[1].scoring > mayoresIzquierda[0].scoring) ? mayoresDerecha[1] : mayoresIzquierda[0];
        }

        return resultado;
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Pablo", 90),
            new Cliente(2, "María", 95),
            new Cliente(3, "Migue", 85),
            new Cliente(4, "Samuel", 98),
            new Cliente(5, "Luis", 92)
        };

        Cliente[] dosClientesMayores = encontrarDosClientesMayores(clientes, 0, clientes.length - 1);

        System.out.println("Los dos clientes con mayor scoring son: " + Arrays.toString(dosClientesMayores));
    }
}
