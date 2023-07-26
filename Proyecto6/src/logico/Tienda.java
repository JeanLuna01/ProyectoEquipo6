package logico;

import java.util.ArrayList;

public class Tienda {
	
	private int c;
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
		c=0;
		while(c<TiendaProductos.size()) {
			if(TiendaProductos.get(c).getNumeroSerie().equalsIgnoreCase(numeroSerie)) {
				System.out.print("Marca: ");
				System.out.println(TiendaProductos.get(c).getMarca());
				System.out.print("Modelo: ");
				System.out.println(TiendaProductos.get(c).getModelo());
				System.out.print("Precio: ");
				System.out.println(TiendaProductos.get(c).getPrecio());
				System.out.print("Cantidad Disponible: ");
				System.out.println(TiendaProductos.get(c).getCantidadDisp());
				System.out.print("Tipo: ");
				System.out.println(TiendaProductos.get(c).getTipo());
			}
			else {
				c++;
			}
		}
	}
	
	public void MostrarProductoDisp() {
		c=0;
		while(c<TiendaProductos.size()) {
			if(TiendaProductos.get(c).getCantidadDisp()!=0) {
				System.out.println(TiendaProductos.get(c).getModelo());
				c++;
			}
			else {
				c++;
			}
		}
	}
}


