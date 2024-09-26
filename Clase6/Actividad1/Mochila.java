package Clase6.Actividad1;

public class Mochila {
    public static void main(String[] args) {
        int P = 6; // Capacidad de la mochila
        int[][] objetos = {{3, 4}, {4, 5}, {2, 3}}; // {peso, valor}

        int n = objetos.length;
        int[][] dp = new int[n + 1][P + 1];

        for (int i = 1; i <= n; i++) {
            int peso = objetos[i - 1][0];
            int valor = objetos[i - 1][1];

            for (int j = 0; j <= P; j++) {
                if (peso > j) {
                    dp[i][j] = dp[i - 1][j]; 
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - peso] + valor); // Se evalua incluir o no
                }
            }
        }

        // El valor mmaximo va a estar en dp[n][P]
        System.out.println("El valor máximo que se puede obtener es: " + dp[n][P]);
    }
}
