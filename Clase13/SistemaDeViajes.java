package Clase13;

import java.util.*;

class Ciudad {
    String nombre;
    Map<Ciudad, Integer> conexiones;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.conexiones = new HashMap<>();
    }

    public void agregarConexion(Ciudad destino, int costo) {
        conexiones.put(destino, costo);
    }
}

class GrafoDeViaje {
    private List<Ciudad> ciudades;

    public GrafoDeViaje() {
        ciudades = new ArrayList<>();
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public List<Ciudad> obtenerCiudades() {
        return ciudades;
    }

    public Integer obtenerCosto(Ciudad desde, Ciudad hasta) {
        return desde.conexiones.get(hasta);
    }
}

class ColaDePrioridad {
    private PriorityQueue<EntradaCola> cola;

    public ColaDePrioridad() {
        cola = new PriorityQueue<>(Comparator.comparingInt(entrada -> entrada.costo));
    }

    public void insertar(Ciudad ciudad, int costo) {
        cola.add(new EntradaCola(ciudad, costo));
    }

    public EntradaCola extraerMin() {
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    static class EntradaCola {
        Ciudad ciudad;
        int costo;

        public EntradaCola(Ciudad ciudad, int costo) {
            this.ciudad = ciudad;
            this.costo = costo;
        }
    }
}

public class SistemaDeViajes {
    public static int encontrarCostoMinimo(GrafoDeViaje grafo, Ciudad ciudadInicial, Ciudad ciudadFinal) {
        ColaDePrioridad colaPrioridad = new ColaDePrioridad();
        colaPrioridad.insertar(ciudadInicial, 0);

        Map<Ciudad, Integer> costosMinimos = new HashMap<>();
        costosMinimos.put(ciudadInicial, 0);

        while (!colaPrioridad.estaVacia()) {
            ColaDePrioridad.EntradaCola entradaActual = colaPrioridad.extraerMin();
            Ciudad ciudadActual = entradaActual.ciudad;
            int costoActual = entradaActual.costo;

            if (ciudadActual.equals(ciudadFinal)) {
                return costoActual;
            }

            for (Ciudad vecino : ciudadActual.conexiones.keySet()) {
                int nuevoCosto = costoActual + grafo.obtenerCosto(ciudadActual, vecino);

                if (!costosMinimos.containsKey(vecino) || nuevoCosto < costosMinimos.get(vecino)) {
                    costosMinimos.put(vecino, nuevoCosto);
                    colaPrioridad.insertar(vecino, nuevoCosto);
                }
            }
        }

        return -1; // Si no se encuentra un camino
    }

    public static void main(String[] args) {
        // Crear las ciudades y el grafo
        GrafoDeViaje grafo = new GrafoDeViaje();
        Ciudad ciudadA = new Ciudad("A");
        Ciudad ciudadB = new Ciudad("B");
        Ciudad ciudadC = new Ciudad("C");
        Ciudad ciudadD = new Ciudad("D");

        grafo.agregarCiudad(ciudadA);
        grafo.agregarCiudad(ciudadB);
        grafo.agregarCiudad(ciudadC);
        grafo.agregarCiudad(ciudadD);

        ciudadA.agregarConexion(ciudadB, 1);
        ciudadA.agregarConexion(ciudadC, 4);
        ciudadB.agregarConexion(ciudadD, 2);
        ciudadC.agregarConexion(ciudadD, 1);

        // Buscar el costo mínimo de viaje desde la ciudad A hasta la ciudad D
        int costoMinimo = encontrarCostoMinimo(grafo, ciudadC, ciudadD);
        System.out.println("El costo mínimo de viaje de A a D es: " + costoMinimo);
    }
}
