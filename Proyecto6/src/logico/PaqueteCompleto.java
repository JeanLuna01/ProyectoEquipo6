package logico;

import java.util.ArrayList;

public class PaqueteCompleto {
	private ArrayList<Producto>ProductosPaquete;

	public PaqueteCompleto(ArrayList<Producto> productosPaquete) {
		super();
		ProductosPaquete = new ArrayList<Producto>();
	}

	public ArrayList<Producto> getProductosPaquete() {
		return ProductosPaquete;
	}

	public void setProductosPaquete(ArrayList<Producto> productosPaquete) {
		ProductosPaquete = productosPaquete;
	}

}
