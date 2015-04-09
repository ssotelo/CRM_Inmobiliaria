package domain;


public class Programa {
	private String rowId;
	private String nombre;
	private String descripcion;
//	private String tipoCRM;
	private String inicioPrograma;
	private String finPrograma;
	private String inicioTransferencia;
	private String inicioCompra;
	private String crecimientoPuntos;
	private String vencimientoPuntos;
	private String reglaCalculo;
	private String reconocimientoBono;
	private String activeFlag;
	private String conversionPuntos;
	private String socioFlag;
	private String nombreSocio;
	private String codOrganizacion;
	private String ultActualizacion;
	
	public Programa(String rowId, String nombre, String descripcion,
			/*String tipoCRM*/
		    String inicioPrograma, String finPrograma,
			String inicioTransferencia, String inicioCompra,
			String crecimientoPuntos, String vencimientoPuntos,
			String reglaCalculo, String reconocimientoBono, String activeFlag,
			String conversionPuntos, String socioFlag, String nombreSocio,
			String codOrganizacion, String ultActualizacion) {
		super();
		this.rowId = rowId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		//this.tipoCRM = tipoCRM;
		this.inicioPrograma = inicioPrograma;
		this.finPrograma = finPrograma;
		this.inicioTransferencia = inicioTransferencia;
		this.inicioCompra = inicioCompra;
		this.crecimientoPuntos = crecimientoPuntos;
		this.vencimientoPuntos = vencimientoPuntos;
		this.reglaCalculo = reglaCalculo;
		this.reconocimientoBono = reconocimientoBono;
		this.activeFlag = activeFlag;
		this.conversionPuntos = conversionPuntos;
		this.socioFlag = socioFlag;
		this.nombreSocio = nombreSocio;
		this.codOrganizacion = codOrganizacion;
		this.ultActualizacion = ultActualizacion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
	}*/
	public String getInicioPrograma() {
		return inicioPrograma;
	}
	public void setInicioPrograma(String inicioPrograma) {
		this.inicioPrograma = inicioPrograma;
	}
	public String getFinPrograma() {
		return finPrograma;
	}
	public void setFinPrograma(String finPrograma) {
		this.finPrograma = finPrograma;
	}
	public String getInicioTransferencia() {
		return inicioTransferencia;
	}
	public void setInicioTransferencia(String inicioTransferencia) {
		this.inicioTransferencia = inicioTransferencia;
	}
	public String getInicioCompra() {
		return inicioCompra;
	}
	public void setInicioCompra(String inicioCompra) {
		this.inicioCompra = inicioCompra;
	}
	public String getCrecimientoPuntos() {
		return crecimientoPuntos;
	}
	public void setCrecimientoPuntos(String crecimientoPuntos) {
		this.crecimientoPuntos = crecimientoPuntos;
	}
	public String getVencimientoPuntos() {
		return vencimientoPuntos;
	}
	public void setVencimientoPuntos(String vencimientoPuntos) {
		this.vencimientoPuntos = vencimientoPuntos;
	}
	public String getReglaCalculo() {
		return reglaCalculo;
	}
	public void setReglaCalculo(String reglaCalculo) {
		this.reglaCalculo = reglaCalculo;
	}
	public String getReconocimientoBono() {
		return reconocimientoBono;
	}
	public void setReconocimientoBono(String reconocimientoBono) {
		this.reconocimientoBono = reconocimientoBono;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getConversionPuntos() {
		return conversionPuntos;
	}
	public void setConversionPuntos(String conversionPuntos) {
		this.conversionPuntos = conversionPuntos;
	}
	public String getSocioFlag() {
		return socioFlag;
	}
	public void setSocioFlag(String socioFlag) {
		this.socioFlag = socioFlag;
	}
	public String getNombreSocio() {
		return nombreSocio;
	}
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	public String getCodOrganizacion() {
		return codOrganizacion;
	}
	public void setCodOrganizacion(String codOrganizacion) {
		this.codOrganizacion = codOrganizacion;
	}
	public String getUltActualizacion() {
		return ultActualizacion;
	}
	public void setUltActualizacion(String ultActualizacion) {
		this.ultActualizacion = ultActualizacion;
	}
	@Override
	public String toString() {
		return "Programa [rowId=" + rowId + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", tipoCRM=" 
				//tipoCRM
				+ ", inicioPrograma=" + inicioPrograma + ", finPrograma="
				+ finPrograma + ", inicioTransferencia=" + inicioTransferencia
				+ ", inicioCompra=" + inicioCompra + ", crecimientoPuntos="
				+ crecimientoPuntos + ", vencimientoPuntos="
				+ vencimientoPuntos + ", reglaCalculo=" + reglaCalculo
				+ ", reconocimientoBono=" + reconocimientoBono
				+ ", activeFlag=" + activeFlag + ", conversionPuntos="
				+ conversionPuntos + ", socioFlag=" + socioFlag
				+ ", nombreSocio=" + nombreSocio + ", codOrganizacion="
				+ codOrganizacion + ", ultActualizacion=" + ultActualizacion
				+ "]";
	}
}