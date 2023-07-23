package logico;

import java.util.ArrayList;

public class Factura {
	
	private ArrayList<PaqueteCompleto>PaquetesCompletosFactura;
	private ArrayList<Producto>ProductosFactura;
	private double totalPagar;
	
	public Factura(ArrayList<PaqueteCompleto> paquetesCompletosFactura, ArrayList<Producto> productosFactura,
			double totalPagar) {
		super();
		PaquetesCompletosFactura = new ArrayList<PaqueteCompleto>();
		ProductosFactura = new ArrayList<Producto>();
		this.totalPagar = totalPagar;
	}

	public ArrayList<PaqueteCompleto> getPaquetesCompletosFactura() {
		return PaquetesCompletosFactura;
	}

	public void setPaquetesCompletosFactura(ArrayList<PaqueteCompleto> paquetesCompletosFactura) {
		PaquetesCompletosFactura = paquetesCompletosFactura;
	}

	public ArrayList<Producto> getProductosFactura() {
		return ProductosFactura;
	}

	public void setProductosFactura(ArrayList<Producto> productosFactura) {
		ProductosFactura = productosFactura;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

}
