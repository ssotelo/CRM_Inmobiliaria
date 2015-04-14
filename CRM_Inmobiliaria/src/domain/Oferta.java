package domain;

public class Oferta {
	private String rowId;
	private String tipo;
	private String nombre;
	private String descripcion;
	private String aprobacion;
	private String fecIniOfr;
	private String fecFinOfr;
	private String fecUltAct;
	private String codOfer; 
	private String fecToday;
	private String totOfertas;
	public Oferta(String rowId, String tipo, String nombre, String descripcion,
			String aprobacion, String fecIniOfr, String fecFinOfr,
			String fecUltAct, String codOfer) {
		super();
		this.rowId = rowId;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.aprobacion = aprobacion;
		this.fecIniOfr = fecIniOfr;
		this.fecFinOfr = fecFinOfr;
		this.fecUltAct = fecUltAct;
		this.codOfer = codOfer;
	}
	public Oferta(String fecToday, String fecUltAct, String totOfertas){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.totOfertas = totOfertas;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAprobacion() {
		return aprobacion;
	}
	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}
	public String getFecIniOfr() {
		return fecIniOfr;
	}
	public void setFecIniOfr(String fecIniOfr) {
		this.fecIniOfr = fecIniOfr;
	}
	public String getFecFinOfr() {
		return fecFinOfr;
	}
	public void setFecFinOfr(String fecFinOfr) {
		this.fecFinOfr = fecFinOfr;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	public String getCodOfer() {
		return codOfer;
	}
	public void setCodOfer(String codOfer) {
		this.codOfer = codOfer;
	}
	public String getFecToday() {
		return fecToday;
	}
	public void setFecToday(String fecToday) {
		this.fecToday = fecToday;
	}
	public String getTotOfertas() {
		return totOfertas;
	}
	public void setTotOfertas(String totOfertas) {
		this.totOfertas = totOfertas;
	}
	@Override
	public String toString() {
		return  rowId + "^" + tipo + "^"
				+ nombre + "^" + descripcion + "^"
				+ aprobacion + "^" + fecIniOfr + "^"
				+ fecFinOfr + "^" + fecUltAct + "^"
				+ codOfer;
	}
}