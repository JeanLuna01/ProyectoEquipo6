package logico;

import java.util.ArrayList;

public class PaqueteCompleto {
    private ArrayList<Producto> ProductosPaquete;
    private double total;

    public PaqueteCompleto(ArrayList<Producto> productosPaquete) {
        super();
        ProductosPaquete = new ArrayList<Producto>(productosPaquete);
    }

    public ArrayList<Producto> getProductosPaquete() {
        return ProductosPaquete;
    }

    public void setProductosPaquete(ArrayList<Producto> productosPaquete) {
        ProductosPaquete = productosPaquete;
    }

    public double getTotal() {
        return total;
    }

    public double DescuentoPaqueteCompleto() {
		total = total - (total*10/100);
    	return total;
        
    }
}
