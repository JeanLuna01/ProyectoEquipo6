package logico;

public class MemoriaRAM extends Producto {
	
	private double cantidadMemoria;
	private String tipoMemoria;
	
	public MemoriaRAM(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String id,
			double cantidadMemoria, String tipoMemoria) {
		super(marca, modelo, precio, cantidadDisp, numeroSerie, id);
		this.cantidadMemoria = cantidadMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public double getCantidadMemoria() {
		return cantidadMemoria;
	}

	public void setCantidadMemoria(double cantidadMemoria) {
		this.cantidadMemoria = cantidadMemoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
}