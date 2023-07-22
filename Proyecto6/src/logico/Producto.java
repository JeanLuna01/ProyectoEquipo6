package logico;

public class Producto {
	
	protected String marca;
	protected String modelo;
	protected double precio;
	protected int cantidadDisp;
	protected String numeroSerie;
	private String tipo;
	
	public Producto(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String tipo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidadDisp = cantidadDisp;
		this.numeroSerie = numeroSerie;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
