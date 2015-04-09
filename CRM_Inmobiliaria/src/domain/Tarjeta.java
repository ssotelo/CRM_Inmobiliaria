package domain;
//comentario
public class Tarjeta {
	private String codCliente;
	private String descripcion;
	private String tarjeta;
	private String fecUltAct;
	public Tarjeta(String codCliente, String descripcion, String tarjeta,
			String fecUltAct) {
		super();
		this.codCliente = codCliente;
		this.descripcion = descripcion;
		this.tarjeta = tarjeta;
		this.fecUltAct = fecUltAct;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return "Tarjeta [codCliente=" + codCliente + ", descripcion="
				+ descripcion + ", tarjeta=" + tarjeta + ", fecUltAct="
				+ fecUltAct + "]";
	}
}