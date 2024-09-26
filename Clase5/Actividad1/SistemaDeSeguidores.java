package Clase5.Actividad1;

import java.util.*;

class Usuario {
    private String id;

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id; 
    }
}


class RedSocial {
    private Map<Usuario, List<Usuario>> grafo;

    public RedSocial() {
        this.grafo = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        grafo.putIfAbsent(usuario, new ArrayList<>());
    }

    public void seguir(Usuario seguidor, Usuario seguido) {
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
            List<Usuario> seguidos = grafo.get(seguidor);
            if (!seguidos.contains(seguido)) {
                seguidos.add(seguido);
            }
        }
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (grafo.containsKey(seguidor)) {
            List<Usuario> seguidos = grafo.get(seguidor);
            seguidos.remove(seguido);
        }
    }

    public List<Usuario> listaDeSeguidores(Usuario usuario) {
        return grafo.getOrDefault(usuario, new ArrayList<>());
    }

    public List<Usuario> listaDeSeguidoresDe(Usuario usuario) {
        List<Usuario> seguidores = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }

    public void mostrarListaAdyacencia() {
        for (Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            System.out.print(entry.getKey().getId() + " sigue a: ");
            for (Usuario seguido : entry.getValue()) {
                System.out.print(seguido.getId() + " ");
            }
            System.out.println();
        }
    }
}

public class SistemaDeSeguidores {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        Usuario user1 = new Usuario("Pepe");
        Usuario user2 = new Usuario("Carlos");
        Usuario user3 = new Usuario("Samuel");

        red.agregarUsuario(user1);
        red.agregarUsuario(user2);
        red.agregarUsuario(user3);

        red.seguir(user1, user2);
        red.seguir(user1, user3);

        red.seguir(user2, user3);

        System.out.println("Lista de adyacencia:");
        red.mostrarListaAdyacencia();

        System.out.println("Seguidores de Pepe: " + red.listaDeSeguidores(user1));

        System.out.println("Seguidores de Samuel: " + red.listaDeSeguidoresDe(user3));

        red.dejarDeSeguir(user1, user3);

        System.out.println("Lista de adyacencia después de dejar de seguir a Samuel:");
        red.mostrarListaAdyacencia();
    }
}
