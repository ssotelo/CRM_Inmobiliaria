package domain;

public class CentroComercial {
	private String codCentroComercial;
	private String name;
	private String colonia;
	private String ciudad;
	private String pais;
	private String estado;
	private String municipio;
	private String fecApertura;
	private String facebook;
	private String twitter;
	public CentroComercial(String codCentroComercial, String name,
			String colonia, String ciudad, String pais, String estado,
			String municipio, String fecApertura, String facebook,
			String twitter) {
		super();
		this.codCentroComercial = codCentroComercial;
		this.name = name;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estado = estado;
		this.municipio = municipio;
		this.fecApertura = fecApertura;
		this.facebook = facebook;
		this.twitter = twitter;
	}
	public String getCodCentroComercial() {
		return codCentroComercial;
	}
	public void setCodCentroComercial(String codCentroComercial) {
		this.codCentroComercial = codCentroComercial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getFecApertura() {
		return fecApertura;
	}
	public void setFecApertura(String fecApertura) {
		this.fecApertura = fecApertura;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	@Override
	public String toString() {
		return codCentroComercial + "^ " + name + "^ " + colonia + "^ "
				+ ciudad + "^ " + pais + "^ " + estado + "^ " + municipio
				+ "^ " + fecApertura + "^ " + facebook + "^ " + twitter;
	}
}
