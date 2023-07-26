package logico;
import java.util.ArrayList;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private Factura factura;
	private ArrayList<Factura> Myfacturas;
	
	public Cliente(String nombre, String apellido, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		Myfacturas = new ArrayList<Factura>();
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

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public ArrayList<Factura> getFacturas() {
		return Myfacturas;
	}

	public void agregarFactura(Factura factura) {
		Myfacturas.add(factura);
	}
	
	public void eliminarFactura(Factura factura) {
		Myfacturas.remove(factura);
	}
	
	public void realizarCompra() {
		
	}
}
