import java.util.ArrayList;
import java.util.List;

public class facturacionSinMap {

    public static void main(String[] args) {
        List<Cliente> clientes = List.of(
                new Cliente(1, "Juan"),
                new Cliente(2, "María"),
                new Cliente(3, "Pedro")
        );
        List<Factura> facturas = List.of(
                new Factura(1, 1, 100.0),
                new Factura(2, 2, 200.0),
                new Factura(3, 1, 150.0),
                new Factura(4, 3, 250.0)
        );

        List<ClienteTotal> clienteTotals = new ArrayList<>();

        for (Factura factura : facturas) {
            ClienteTotal clienteTotal = buscarClienteTotal(clienteTotals, factura.idCliente);
            if (clienteTotal == null) {
                Cliente cliente = buscarCliente(clientes, factura.idCliente);
                if (cliente != null) {
                    clienteTotal = new ClienteTotal(cliente.idCliente, cliente.nombreCliente, factura.importe);
                    clienteTotals.add(clienteTotal);
                }
            } else {
                clienteTotal.totalImporte += factura.importe;
            }
        }

        for (ClienteTotal clienteTotal : clienteTotals) {
            System.out.println(clienteTotal.nombreCliente + ": " + clienteTotal.totalImporte);
        }
    }

    private static Cliente buscarCliente(List<Cliente> clientes, int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.idCliente == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    private static ClienteTotal buscarClienteTotal(List<ClienteTotal> clienteTotals, int idCliente) {
        for (ClienteTotal clienteTotal : clienteTotals) {
            if (clienteTotal.idCliente == idCliente) {
                return clienteTotal;
            }
        }
        return null;
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

class ClienteTotal {
    int idCliente;
    String nombreCliente;
    double totalImporte;

    public ClienteTotal(int idCliente, String nombreCliente, double totalImporte) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.totalImporte = totalImporte;
    }
}
