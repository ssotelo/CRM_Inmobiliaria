package domain;

public class CampannaTienda {
	private String campanaId;
	private String tiendaId;
	private String centroComercialId;
	private String fecIniTda;
	private String fecFinTda;
	private String fecUltAct;
	private String fecToday;
	private String totCampTienda;
	private String tipoCRM;
	public CampannaTienda(String campanaId, String tiendaId,
			String centroComercialId, String fecIniTda, String fecFinTda,
			String fecUltAct) {
		super();
		this.campanaId = campanaId;
		this.tiendaId = tiendaId;
		this.centroComercialId = centroComercialId;
		this.fecIniTda = fecIniTda;
		this.fecFinTda = fecFinTda;
		this.fecUltAct = fecUltAct;
	}
	public CampannaTienda(String fecToday, String fecUltAct, String tipoCRM,
			String totCampTienda){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.tipoCRM =  tipoCRM;
		this.totCampTienda = totCampTienda;
	}
	public String getCampanaId() {
		return campanaId;
	}
	public void setCampanaId(String campanaId) {
		this.campanaId = campanaId;
	}
	public String getTiendaId() {
		return tiendaId;
	}
	public void setTiendaId(String tiendaId) {
		this.tiendaId = tiendaId;
	}
	public String getCentroComercialId() {
		return centroComercialId;
	}
	public void setCentroComercialId(String centroComercialId) {
		this.centroComercialId = centroComercialId;
	}
	public String getFecIniTda() {
		return fecIniTda;
	}
	public void setFecIniTda(String fecIniTda) {
		this.fecIniTda = fecIniTda;
	}
	public String getFecFinTda() {
		return fecFinTda;
	}
	public void setFecFinTda(String fecFinTda) {
		this.fecFinTda = fecFinTda;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	public String getFecToday() {
		return fecToday;
	}
	public void setFecToday(String fecToday) {
		this.fecToday = fecToday;
	}
	public String getTotCampTienda() {
		return totCampTienda;
	}
	public void setTotCampTienda(String totCampTienda) {
		this.totCampTienda = totCampTienda;
	}
	public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
	}
	@Override
	public String toString() {
		return  campanaId + "^"
				+ tiendaId + "^" + centroComercialId
				+ "^" + fecIniTda + "^" + fecFinTda
				+ "^" + fecUltAct;
	}
}