package domain;

public class Campa�aTienda {
	private String campanaId;
	private String tiendaId;
	private String centroComercialId;
	private String fecIniTda;
	private String fecFinTda;
	private String fecUltAct;
	public Campa�aTienda(String campanaId, String tiendaId,
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
	@Override
	public String toString() {
		return "Campa�aTienda [campanaId=" + campanaId + ", tiendaId="
				+ tiendaId + ", centroComercialId=" + centroComercialId
				+ ", fecIniTda=" + fecIniTda + ", fecFinTda=" + fecFinTda
				+ ", fecUltAct=" + fecUltAct + "]";
	}
}