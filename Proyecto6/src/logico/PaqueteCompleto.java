package logico;
import java.util.ArrayList;

public class PaqueteCompleto {
    private ArrayList<Producto> productosPaquete;
    private double total;

    public PaqueteCompleto(ArrayList<Producto> productosPaquete) {
        this.productosPaquete = new ArrayList<Producto>(productosPaquete);
       
        total = 0;
        for (Producto producto : productosPaquete) {
            total += producto.getPrecio();
        }
    }

    public ArrayList<Producto> getProductosPaquete() {
        return productosPaquete;
    }

    public void setProductosPaquete(ArrayList<Producto> productosPaquete) {
        this.productosPaquete = new ArrayList<Producto>(productosPaquete);
    }

    public double getTotal() {
        return total;
    }

    public double DescuentoPaqueteCompleto() {
       
        return total - (total * 0.10);
    }
}
