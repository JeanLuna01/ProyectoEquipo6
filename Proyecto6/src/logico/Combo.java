package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private ArrayList<Producto> productos;
	private int descuento;
	public static int incrementador = 1;
	
	public Combo(String id, String nombre, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productos = new ArrayList<>();
		this.descuento = descuento;
		Combo.incrementador++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public void agregarComponente(Producto p) {
		productos.add(p);
	}
	
	public float precioCombo() {
		float total = 0;
		for (Producto p : productos) {
			total += p.getPrecio();
		}
		return total - (total * ((float)descuento/100) );
	}
	public Object clone() throws CloneNotSupportedException {
		Combo cloned = (Combo) super.clone();
		return cloned;
	}
}