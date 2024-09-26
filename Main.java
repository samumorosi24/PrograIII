public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 5, 10, 1};
        int maximo = MaxArray.calcularMaximo(arr); 
        System.out.println("El máximo es: " + maximo);
        
        FacturacionConMap.main(args);

        FacturacionSinMap.main(args);
    }
}
