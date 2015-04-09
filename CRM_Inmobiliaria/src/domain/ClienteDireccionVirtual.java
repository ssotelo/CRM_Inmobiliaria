package domain;


public class ClienteDireccionVirtual {
	
	private String personId;
	private String tipoDireccion;
	private String virtualData;
	private String fecUltAct;
	
	public ClienteDireccionVirtual(String personId, String tipoDireccion,
			String virtualData, String fecUltAct) {
		super();
		this.personId = personId;
		this.tipoDireccion = tipoDireccion;
		this.virtualData = virtualData;
		this.fecUltAct = fecUltAct;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	public String getVirtualData() {
		return virtualData;
	}
	public void setVirtualData(String virtualData) {
		this.virtualData = virtualData;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return "ClienteDireccionVirtual [personId=" + personId
				+ ", tipoDireccion=" + tipoDireccion + ", virtualData="
				+ virtualData + ", fecUltAct=" + fecUltAct + "]";
	}

}
