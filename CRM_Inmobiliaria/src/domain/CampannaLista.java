package domain;

public class CampannaLista {
	private String campanaId;
	private String listaId;
	private String fecIniCamp;
	private String fecFinCamp;
	private String fecUltAct;
	public CampannaLista(String campanaId, String listaId, String fecIniCamp,
			String fecFinCamp, String fecUltAct) {
		super();
		this.campanaId = campanaId;
		this.listaId = listaId;
		this.fecIniCamp = fecIniCamp;
		this.fecFinCamp = fecFinCamp;
		this.fecUltAct = fecUltAct;
	}
	public String getCampanaId() {
		return campanaId;
	}
	public void setCampanaId(String campanaId) {
		this.campanaId = campanaId;
	}
	public String getListaId() {
		return listaId;
	}
	public void setListaId(String listaId) {
		this.listaId = listaId;
	}
	public String getFecIniCamp() {
		return fecIniCamp;
	}
	public void setFecIniCamp(String fecIniCamp) {
		this.fecIniCamp = fecIniCamp;
	}
	public String getFecFinCamp() {
		return fecFinCamp;
	}
	public void setFecFinCamp(String fecFinCamp) {
		this.fecFinCamp = fecFinCamp;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return  campanaId + "^" + listaId
				+ "^" + fecIniCamp + "^" + fecFinCamp
				+ "^" + fecUltAct;
	}
}