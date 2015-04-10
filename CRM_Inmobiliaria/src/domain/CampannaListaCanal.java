package domain;

public class CampannaListaCanal {
	private String campanaId;
	private String listaId;
	private String tratamientoId;
	private String fecIniCam;
	private String fecFinCam;
	private String fecUltAct;
	private String tratamientoNum;
	private String tratamientoName;
	public CampannaListaCanal(String campanaId, String listaId,
			String tratamientoId, String fecIniCam, String fecFinCam,
			String fecUltAct, String tratamientoNum, String tratamientoName) {
		super();
		this.campanaId = campanaId;
		this.listaId = listaId;
		this.tratamientoId = tratamientoId;
		this.fecIniCam = fecIniCam;
		this.fecFinCam = fecFinCam;
		this.fecUltAct = fecUltAct;
		this.tratamientoNum = tratamientoNum;
		this.tratamientoName = tratamientoName;
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
	public String getTratamientoId() {
		return tratamientoId;
	}
	public void setTratamientoId(String tratamientoId) {
		this.tratamientoId = tratamientoId;
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
	@Override
	public String toString() {
		return  campanaId + "^"
				+ listaId + "^" + tratamientoId + "^"
				+ fecIniCam + "^" + fecFinCam + "^"
				+ fecUltAct + "^" + tratamientoNum
				+ "^" + tratamientoName;
	}
}