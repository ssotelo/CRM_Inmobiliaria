package domain;

public class CampannaOfertaCanal {
	private String ofertaId;
	private String tratamientoId;
	private String campanaId;
	private String aprobacion;
	private String costo;
	private String fecIniChnl;
	private String fecFinChnl;
	private String fecUltAct;
	private String tratamientoNum;
	private String tratamientoName;
	private String fecToday;
	private String tipoCRM;
	private String totCampOffrCan;
	public CampannaOfertaCanal(String ofertaId, String tratamientoId,
			String campanaId, String aprobacion, String costo,
			String fecIniChnl, String fecFinChnl, String fecUltAct,
			String tratamientoNum, String tratamientoName) {
		super();
		this.ofertaId = ofertaId;
		this.tratamientoId = tratamientoId;
		this.campanaId = campanaId;
		this.aprobacion = aprobacion;
		this.costo = costo;
		this.fecIniChnl = fecIniChnl;
		this.fecFinChnl = fecFinChnl;
		this.fecUltAct = fecUltAct;
		this.tratamientoNum = tratamientoNum;
		this.tratamientoName = tratamientoName;
	}
	public CampannaOfertaCanal(String fecToday, String fecUltAct, String totCampOffrCan){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.totCampOffrCan = totCampOffrCan;
	}
	public String getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(String ofertaId) {
		this.ofertaId = ofertaId;
	}
	public String getTratamientoId() {
		return tratamientoId;
	}
	public void setTratamientoId(String tratamientoId) {
		this.tratamientoId = tratamientoId;
	}
	public String getCampanaId() {
		return campanaId;
	}
	public void setCampanaId(String campanaId) {
		this.campanaId = campanaId;
	}
	public String getAprobacion() {
		return aprobacion;
	}
	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getFecIniChnl() {
		return fecIniChnl;
	}
	public void setFecIniChnl(String fecIniChnl) {
		this.fecIniChnl = fecIniChnl;
	}
	public String getFecFinChnl() {
		return fecFinChnl;
	}
	public void setFecFinChnl(String fecFinChnl) {
		this.fecFinChnl = fecFinChnl;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	public String getTratamientoNum() {
		return tratamientoNum;
	}
	public void setTratamientoNum(String tratamientoNum) {
		this.tratamientoNum = tratamientoNum;
	}
	public String getTratamientoName() {
		return tratamientoName;
	}
	public void setTratamientoName(String tratamientoName) {
		this.tratamientoName = tratamientoName;
	}
	public String getFecToday() {
		return fecToday;
	}
	public void setFecToday(String fecToday) {
		this.fecToday = fecToday;
	}
	public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
	}
	public String getTotCampOffrCan() {
		return totCampOffrCan;
	}
	public void setTotCampOffrCan(String totCampOffrCan) {
		this.totCampOffrCan = totCampOffrCan;
	}
	@Override
	public String toString() {
		return  ofertaId + "^"
				+ tratamientoId + "^" + campanaId + "^"
				+ aprobacion + "^" + costo + "^"
				+ fecIniChnl + "^" + fecFinChnl + "^"
				+ fecUltAct + "^" + tratamientoNum
				+ "^" + tratamientoName;
	}
}