package domain;

public class CanalComunicacion {
	private String canalComunicacion;
	private String nombreCanal;
	public CanalComunicacion(String canalComunicacion, String nombreCanal) {
		super();
		this.canalComunicacion = canalComunicacion;
		this.nombreCanal = nombreCanal;
	}
	public String getCanalComunicacion() {
		return canalComunicacion;
	}
	public void setCanalComunicacion(String canalComunicacion) {
		this.canalComunicacion = canalComunicacion;
	}
	public String getNombreCanal() {
		return nombreCanal;
	}
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	@Override
	public String toString() {
		return  canalComunicacion
				+ "^" + nombreCanal;
	}
}
