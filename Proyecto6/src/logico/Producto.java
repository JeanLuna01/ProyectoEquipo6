package logico;

public class Producto implements Cloneable{
	
    protected String marca;
    protected String modelo;
    protected double precio;
    protected int cantidadDisp;
    protected String numeroSerie;
    protected String id;
    
	public Producto(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String id) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidadDisp = cantidadDisp;
		this.numeroSerie = numeroSerie;
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadDisp() {
		return cantidadDisp;
	}

	public void setCantidadDisp(int cantidadDisp) {
		this.cantidadDisp = cantidadDisp;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Producto cloned = (Producto) super.clone();
		return cloned;
	}
}
    