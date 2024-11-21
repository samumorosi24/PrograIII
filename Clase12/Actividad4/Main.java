package Clase12.Actividad4;

public class Main {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        Usuario usuario1 = new Usuario(0, "Juan");
        Usuario usuario2 = new Usuario(1, "Ana");
        Usuario usuario3 = new Usuario(2, "Carlos");
        Usuario usuario4 = new Usuario(3, "Maria");

        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);

        redSocial.agregarAmistad(0, 1);  
        redSocial.agregarAmistad(0, 2);  
        redSocial.agregarAmistad(1, 3);  
        redSocial.agregarAmistad(2, 3); 

        redSocial.DFS(0);  
        redSocial.BFS(0);  
    }
}
