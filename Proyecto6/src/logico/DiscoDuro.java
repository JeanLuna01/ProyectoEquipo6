package logico;

public class DiscoDuro extends Producto {
	
	private String capacidadAlmacenamiento;
	private String tipoConexion;
	
	public DiscoDuro(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String tipo,
			String capacidadAlmacenamiento, String tipoConexion) {
		super(marca, modelo, tipoConexion, precio, cantidadDisp, numeroSerie, tipo);
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}

	public String getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}

	public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}
