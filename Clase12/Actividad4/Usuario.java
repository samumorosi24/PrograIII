package Clase12.Actividad4;

import java.util.ArrayList;

public class Usuario {
    private int id;  
    private String nombre;  
    private ArrayList<Integer> amigos; 

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.amigos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getAmigos() {
        return amigos;
    }

    public void agregarAmigo(int idAmigo) {
        amigos.add(idAmigo);
    }
}
