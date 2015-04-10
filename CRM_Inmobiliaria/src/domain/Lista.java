package domain;

public class Lista {
	private String rowId;
	private String name;
	private String descripcion;
	private String tipoLista;
	private String statusLista;
	private String codigoDim;
	private String archivoImportado;
	private String usuario;
	private String fecUltAct;
	
	public Lista(String rowId, String name, String descripcion,
			String tipoLista, String statusLista, String codigoDim,
			String archivoImportado, String usuario, String fecUltAct) {
		super();
		this.rowId = rowId;
		this.name = name;
		this.descripcion = descripcion;
		this.tipoLista = tipoLista;
		this.statusLista = statusLista;
		this.codigoDim = codigoDim;
		this.archivoImportado = archivoImportado;
		this.usuario = usuario;
		this.fecUltAct = fecUltAct;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoLista() {
		return tipoLista;
	}
	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}
	public String getStatusLista() {
		return statusLista;
	}
	public void setStatusLista(String statusLista) {
		this.statusLista = statusLista;
	}
	public String getCodigoDim() {
		return codigoDim;
	}
	public void setCodigoDim(String codigoDim) {
		this.codigoDim = codigoDim;
	}
	public String getArchivoImportado() {
		return archivoImportado;
	}
	public void setArchivoImportado(String archivoImportado) {
		this.archivoImportado = archivoImportado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return  rowId + "^" + name + "^"
				+ descripcion + "^" + tipoLista + "^"
				+ statusLista + "^" + codigoDim
				+ "^" + archivoImportado + "^"
				+ usuario + "^" + fecUltAct;
	}
}
