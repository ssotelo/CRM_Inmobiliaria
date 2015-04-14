package domain;

public class CampannaOferta {

	private String campannaId;
	private String ofertaId;
	private String producto;
	private String marca;
	private String grupo;
	private String seccion;
	private String division;
	private String excProducto;
	private String excMarca;
	private String excGrupo;
	private String excSeccion;
	private String excDivision;
	private String fecIniOfer;
	private String fecUltAct;
	private String tratamientoId;
	private String tratamientoName;
	private String codLivTrat;
	private String fecToday;
	private String tipoCRM;
	private String totCampOffr;

	public CampannaOferta(String campannaId, String ofertaId, String producto,
			String marca, String grupo, String seccion, String division,
			String excProducto, String excMarca, String excGrupo,
			String excSeccion, String excDivision, String fecIniOfer,
			String fecUltAct, String tratamientoId, String tratamientoName,
			String codLivTrat) {
		super();
		this.campannaId = campannaId;
		this.ofertaId = ofertaId;
		this.producto = producto;
		this.marca = marca;
		this.grupo = grupo;
		this.seccion = seccion;
		this.division = division;
		this.excProducto = excProducto;
		this.excMarca = excMarca;
		this.excGrupo = excGrupo;
		this.excSeccion = excSeccion;
		this.excDivision = excDivision;
		this.fecIniOfer = fecIniOfer;
		this.fecUltAct = fecUltAct;
		this.tratamientoId = tratamientoId;
		this.tratamientoName = tratamientoName;
		this.codLivTrat = codLivTrat;
	}
	
	public CampannaOferta(String fecToday, String fecUltAct, String totCampOffr){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.totCampOffr = totCampOffr;
	}

	public String getCampannaId() {
		return campannaId;
	}

	public void setCampanaId(String campanaId) {
		this.campannaId = campanaId;
	}

	public String getOfertaId() {
		return ofertaId;
	}

	public void setOfertaId(String ofertaId) {
		this.ofertaId = ofertaId;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getExcProducto() {
		return excProducto;
	}

	public void setExcProducto(String excProducto) {
		this.excProducto = excProducto;
	}

	public String getExcMarca() {
		return excMarca;
	}

	public void setExcMarca(String excMarca) {
		this.excMarca = excMarca;
	}

	public String getExcGrupo() {
		return excGrupo;
	}

	public void setExcGrupo(String excGrupo) {
		this.excGrupo = excGrupo;
	}

	public String getExcSeccion() {
		return excSeccion;
	}

	public void setExcSeccion(String excSeccion) {
		this.excSeccion = excSeccion;
	}

	public String getExcDivision() {
		return excDivision;
	}

	public void setExcDivision(String excDivision) {
		this.excDivision = excDivision;
	}

	public String getFecIniOfer() {
		return fecIniOfer;
	}

	public void setFecIniOfer(String fecIniOfer) {
		this.fecIniOfer = fecIniOfer;
	}

	public String getFecUltAct() {
		return fecUltAct;
	}

	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}

	public String getTratamientoId() {
		return tratamientoId;
	}

	public void setTratamientoId(String tratamientoId) {
		this.tratamientoId = tratamientoId;
	}

	public String getTratamientoName() {
		return tratamientoName;
	}

	public void setTratamientoName(String tratamientoName) {
		this.tratamientoName = tratamientoName;
	}

	public String getCodLivTrat() {
		return codLivTrat;
	}

	public void setCodLivTrat(String codLivTrat) {
		this.codLivTrat = codLivTrat;
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

	public String getTotCampOffr() {
		return totCampOffr;
	}

	public void setTotCampOffr(String totCampOffr) {
		this.totCampOffr = totCampOffr;
	}

	@Override
	public String toString() {
		return  campannaId + "^"
				+ ofertaId + "^" + producto + "^" + marca
				+ "^" + grupo + "^" + seccion + "^"
				+ division + "^" + excProducto + "^"
				+ excMarca + "^" + excGrupo + "^"
				+ excSeccion + "^" + excDivision + "^"
				+ fecIniOfer + "^" + fecUltAct + "^"
				+ tratamientoId + "^" + tratamientoName
				+ "^" + codLivTrat;
	}
}