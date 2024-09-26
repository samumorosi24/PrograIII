package Clase4.Actividad4;

import java.util.*;

public class FloresCompra {

    public static int getMinimumCost(int[] c, int k) {
        Arrays.sort(c);
        int totalCost = 0;
        int numPurchases = 0;

        for (int i = c.length - 1; i >= 0; i--) {
            totalCost += (numPurchases / k + 1) * c[i];
            numPurchases++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] c = new int[n];
        String[] prices = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(prices[i]);
        }

        int result = getMinimumCost(c, k);
        System.out.println(result);
        
        scanner.close();
    }
}
