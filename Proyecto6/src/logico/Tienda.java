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
		TiendaClientes.add(cliente);
	}
	
	public void EliminarCliente(Cliente cliente) {
		TiendaClientes.remove(cliente);
	}
	
	public void BuscarProducto(String numeroSerie) {
		int c=0;
		}
	}


}
