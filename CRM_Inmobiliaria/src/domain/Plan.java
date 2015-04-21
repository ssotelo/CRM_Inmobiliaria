package domain;

public class Plan {
	private String rowId;
	private String tipoPlan;
	private String nombre;
	private String aprobacion;
	private String descripcion;
	private String regionId;
	private String fecIniPlan;
	private String fecFinPlan;
	private String fecUltAct;
	private String codPlan;
	private String tipoCRM;
	private String fecToday;
	private String totPlanes;
	public Plan(String rowId, String tipoPlan, String nombre,
			String aprobacion, String descripcion, String regionId,
			String fecIniPlan, String fecFinPlan, String fecUltAct,
			String codPlan, String tipoCRM) {
		super();
		this.rowId = rowId;
		this.tipoPlan = tipoPlan;
		this.nombre = nombre;
		this.aprobacion = aprobacion;
		this.descripcion = descripcion;
		this.regionId = regionId;
		this.fecIniPlan = fecIniPlan;
		this.fecFinPlan = fecFinPlan;
		this.fecUltAct = fecUltAct;
		this.codPlan = codPlan;
		this.tipoCRM = tipoCRM;
	}
	public Plan(String fecToday, String fecUltAct, String totPlanes){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.totPlanes = totPlanes;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAprobacion() {
		return aprobacion;
	}
	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getFecIniPlan() {
		return fecIniPlan;
	}
	public void setFecIniPlan(String fecIniPlan) {
		this.fecIniPlan = fecIniPlan;
	}
	public String getFecFinPlan() {
		return fecFinPlan;
	}
	public void setFecFinPlan(String fecFinPlan) {
		this.fecFinPlan = fecFinPlan;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	public String getCodPlan() {
		return codPlan;
	}
	public void setCodPlan(String codPlan) {
		this.codPlan = codPlan;
	}
	public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
	}
	public String getFecToday() {
		return fecToday;
	}
	public void setFecToday(String fecToday) {
		this.fecToday = fecToday;
	}
	public String getTotPlanes() {
		return totPlanes;
	}
	public void setTotPlanes(String totPlanes) {
		this.totPlanes = totPlanes;
	}
	@Override
	public String toString() {
		return  rowId + "^" + tipoPlan + "^"
				+ nombre + "^" + aprobacion + "^"
				+ descripcion + "^" + regionId + "^"
				+ fecIniPlan + "^" + fecFinPlan + "^"
				+ fecUltAct + "^" + codPlan;
	}
}
