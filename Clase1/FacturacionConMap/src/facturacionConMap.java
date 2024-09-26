import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturacionConMap {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan"));
        clientes.add(new Cliente(2, "María"));
        clientes.add(new Cliente(3, "Pedro"));

        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 2, 200.0));
        facturas.add(new Factura(3, 1, 150.0));
        facturas.add(new Factura(4, 3, 250.0));

        Map<Integer, Double> clienteTotalMap = new HashMap<>();

        for (Factura factura : facturas) {
            clienteTotalMap.put(factura.idCliente, 
                clienteTotalMap.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        for (Cliente cliente : clientes) {
            double totalImporte = clienteTotalMap.getOrDefault(cliente.idCliente, 0.0);
            System.out.println(cliente.nombreCliente + ": " + totalImporte);
        }
    }
}

class Cliente {
    int idCliente;
    String nombreCliente;

    public Cliente(int idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }
}

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}
