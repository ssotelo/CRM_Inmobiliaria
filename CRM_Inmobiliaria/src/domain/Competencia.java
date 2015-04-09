package domain;

public class Competencia {
	private String deptNum;
	private String nombreTienda;
	private String nombreCompetencia;
	private String facebook;
	private String twitter;
	
	public Competencia(String deptNum, String nombreTienda,
			String nombreCompetencia, String facebook, String twitter) {
		super();
		this.deptNum = deptNum;
		this.nombreTienda = nombreTienda;
		this.nombreCompetencia = nombreCompetencia;
		this.facebook = facebook;
		this.twitter = twitter;
	}
	
	public String getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public String getNombreCompetencia() {
		return nombreCompetencia;
	}
	public void setNombreCompetencia(String nombreCompetencia) {
		this.nombreCompetencia = nombreCompetencia;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	@Override
	public String toString() {
		return "Competencia [deptNum=" + deptNum + ", nombreTienda="
				+ nombreTienda + ", nombreCompetencia=" + nombreCompetencia
				+ ", facebook=" + facebook + ", twitter=" + twitter + "]";
	}
	
}
