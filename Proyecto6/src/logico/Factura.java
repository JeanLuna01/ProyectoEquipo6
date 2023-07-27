package logico;

import java.util.ArrayList;

public class Factura {

    private ArrayList<PaqueteCompleto> paquetesCompletosFactura;
    private ArrayList<Producto> productosFactura;
    private double totalPagar;

    public Factura() {
        paquetesCompletosFactura = new ArrayList<>();
        productosFactura = new ArrayList<>();
        totalPagar = 0;
    }

    public ArrayList<PaqueteCompleto> getPaquetesCompletosFactura() {
        return paquetesCompletosFactura;
    }

    public ArrayList<Producto> getProductosFactura() {
        return productosFactura;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void agregarPaqueteCompleto(PaqueteCompleto paqueteCompleto) {
        paquetesCompletosFactura.add(paqueteCompleto);
        calcularTotalPagar();
    }

    public void agregarProducto(Producto producto) {
        productosFactura.add(producto);
        calcularTotalPagar();
    }

    private void calcularTotalPagar() {
        totalPagar = 0;
        for (PaqueteCompleto paquete : paquetesCompletosFactura) {
            totalPagar += paquete.getTotal();
        }
        for (Producto producto : productosFactura) {
            totalPagar += producto.getPrecio();
        }
    }

    public void imprimirFactura() {
        System.out.println("Paquetes Completos:");
        for (PaqueteCompleto paquete : paquetesCompletosFactura) {
            System.out.println(" - Paquete Completo:");
            for (Producto producto : paquete.getProductosPaquete()) {
                System.out.println("   - " + producto.getMarca() + " " + producto.getModelo() + " - Precio: " + producto.getPrecio());
            }
            System.out.println("   - Precio con descuento: " + paquete.getTotal());
        }
        System.out.println("Productos:");
        for (Producto producto : productosFactura) {
            System.out.println(" - " + producto.getMarca() + " " + producto.getModelo() + " - Precio: " + producto.getPrecio());
        }
        System.out.println("Total a pagar: " + totalPagar);
    }
}

