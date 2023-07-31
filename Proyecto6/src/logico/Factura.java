package logico;

import java.util.ArrayList;

public class Factura {
private String codigo;
private String precioTotal;
private Cliente cliente;
private ArrayList<Producto> productos;
private ArrayList<Combo>misCombos;

public Factura(String codigo, String precioTotal, Cliente cliente, ArrayList<Producto> productos,
		ArrayList<Combo> misCombos) {
	super();
	this.codigo = codigo;
	this.precioTotal = precioTotal;
	this.cliente = cliente;
	this.productos = productos;
	this.misCombos = misCombos;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getPrecioTotal() {
	return precioTotal;
}

public void setPrecioTotal(String precioTotal) {
	this.precioTotal = precioTotal;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public ArrayList<Producto> getProductos() {
	return productos;
}

public void setProductos(ArrayList<Producto> productos) {
	this.productos = productos;
}

public ArrayList<Combo> getMisCombos() {
	return misCombos;
}

public void setMisCombos(ArrayList<Combo> misCombos) {
	this.misCombos = misCombos;
}

}
