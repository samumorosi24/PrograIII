package Clase12.Actividad4;

import java.util.ArrayList;
import java.util.LinkedList;

public class RedSocial {
    private ArrayList<Usuario> usuarios;  

    public RedSocial() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarAmistad(int idUsuario1, int idUsuario2) {
        usuarios.get(idUsuario1).agregarAmigo(idUsuario2);
        usuarios.get(idUsuario2).agregarAmigo(idUsuario1);
    }

    public void DFS(int inicio) {
        boolean[] visitado = new boolean[usuarios.size()];
        System.out.print("Recorrido DFS desde el usuario " + usuarios.get(inicio).getNombre() + ": ");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(usuarios.get(v).getNombre() + " "); 

        for (int amigo : usuarios.get(v).getAmigos()) {
            if (!visitado[amigo]) {
                DFSUtil(amigo, visitado);
            }
        }
    }

    public void BFS(int inicio) {
        boolean[] visitado = new boolean[usuarios.size()];
        LinkedList<Integer> cola = new LinkedList<>();
        System.out.print("Recorrido BFS desde el usuario " + usuarios.get(inicio).getNombre() + ": ");
        
        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(usuarios.get(v).getNombre() + " ");  

            for (int amigo : usuarios.get(v).getAmigos()) {
                if (!visitado[amigo]) {
                    visitado[amigo] = true;
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
