package domain;


public class ClienteDireccion {
	private String personId;
	private String addressId;
	private String calle;
	private String numExt;
	private String numInt;
	private String edif;
	private String codpos;
	private String colonia;
	private String municipio;
	private String estado;
	private String pais;
	private String fecUltAct;
	
	public ClienteDireccion(String personId, String addressId, String calle,
			String numExt, String numInt, String edif, String codpos,
			String colonia, String municipio, String estado, String pais,
			String fecUltAct) {
		super();
		this.personId = personId;
		this.addressId = addressId;
		this.calle = calle;
		this.numExt = numExt;
		this.numInt = numInt;
		this.edif = edif;
		this.codpos = codpos;
		this.colonia = colonia;
		this.municipio = municipio;
		this.estado = estado;
		this.pais = pais;
		this.fecUltAct = fecUltAct;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumExt() {
		return numExt;
	}
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}
	public String getNumInt() {
		return numInt;
	}
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}
	public String getEdif() {
		return edif;
	}
	public void setEdif(String edif) {
		this.edif = edif;
	}
	public String getCodpos() {
		return codpos;
	}
	public void setCodpos(String codpos) {
		this.codpos = codpos;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return "ClienteDireccion [personId=" + personId + ", addressId="
				+ addressId + ", calle=" + calle + ", numExt=" + numExt
				+ ", numInt=" + numInt + ", edif=" + edif + ", codpos="
				+ codpos + ", colonia=" + colonia + ", municipio=" + municipio
				+ ", estado=" + estado + ", pais=" + pais + ", fecUltAct="
				+ fecUltAct + "]";
	}

}
