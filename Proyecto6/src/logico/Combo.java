package logico;

import java.util.ArrayList;

public class Combo {
	
	private String nombreCombo;
    private ArrayList<Producto> productosCombo;
    private double total;
    private Producto producto1;

    public Combo(String nombreCombo, Producto producto1, Producto producto2, Producto producto3, Producto producto4, Producto producto5, Producto producto6) {
    	productosCombo = new ArrayList<Producto>();
    	this.nombreCombo = nombreCombo;
    	this.producto1 = producto1;
    	productosCombo.add(producto1);
    	productosCombo.add(producto2);
    	productosCombo.add(producto3);
    	if(!(producto4 == null)) {
    	productosCombo.add(producto4);
    	}
    	if(!(producto5 == null)) {
    		productosCombo.add(producto5);
    	}
    	if(!(producto6 == null)) {
    	productosCombo.add(producto6);
    	}
        calcularTotal();
    }

    public Producto getProducto1() {
		return producto1;
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public String getNombreCombo() {
		return nombreCombo;
	}

	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}

	public ArrayList<Producto> getProductosPaquete() {
        return productosCombo;
    }

    public void setProductosPaquete(ArrayList<Producto> productosPaquete) {
        this.productosCombo = new ArrayList<Producto>(productosPaquete);
        calcularTotal();
    }

    public double getTotal() {
        return total;
    }

    public double getDescuentoCombo() {
        return total - (total * 0.10);
    }

    private void calcularTotal() {
        total = 0;
        for (Producto producto : productosCombo) {
            total += producto.getPrecio();
        }
    }
}
