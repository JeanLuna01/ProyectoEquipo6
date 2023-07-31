package logico;

public class Microprocesador extends Producto {
	
	private int velocidadProcesamientoEnMhzGhz;
	private String tipoConexionOSocket;
	
	public Microprocesador(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String id,
			int velocidadProcesamientoEnMhzGhz, String tipoConexionOSocket) {
		super(marca, modelo, precio, cantidadDisp, numeroSerie, id);
		this.velocidadProcesamientoEnMhzGhz = velocidadProcesamientoEnMhzGhz;
		this.tipoConexionOSocket = tipoConexionOSocket;
	}

	public int getVelocidadProcesamientoEnMhzGhz() {
		return velocidadProcesamientoEnMhzGhz;
	}

	public void setVelocidadProcesamientoEnMhzGhz(int velocidadProcesamientoEnMhzGhz) {
		this.velocidadProcesamientoEnMhzGhz = velocidadProcesamientoEnMhzGhz;
	}

	public String getTipoConexionOSocket() {
		return tipoConexionOSocket;
	}

	public void setTipoConexionOSocket(String tipoConexionOSocket) {
		this.tipoConexionOSocket = tipoConexionOSocket;
	}
	
}
