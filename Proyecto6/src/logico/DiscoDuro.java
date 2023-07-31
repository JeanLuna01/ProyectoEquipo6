package logico;

public class DiscoDuro extends Producto {
	
	private int capacidadAlmacenamiento;
	private String tipoConexion;
	
	public DiscoDuro(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String tipo,
			int capacidadAlmacenamiento, String tipoConexion) {
		super(marca, modelo, precio, cantidadDisp, numeroSerie, tipo);
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}

	public int getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}

	public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}