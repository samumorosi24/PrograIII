public class maxArray {
    public static int calcularMaximo(int[] arr) {
        int maximo = arr[0]; 
        for (int i = 1; i < arr.length; i++) { 
            if (arr[i] > maximo) { 
                maximo = arr[i]; 
            }
        }
        return maximo; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 5, 10, 1};
        int maximo = calcularMaximo(arr);
        System.out.println("El máximo es: " + maximo);
    }
}
