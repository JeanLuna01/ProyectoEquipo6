package logico;

import java.util.ArrayList; /*tttttttttttttttttt*/

public class Cliente {

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private ArrayList<Factura> Myfacturas;
    private ArrayList<Producto> ProductosCarrito;
    private ArrayList<Combo> CombosCarrito;

    public Cliente(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ProductosCarrito = new ArrayList<Producto>();
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
        return ProductosCarrito;
    }

    public void setProductosCarrito(ArrayList<Producto> carrito) {
        this.ProductosCarrito = carrito;
    }

    public void agregarFactura(Factura factura) {
        Myfacturas.add(factura);
    }

    public void agregarProductoAlCarrito(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            ProductosCarrito.add(producto);
        }
    }
    
    public void eliminarProductoDelCarrito(Producto producto, int cantidad) {
    	if(!(ProductosCarrito.contains(producto))) {
    		System.out.println("Este producto no existe en el carrito.");
    		return;
    	}
    	for (int i = 0 ; i < cantidad ; i++) {
    	ProductosCarrito.remove(producto);
    	}
    }
    
    public void agregarComboAlCarrito(Combo combo, int cantidad) {
    	for (int i = 0; i < cantidad; i++) {
    		CombosCarrito.add(combo);
    	}
    }
    
    public void eliminarComboDelCarrito(Combo combo, int cantidad) {
    	if(!(CombosCarrito.contains(combo))) {
    		System.out.println("Este combo no existe en el carrito.");
    		return;
    	}
    	for (int i = 0 ; i < cantidad ; i++) {
    		CombosCarrito.remove(combo);
    	}
    }

    public void realizarCompra() {
        Factura f1 = new Factura(new ArrayList<Combo>(), new ArrayList<Producto>());
        for(Combo combo : CombosCarrito) {
        	f1.agregarCombo(combo);
        	for(Producto producto : combo.getProductosCombo()) {
        		producto.setCantidadDisp(producto.getCantidadDisp()-1);
        	}
        }
        
        for (Producto producto : ProductosCarrito) {
            f1.agregarProducto(producto);
            producto.setCantidadDisp(producto.getCantidadDisp()-1);
        }
        
        System.out.println("Cliente: " + nombre + " " + apellido);
        f1.imprimirFactura();
        
        agregarFactura(f1);
        CombosCarrito.removeAll(CombosCarrito);
        ProductosCarrito.removeAll(ProductosCarrito);
    }

    
    public void verCarritoCompleto() {
    	System.out.println("CARRITO");
    	System.out.println();
		System.out.println(" - Combos agregados:");
		System.out.println();
		int i=-1;
		for(Combo combo : CombosCarrito) {
			i++;
		}
		while(i>=0) {
			System.out.println(CombosCarrito.get(i).getNombreCombo());
			i--;
		}
		i=-1;
		System.out.println();
    	System.out.println(" - Productos agregados:");
    	System.out.println();
    	for(Producto producto : ProductosCarrito) {
    		i++;
    	}
    	while(i>=0) {
    		System.out.println(ProductosCarrito.get(i).getModelo());
    		i--;
    	}
    	System.out.println();
    }
   
public void VerFacturas() {
	System.out.println("                             FACTURAS DEL CLIENTE " + nombre + " " + apellido);
	System.out.println();
	for (Factura factura : Myfacturas) {
		factura.imprimirFactura();
	}
	
	}
}
    	 


