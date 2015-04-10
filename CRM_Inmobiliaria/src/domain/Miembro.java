package domain;

public class Miembro {
	private String rowId;
	private String programId;
	private String personId;
	private String tipoAcumulacion;
	private String canalAlta;
	private String fecAlta;
	private String fecExp;
	private String fecCan;
	private String numMem;
	private String tipMem;
	private String statusMiembro;
	private String codigoEsquema;
	private double puntuacion;
	private double puntuacionA;
	private double puntuacionB;
	private double puntuacionC;
	private double puntuacionD;
	private double centroComercial;
	private String fecUltAct;
	public Miembro(String rowId, String programId, String personId,
			String tipoAcumulacion, String canalAlta, String fecAlta,
			String fecExp, String fecCan, String numMem, String tipMem,
			String statusMiembro, String codigoEsquema, double puntuacion,
			double puntuacionA, double puntuacionB, double puntuacionC,
			double puntuacionD, double centroComercial, String fecUltAct) {
		super();
		this.rowId = rowId;
		this.programId = programId;
		this.personId = personId;
		this.tipoAcumulacion = tipoAcumulacion;
		this.canalAlta = canalAlta;
		this.fecAlta = fecAlta;
		this.fecExp = fecExp;
		this.fecCan = fecCan;
		this.numMem = numMem;
		this.tipMem = tipMem;
		this.statusMiembro = statusMiembro;
		this.codigoEsquema = codigoEsquema;
		this.puntuacion = puntuacion;
		this.puntuacionA = puntuacionA;
		this.puntuacionB = puntuacionB;
		this.puntuacionC = puntuacionC;
		this.puntuacionD = puntuacionD;
		this.centroComercial = centroComercial;
		this.fecUltAct = fecUltAct;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getTipoAcumulacion() {
		return tipoAcumulacion;
	}
	public void setTipoAcumulacion(String tipoAcumulacion) {
		this.tipoAcumulacion = tipoAcumulacion;
	}
	public String getCanalAlta() {
		return canalAlta;
	}
	public void setCanalAlta(String canalAlta) {
		this.canalAlta = canalAlta;
	}
	public String getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(String fecAlta) {
		this.fecAlta = fecAlta;
	}
	public String getFecExp() {
		return fecExp;
	}
	public void setFecExp(String fecExp) {
		this.fecExp = fecExp;
	}
	public String getFecCan() {
		return fecCan;
	}
	public void setFecCan(String fecCan) {
		this.fecCan = fecCan;
	}
	public String getNumMem() {
		return numMem;
	}
	public void setNumMem(String numMem) {
		this.numMem = numMem;
	}
	public String getTipMem() {
		return tipMem;
	}
	public void setTipMem(String tipMem) {
		this.tipMem = tipMem;
	}
	public String getStatusMiembro() {
		return statusMiembro;
	}
	public void setStatusMiembro(String statusMiembro) {
		this.statusMiembro = statusMiembro;
	}
	public String getCodigoEsquema() {
		return codigoEsquema;
	}
	public void setCodigoEsquema(String codigoEsquema) {
		this.codigoEsquema = codigoEsquema;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public double getPuntuacionA() {
		return puntuacionA;
	}
	public void setPuntuacionA(double puntuacionA) {
		this.puntuacionA = puntuacionA;
	}
	public double getPuntuacionB() {
		return puntuacionB;
	}
	public void setPuntuacionB(double puntuacionB) {
		this.puntuacionB = puntuacionB;
	}
	public double getPuntuacionC() {
		return puntuacionC;
	}
	public void setPuntuacionC(double puntuacionC) {
		this.puntuacionC = puntuacionC;
	}
	public double getPuntuacionD() {
		return puntuacionD;
	}
	public void setPuntuacionD(double puntuacionD) {
		this.puntuacionD = puntuacionD;
	}
	public double getCentroComercial() {
		return centroComercial;
	}
	public void setCentroComercial(double centroComercial) {
		this.centroComercial = centroComercial;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return  rowId + "^" + programId
				+ "^" + personId + "^"
				+ tipoAcumulacion + "^" + canalAlta + "^"
				+ fecAlta + "^" + fecExp + "^" + fecCan
				+ "^" + numMem + "^" + tipMem
				+ "^" + statusMiembro + "^"
				+ codigoEsquema + "^" + puntuacion
				+ "^" + puntuacionA + "^"
				+ puntuacionB + "^" + puntuacionC
				+ "^" + puntuacionD + "^"
				+ centroComercial + "^" + fecUltAct;
	}
	
}