package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable {

	private static final long serialVersionUID = -8956569334515007357L;
	private ArrayList<Producto>productos;
	private ArrayList<Cliente>misClientes;
	private ArrayList<Factura>misFacturas;
	private ArrayList<Combo>misCombos;
	public static int id = 1;
	public static Tienda tienda=null;

	private Tienda() {
		super();
		productos = new ArrayList<Producto>();
		misClientes = new ArrayList<>();
		misFacturas = new ArrayList<>();	
		misCombos = new ArrayList<Combo>();

	}

	public static Tienda getInstance() {
		if (tienda == null) {
			tienda = new Tienda();
		}
		return tienda;
	}

	public ArrayList<Producto> getMisComponentes() {
		return productos;
	}

	public void setMisComponentes(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}	

	public void RegistrarComponente(Producto produc){
    productos.add(produc);
		id++;
	}

	public Cliente ClienteByCedula(String cedula) {

		for (Cliente cliente : misClientes) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				return cliente;
			}
		}

		return null;
	}

	public void eliminarCliente(Cliente selected) {
		misClientes.remove(selected);
	}

	public Factura getFacturaByCodigo(String codigoFactura) {
		for (Factura factura : misFacturas) {
			if (factura.getCodigo().equalsIgnoreCase(codigoFactura)) {
				return factura;
			}
		}
		return null;
	}

	public void eliminarFactura(Factura selected) {
		misFacturas.remove(selected);
	}
	
	

	public Producto ComponenteByCodigo(String idProducto) {

		Producto prueba = null;
		for (Producto producto : productos) {
			if (producto.getId().equalsIgnoreCase(idProducto)) {
				prueba = producto;
			}
		}
		return prueba;
	}

	public void eliminarProducto(Producto selected) {
		productos.remove(selected);
	}


	public Producto copiarComp (Producto selec) throws CloneNotSupportedException {
		Producto aux = (Producto) selec.clone();
		return aux;
	}

	public ArrayList<Producto> copiarArray () throws CloneNotSupportedException{

		ArrayList<Producto> copia = new ArrayList<Producto>(productos.size());
		for (Producto comp : productos) {
			copia.add((Producto) comp.clone());
		}
		return copia;
	}

	public void registrarCliente(Cliente aux) {
		misClientes.add(aux);
	}

	
	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public void agregarFactura(Factura nuevaFactura) {
		misFacturas.add(nuevaFactura);
	}


	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}
	
}