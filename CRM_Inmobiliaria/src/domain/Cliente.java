package domain;

public class Cliente {
	private String rowId;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String RFC;
	private String genero;
	private String estadoCivil;
	private String fecNac;
	private String altaCliente;
	private String ultMod;
	private String codCliente;
	private String clienteMDM;
	private String alias;
	
	public Cliente(String rowId, String nombre, String apePaterno,
			String apeMaterno, String rFC, String genero, String estadoCivil,
			String fecNac, String altaCliente, String ultMod,
			String codCliente, String clienteMDM, String alias) {
		super();
		this.rowId = rowId;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		RFC = rFC;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.fecNac = fecNac;
		this.altaCliente = altaCliente;
		this.ultMod = ultMod;
		this.codCliente = codCliente;
		this.clienteMDM = clienteMDM;
		this.alias = alias;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	public String getRFC() {
		return RFC;
	}
	public void setRFC(String rFC) {
		RFC = rFC;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getFecNac() {
		return fecNac;
	}
	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}
	public String getAltaCliente() {
		return altaCliente;
	}
	public void setAltaCliente(String altaCliente) {
		this.altaCliente = altaCliente;
	}
	public String getClienteMDM() {
		return clienteMDM;
	}
	public void setClienteMDM(String clienteMDM) {
		this.clienteMDM = clienteMDM;
	}
	public String getUltMod() {
		return ultMod;
	}
	public void setUltMod(String ultMod) {
		this.ultMod = ultMod;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	@Override
	public String toString() {
		return  rowId + "^" + nombre
				+ "^" + apePaterno + "^" + apeMaterno
				+ "^" + RFC + "^" + genero + "^"
				+ estadoCivil + "^" + fecNac + "^"
				+ altaCliente + "^" + ultMod + "^"
				+ codCliente + "^" + clienteMDM + "^"
				+ alias;
	}
}