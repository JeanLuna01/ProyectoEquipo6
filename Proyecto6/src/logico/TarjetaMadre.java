package logico;

public class TarjetaMadre extends Producto {
	
	private String tipoConectorParaSocket;
	private String tipoMemoriaRam;
	private String tipoConexionesParaDiscoDuro;
	
	public TarjetaMadre(String marca, String modelo, double precio, int cantidadDisp, String numeroSerie, String id,
			String tipoConectorParaSocket, String tipoMemoriaRam, String tipoConexionesParaDiscoDuro) {
		super(marca, modelo, precio, cantidadDisp, numeroSerie, id);
		this.tipoConectorParaSocket = tipoConectorParaSocket;
		this.tipoMemoriaRam = tipoMemoriaRam;
		this.tipoConexionesParaDiscoDuro = tipoConexionesParaDiscoDuro;
	}

	public String getTipoConectorParaSocket() {
		return tipoConectorParaSocket;
	}

	public void setTipoConectorParaSocket(String tipoConectorParaSocket) {
		this.tipoConectorParaSocket = tipoConectorParaSocket;
	}

	public String getTipoMemoriaRam() {
		return tipoMemoriaRam;
	}

	public void setTipoMemoriaRam(String tipoMemoriaRam) {
		this.tipoMemoriaRam = tipoMemoriaRam;
	}

	public String getTipoConexionesParaDiscoDuro() {
		return tipoConexionesParaDiscoDuro;
	}

	public void setTipoConexionesParaDiscoDuro(String tipoConexionesParaDiscoDuro) {
		this.tipoConexionesParaDiscoDuro = tipoConexionesParaDiscoDuro;
	}
}
	