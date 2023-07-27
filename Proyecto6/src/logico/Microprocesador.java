package logico;

public class Microprocesador extends Producto {
	
	private String velocidadProcesamientoEnMhzGhz;
	private String tipoConexionOSocket;
	
	public Microprocesador(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie,
			String tipo, String velocidadProcesamientoEnMhzGhz, String tipoConexionOSocket) {
		super(marca, modelo, tipoConexionOSocket, precio, cantidadDisp, numeroSerie, tipo);
		this.velocidadProcesamientoEnMhzGhz = velocidadProcesamientoEnMhzGhz;
		this.tipoConexionOSocket = tipoConexionOSocket;
	}

	public String getVelocidadProcesamientoEnMhzGhz() {
		return velocidadProcesamientoEnMhzGhz;
	}

	public void setVelocidadProcesamientoEnMhzGhz(String velocidadProcesamientoEnMhzGhz) {
		this.velocidadProcesamientoEnMhzGhz = velocidadProcesamientoEnMhzGhz;
	}

	public String getTipoConexionOSocket() {
		return tipoConexionOSocket;
	}

	public void setTipoConexionOSocket(String tipoConexionOSocket) {
		this.tipoConexionOSocket = tipoConexionOSocket;
	}


}
