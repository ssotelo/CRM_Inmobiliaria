package domain;

public class Campanna {
	private String rowId;
	private String name;
	private String descripcion;
	private String tipoCRM;
	private String type;
	private String mktgId;
	private String prioridad;
	private String campañaPadre;
	private String status;
	private String aprobacion;
	private String planMktg;
	private String hashtag;
	private String fecIniCam;
	private String fecFinCam;
	private String presupuesto;
	private String usuario;
	private String fecUltAct;
	private String codCampana;
	private String codLivCamp;
	public Campanna(String rowId, String name, String descripcion,
			String tipoCRM, String type, String mktgId, String prioridad,
			String campañaPadre, String status, String aprobacion,
			String planMktg, String hashtag, String fecIniCam,
			String fecFinCam, String presupuesto, String usuario,
			String fecUltAct, String codCampana, String codLivCamp) {
		super();
		this.rowId = rowId;
		this.name = name;
		this.descripcion = descripcion;
		this.tipoCRM = tipoCRM;
		this.type = type;
		this.mktgId = mktgId;
		this.prioridad = prioridad;
		this.campañaPadre = campañaPadre;
		this.status = status;
		this.aprobacion = aprobacion;
		this.planMktg = planMktg;
		this.hashtag = hashtag;
		this.fecIniCam = fecIniCam;
		this.fecFinCam = fecFinCam;
		this.presupuesto = presupuesto;
		this.usuario = usuario;
		this.fecUltAct = fecUltAct;
		this.codCampana = codCampana;
		this.codLivCamp = codLivCamp;
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
	public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
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
	public String getCampañaPadre() {
		return campañaPadre;
	}
	public void setCampañaPadre(String campañaPadre) {
		this.campañaPadre = campañaPadre;
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
	public String getCodCampana() {
		return codCampana;
	}
	public void setCodCampana(String codCampana) {
		this.codCampana = codCampana;
	}
	public String getCodLivCamp() {
		return codLivCamp;
	}
	public void setCodLivCamp(String codLivCamp) {
		this.codLivCamp = codLivCamp;
	}
	@Override
	public String toString() {
		return "Campaña [rowId=" + rowId + ", name=" + name + ", descripcion="
				+ descripcion + ", tipoCRM=" + tipoCRM + ", type=" + type
				+ ", mktgId=" + mktgId + ", prioridad=" + prioridad
				+ ", campañaPadre=" + campañaPadre + ", status=" + status
				+ ", aprobacion=" + aprobacion + ", planMktg=" + planMktg
				+ ", hashtag=" + hashtag + ", fecIniCam=" + fecIniCam
				+ ", fecFinCam=" + fecFinCam + ", presupuesto=" + presupuesto
				+ ", usuario=" + usuario + ", fecUltAct=" + fecUltAct 
				+ ", codCampana="+ codCampana +", codLivCamp="+ codLivCamp +"]";
	}
}