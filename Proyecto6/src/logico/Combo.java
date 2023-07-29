package logico;

import java.util.ArrayList;

public class Combo {
	
	private String nombreCombo;
    private ArrayList<Producto> productosCombo;
    private double total;

    public Combo(String nombreCombo, Producto producto1, Producto producto2, Producto producto3, Producto producto4, Producto producto5, Producto producto6) {
    	productosCombo = new ArrayList<Producto>();
    	this.nombreCombo = nombreCombo;
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

	public String getNombreCombo() {
		return nombreCombo;
	}

	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}

	public ArrayList<Producto> getProductosCombo() {
        return productosCombo;
    }

    public void setProductosCombo(ArrayList<Producto> productosPaquete) {
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
