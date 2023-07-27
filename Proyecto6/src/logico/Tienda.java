package logico;

import java.util.ArrayList;

public class Tienda {

    private ArrayList<Cliente> TiendaClientes;
    private ArrayList<Factura> TiendaFacturas;
    private ArrayList<Producto> TiendaProductos;
    private ArrayList<PaqueteCompleto> TiendaPaquetesCompletos;

    public Tienda() {
        TiendaClientes = new ArrayList<Cliente>();
        TiendaFacturas = new ArrayList<Factura>();
        TiendaProductos = new ArrayList<Producto>();
        TiendaPaquetesCompletos = new ArrayList<PaqueteCompleto>();
    }

    public ArrayList<Cliente> getTiendaClientes() {
        return TiendaClientes;
    }

    public void setTiendaClientes(ArrayList<Cliente> tiendaClientes) {
        TiendaClientes = tiendaClientes;
    }

    public ArrayList<Factura> getTiendaFacturas() {
        return TiendaFacturas;
    }

    public void setTiendaFacturas(ArrayList<Factura> tiendaFacturas) {
        TiendaFacturas = tiendaFacturas;
    }

    public ArrayList<Producto> getTiendaProductos() {
        return TiendaProductos;
    }

    public void setTiendaProductos(ArrayList<Producto> tiendaProductos) {
        TiendaProductos = tiendaProductos;
    }

    public ArrayList<PaqueteCompleto> getTiendaPaquetesCompletos() {
        return TiendaPaquetesCompletos;
    }

    public void setTiendaPaquetesCompletos(ArrayList<PaqueteCompleto> tiendaPaquetesCompletos) {
        TiendaPaquetesCompletos = tiendaPaquetesCompletos;
    }

    public void AgregarProducto(Producto producto) {
        TiendaProductos.add(producto);
    }

    public void EliminarProducto(Producto producto) {
        TiendaProductos.remove(producto);
    }

    public void AgregarCliente(Cliente cliente) {
        if (!TiendaClientes.contains(cliente)) {
            TiendaClientes.add(cliente);
        } else {
            System.out.println("El cliente ya existe en la tienda.");
        }
    }

    public void EliminarCliente(Cliente cliente) {
        if (TiendaClientes.contains(cliente)) {
            TiendaClientes.remove(cliente);
        } else {
            System.out.println("El cliente no existe en la tienda.");
        }
    }

    public void BuscarProducto(String numeroSerie) {
        for (Producto producto : TiendaProductos) {
            if (producto.getNumeroSerie().equalsIgnoreCase(numeroSerie)) {
                System.out.println("Marca: " + producto.getMarca());
                System.out.println("Modelo: " + producto.getModelo());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Cantidad Disponible: " + producto.getCantidadDisp());
                System.out.println("Tipo: " + producto.getTipo());
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void MostrarProductoDisp() {
        for (Producto producto : TiendaProductos) {
            if (producto.getCantidadDisp() != 0) {
                System.out.println(producto.getModelo());
            }
        }
    }
}

