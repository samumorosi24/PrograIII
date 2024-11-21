package Clase12.Actividad3;

import java.util.ArrayList;

public class Almacen {
    private Integer id;  
    private ArrayList<Integer> destinos; 

    public Almacen(Integer id) {
        this.id = id;
        this.destinos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<Integer> getDestinos() {
        return destinos;
    }

    public void agregarDestino(Integer destino) {
        destinos.add(destino);
    }
}
