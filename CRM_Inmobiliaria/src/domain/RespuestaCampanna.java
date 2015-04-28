package domain;

public class RespuestaCampanna {
	private String campannaId;
	private String ofertaId;
	private String tratamientoId;
	private String clienteId;
	private String listaId;
	private String respuestaId;
	private String metodoRespuesta;
	private String boleta;
	private String fecUltAct;
	private String fecToday;
	private String totRespCamp;
	private String tipoCRM;
	private String commUID;
	private String commUIDC;
	public RespuestaCampanna(String campannaId, String ofertaId,
			String tratamientoId, String clienteId, String listaId,
			String respuestaId, String metodoRespuesta, String boleta,
			String fecUltAct, String commUID, String commUIDC) {
		super();
		this.campannaId = campannaId;
		this.ofertaId = ofertaId;
		this.tratamientoId = tratamientoId;
		this.clienteId = clienteId;
		this.listaId = listaId;
		this.respuestaId = respuestaId;
		this.metodoRespuesta = metodoRespuesta;
		this.boleta = boleta;
		this.fecUltAct = fecUltAct;
		this.commUID = commUID;
		this.commUIDC = commUIDC;
	}
	public RespuestaCampanna(String fecToday, String fecUltAct, String tipoCRM 
			,String totRespCamp){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.tipoCRM = tipoCRM;
		this.totRespCamp = totRespCamp;
	}
	public String getCampannaId() {
		return campannaId;
	}
	public void setCampannaId(String campannaId) {
		this.campannaId = campannaId;
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
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public String getListaId() {
		return listaId;
	}
	public void setListaId(String listaId) {
		this.listaId = listaId;
	}
	public String getRespuestaId() {
		return respuestaId;
	}
	public void setRespuestaId(String respuestaId) {
		this.respuestaId = respuestaId;
	}
	public String getMetodoRespuesta() {
		return metodoRespuesta;
	}
	public void setMetodoRespuesta(String metodoRespuesta) {
		this.metodoRespuesta = metodoRespuesta;
	}
	public String getBoleta() {
		return boleta;
	}
	public void setBoleta(String boleta) {
		this.boleta = boleta;
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
	public String getTotRespCamp() {
		return totRespCamp;
	}
	public void setTotRespCamp(String totRespCamp) {
		this.totRespCamp = totRespCamp;
	}
	public String getTipoCRM() {
		return tipoCRM;
	}
	public void setTipoCRM(String tipoCRM) {
		this.tipoCRM = tipoCRM;
	}
	public String getCommUID() {
		return commUID;
	}
	public void setCommUID(String commUID) {
		this.commUID = commUID;
	}
	public String getCommUIDC() {
		return commUIDC;
	}
	public void setCommUIDC(String commUIDC) {
		this.commUIDC = commUIDC;
	}
	@Override
	public String toString() {
		return campannaId + "^"
				+ ofertaId + "^" + tratamientoId
				+ "^" + clienteId + "^" + listaId
				+ "^" + respuestaId + "^"
				+ metodoRespuesta + "^" + boleta + "^"
				+ fecUltAct;
	}
}