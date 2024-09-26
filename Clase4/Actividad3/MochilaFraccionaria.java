package Clase4.Actividad3;

import java.util.*;

class Objeto {
    int valor;
    int peso;

    public Objeto(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }
}

public class MochilaFraccionaria {

    public static double resolverMochilaFraccionaria(Objeto[] objetos, int capacidad) {
        // Calcular la relación valor/peso
        double[][] ratio = new double[objetos.length][2];
        for (int i = 0; i < objetos.length; i++) {
            ratio[i][0] = objetos[i].valor / (double) objetos[i].peso; 
            ratio[i][1] = i; 
        }

        // Orden descendente
        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double valorTotal = 0.0; 
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[(int) ratio[i][1]].peso <= capacidad) {
                capacidad -= objetos[(int) ratio[i][1]].peso;
                valorTotal += objetos[(int) ratio[i][1]].valor;
            } else {
                // Si no se puede agregar el objeto completo, tomar la fracción
                valorTotal += objetos[(int) ratio[i][1]].valor * ((double) capacidad / objetos[(int) ratio[i][1]].peso);
                break; 
            }
        }

        return valorTotal; 
    }

    public static void main(String[] args) {
        Objeto[] objetos = {
            new Objeto(60, 10),
            new Objeto(100, 20),
            new Objeto(120, 30)
        };

        int capacidad = 50; 
        double valorMaximo = resolverMochilaFraccionaria(objetos, capacidad);
        System.out.println("El valor máximo que se puede obtener en la mochila es: " + valorMaximo);
    }
}
