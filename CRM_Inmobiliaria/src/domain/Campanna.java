package domain;

public class Campanna {
	private String rowId;
	private String name;
	private String descripcion;
	private String type;
	private String mktgId;
	private String prioridad;
	private String campannaPadre;
	private String status;
	private String aprobacion;
	private String planMktg;
	private String hashtag;
	private String fecIniCam;
	private String fecFinCam;
	private String presupuesto;
	private String usuario;
	private String fecUltAct;
	private String codCampanna;
	private String codLivCamp;
	private String fecToday;
	private String totCamp;
	private String tipoCRM;

	public Campanna(String rowId, String name, String descripcion, String tipoCRM,String type,
			String mktgId, String prioridad, String campannaPadre,
			String status, String aprobacion, String planMktg, String hashtag,
			String fecIniCam, String fecFinCam, String presupuesto,
			String usuario, String fecUltAct, String codCampanna,
			String codLivCamp) {
		super();
		this.rowId = rowId;
		this.name = name;
		this.descripcion = descripcion;
		this.tipoCRM =  tipoCRM;
		this.type = type;
		this.mktgId = mktgId;
		this.prioridad = prioridad;
		this.campannaPadre = campannaPadre;
		this.status = status;
		this.aprobacion = aprobacion;
		this.planMktg = planMktg;
		this.hashtag = hashtag;
		this.fecIniCam = fecIniCam;
		this.fecFinCam = fecFinCam;
		this.presupuesto = presupuesto;
		this.usuario = usuario;
		this.fecUltAct = fecUltAct;
		this.codCampanna = codCampanna;
		this.codLivCamp = codLivCamp;
	}
	public Campanna(String fecToday, String fecUltAct, String tipoCRM
			, String totCamp){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.tipoCRM = tipoCRM;
		this.totCamp = totCamp;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMktgId() {
		return mktgId;
	}

	public void setMktgId(String mktgId) {
		this.mktgId = mktgId;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getCampannaPadre() {
		return campannaPadre;
	}

	public void setCampannaPadre(String campannaPadre) {
		this.campannaPadre = campannaPadre;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}

	public String getPlanMktg() {
		return planMktg;
	}

	public void setPlanMktg(String planMktg) {
		this.planMktg = planMktg;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getFecIniCam() {
		return fecIniCam;
	}

	public void setFecIniCam(String fecIniCam) {
		this.fecIniCam = fecIniCam;
	}

	public String getFecFinCam() {
		return fecFinCam;
	}

	public void setFecFinCam(String fecFinCam) {
		this.fecFinCam = fecFinCam;
	}

	public String getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFecUltAct() {
		return fecUltAct;
	}

	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}

	public String getCodCampanna() {
		return codCampanna;
	}

	public void setCodCampanna(String codCampanna) {
		this.codCampanna = codCampanna;
	}

	public String getCodLivCamp() {
		return codLivCamp;
	}

	public void setCodLivCamp(String codLivCamp) {
		this.codLivCamp = codLivCamp;
	}
	public String getFecToday() {
		return fecToday;
	}
	public void setFecToday(String fecToday) {
		this.fecToday = fecToday;
	}
	public String getTotCamp() {
		return totCamp;
	}
	public void setTotCamp(String totCamp) {
		this.totCamp = totCamp;
	}
	public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
	}
	@Override
	public String toString() {
		return rowId + "^" + name + "^" + descripcion + "^" + type + "^"
				+ mktgId + "^" + prioridad + "^" + campannaPadre + "^" + status
				+ "^" + aprobacion + "^" + planMktg + "^" + hashtag + "^"
				+ fecIniCam + "^" + fecFinCam + "^" + presupuesto + "^"
				+ usuario + "^" + fecUltAct + "^" + codCampanna + "^"
				+ codLivCamp;
	}

}
