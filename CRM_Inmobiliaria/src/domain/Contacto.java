package domain;

public class Contacto {
	private String rowId;
	private String rfc;
	private String cs;
	private String cazaOferta;
	private String lealtadDH;
	private String noInserto;
	private String noSMS;
	private String noContactar;
	private String promociones;
	private String eventos;
	private String aperturas;
	private String mercado;
	private String actualizacion;
	private String activacion;
	private String bienvenida;
	private String campanna;
	private String seguros;
	private String control;
	private String clienteSensible;
	private String noLlamar;
	private String noEmail;
	private String noCorreoPostal;
	private String fecUltAct;
	private String fecToday;
	private String totContactos;
	public Contacto(String rowId, String rfc, String cs, String cazaOferta,
			String lealtadDH, String noInserto, String noSMS,
			String noContactar, String promociones, String eventos,
			String aperturas, String mercado, String actualizacion,
			String activacion, String bienvenida, String campanna,
			String seguros, String control, String clienteSensible,
			String noLlamar, String noEmail, String noCorreoPostal,
			String fecUltAct) {
		super();
		this.rowId = rowId;
		this.rfc = rfc;
		this.cs = cs;
		this.cazaOferta = cazaOferta;
		this.lealtadDH = lealtadDH;
		this.noInserto = noInserto;
		this.noSMS = noSMS;
		this.noContactar = noContactar;
		this.promociones = promociones;
		this.eventos = eventos;
		this.aperturas = aperturas;
		this.mercado = mercado;
		this.actualizacion = actualizacion;
		this.activacion = activacion;
		this.bienvenida = bienvenida;
		this.campanna = campanna;
		this.seguros = seguros;
		this.control = control;
		this.clienteSensible = clienteSensible;
		this.noLlamar = noLlamar;
		this.noEmail = noEmail;
		this.noCorreoPostal = noCorreoPostal;
		this.fecUltAct = fecUltAct;
	}
	public Contacto(String fecToday, String fecUltAct, String totContactos){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.totContactos = totContactos;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getCazaOferta() {
		return cazaOferta;
	}
	public void setCazaOferta(String cazaOferta) {
		this.cazaOferta = cazaOferta;
	}
	public String getLealtadDH() {
		return lealtadDH;
	}
	public void setLealtadDH(String lealtadDH) {
		this.lealtadDH = lealtadDH;
	}
	public String getNoInserto() {
		return noInserto;
	}
	public void setNoInserto(String noInserto) {
		this.noInserto = noInserto;
	}
	public String getNoSMS() {
		return noSMS;
	}
	public void setNoSMS(String noSMS) {
		this.noSMS = noSMS;
	}
	public String getNoContactar() {
		return noContactar;
	}
	public void setNoContactar(String noContactar) {
		this.noContactar = noContactar;
	}
	public String getPromociones() {
		return promociones;
	}
	public void setPromociones(String promociones) {
		this.promociones = promociones;
	}
	public String getEventos() {
		return eventos;
	}
	public void setEventos(String eventos) {
		this.eventos = eventos;
	}
	public String getAperturas() {
		return aperturas;
	}
	public void setAperturas(String aperturas) {
		this.aperturas = aperturas;
	}
	public String getMercado() {
		return mercado;
	}
	public void setMercado(String mercado) {
		this.mercado = mercado;
	}
	public String getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(String actualizacion) {
		this.actualizacion = actualizacion;
	}
	public String getActivacion() {
		return activacion;
	}
	public void setActivacion(String activacion) {
		this.activacion = activacion;
	}
	public String getBienvenida() {
		return bienvenida;
	}
	public void setBienvenida(String bienvenida) {
		this.bienvenida = bienvenida;
	}
	public String getCampanna() {
		return campanna;
	}
	public void setCampanna(String campanna) {
		this.campanna = campanna;
	}
	public String getSeguros() {
		return seguros;
	}
	public void setSeguros(String seguros) {
		this.seguros = seguros;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public String getClienteSensible() {
		return clienteSensible;
	}
	public void setClienteSensible(String clienteSensible) {
		this.clienteSensible = clienteSensible;
	}
	public String getNoLlamar() {
		return noLlamar;
	}
	public void setNoLlamar(String noLlamar) {
		this.noLlamar = noLlamar;
	}
	public String getNoEmail() {
		return noEmail;
	}
	public void setNoEmail(String noEmail) {
		this.noEmail = noEmail;
	}
	public String getNoCorreoPostal() {
		return noCorreoPostal;
	}
	public void setNoCorreoPostal(String noCorreoPostal) {
		this.noCorreoPostal = noCorreoPostal;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	
	public String getFecToday() {
		return fecToday;
	}
	public void setFecToday(String fecToday) {
		this.fecToday = fecToday;
	}
	public String getTotContactos() {
		return totContactos;
	}
	public void setTotContactos(String totContactos) {
		this.totContactos = totContactos;
	}
	@Override
	public String toString() {
		return  rowId + "^" + rfc + "^" + cs
				+ "^" + cazaOferta + "^" + lealtadDH
				+ "^" + noInserto + "^" + noSMS
				+ "^" + noContactar + "^"
				+ promociones + "^" + eventos + "^"
				+ aperturas + "^" + mercado + "^"
				+ actualizacion + "^" + activacion
				+ "^" + bienvenida + "^" + campanna
				+ "^" + seguros + "^" + control
				+ "^" + clienteSensible + "^"
				+ noLlamar + "^" + noEmail + "^"
				+ noCorreoPostal + "^" + fecUltAct;
	}	
}