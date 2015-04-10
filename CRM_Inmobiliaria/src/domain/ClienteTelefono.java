package domain;


public class ClienteTelefono {
	private String phoneId;
	private String numTelefonico;
	private String tipoNumero;
	private String extension;
	private String fecUltAct;
	
	public ClienteTelefono(String phoneId, String numTelefonico,
			String tipoNumero, String extension, String fecUltAct) {
		super();
		this.phoneId = phoneId;
		this.numTelefonico = numTelefonico;
		this.tipoNumero = tipoNumero;
		this.extension = extension;
		this.fecUltAct = fecUltAct;
	}
	public String getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	public String getNumTelefonico() {
		return numTelefonico;
	}
	public void setNumTelefonico(String numTelefonico) {
		this.numTelefonico = numTelefonico;
	}
	public String getTipoNumero() {
		return tipoNumero;
	}
	public void setTipoNumero(String tipoNumero) {
		this.tipoNumero = tipoNumero;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return  phoneId + "^"
				+ numTelefonico + "^" + tipoNumero + "^"
				+ extension + "^" + fecUltAct;
	}
}
