package logico;

import java.util.ArrayList; /*tttttttttttttttttt*/

public class Cliente {

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private ArrayList<Factura> Myfacturas;
    private ArrayList<Producto> Carrito;
    private ArrayList<Combo> CombosCarrito;

    public Cliente(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.Carrito = new ArrayList<Producto>();
        this.Myfacturas = new ArrayList<Factura>();
        this.CombosCarrito = new ArrayList<Combo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Factura> getFacturas() {
        return Myfacturas;
    }

    public ArrayList<Producto> getCarrito() {
        return Carrito;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.Carrito = carrito;
    }

    public void agregarFactura(Factura factura) {
        Myfacturas.add(factura);
    }

    public void eliminarFactura(Factura factura) {
        Myfacturas.remove(factura);
    }

    public void agregarProductoAlCarrito(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Carrito.add(producto);
}
    }
    
    public void agregarComboAlCarrito(Combo combo, int cantidad) {
    	for (int i = 0; i < cantidad; i++) {
    		CombosCarrito.add(combo);
    	}
    }

    public void realizarCompra() {
        Factura f1 = new Factura(new ArrayList<Combo>(), new ArrayList<Producto>());
        for(Combo combo : CombosCarrito) {
        	f1.agregarCombo(combo);
        }
        
        for (Producto producto : Carrito) {
            f1.agregarProducto(producto);
        }

        f1.imprimirFactura();

        agregarFactura(f1);
    }
}

