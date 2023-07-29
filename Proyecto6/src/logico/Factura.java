package logico;

import java.util.ArrayList;

public class Factura {
    private ArrayList<Combo> combosFactura;
    private ArrayList<Producto> productosFactura;
    private double totalPagar;

    public Factura(ArrayList<Combo> combosFactura, ArrayList<Producto> productosFactura) {
        this.combosFactura = combosFactura;
        this.productosFactura = productosFactura;
        calcularTotalPagar();
    }

    public ArrayList<Combo> getCombosFactura() {
        return combosFactura;
    }

    public ArrayList<Producto> getProductosFactura() {
        return productosFactura;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void agregarCombo(Combo combo) {
        combosFactura.add(combo);
        calcularTotalPagar();
    }

    public void agregarProducto(Producto producto) {
        productosFactura.add(producto);
        calcularTotalPagar();
    }

    public void calcularTotalPagar() {
        totalPagar = 0;
        for (Combo combo : combosFactura) {
            totalPagar += combo.getDescuentoCombo();
        }
        for (Producto producto : productosFactura) {
            totalPagar += producto.getPrecio();
        }
    }

    public void imprimirFactura() {
        System.out.println("FACTURA DEL CLIENTE");
        System.out.println();
        for (Combo combo : combosFactura) {
            System.out.println(" - Combo:");
            for (Producto producto : combo.getProductosCombo()) {
                System.out.println("   - " + producto.getMarca() + " " + producto.getModelo() + " - Precio: " + producto.getPrecio());
            }
            System.out.println();
            System.out.println("   - Precio con descuento:             " + combo.getDescuentoCombo());
            System.out.println();
        }
        
        for (Producto producto : productosFactura) {
        	System.out.println(" - Producto:");
        	System.out.println("  - " + producto.getMarca() + " " + producto.getModelo() + " - Precio: " + producto.getPrecio());
        }
        System.out.println();
        System.out.println("Total a pagar con descuento:                          " + totalPagar);
    }
}


