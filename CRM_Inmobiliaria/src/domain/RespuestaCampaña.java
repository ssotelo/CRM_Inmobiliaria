package domain;

public class RespuestaCampaña {
	private String campanaId;
	private String ofertaId;
	private String tratamientoId;
	private String clienteId;
	private String listaId;
	private String respuestaId;
	private String metodoRespuesta;
	private String boleta;
	private String fecUltAct;
	public RespuestaCampaña(String campanaId, String ofertaId,
			String tratamientoId, String clienteId, String listaId,
			String respuestaId, String metodoRespuesta, String boleta,
			String fecUltAct) {
		super();
		this.campanaId = campanaId;
		this.ofertaId = ofertaId;
		this.tratamientoId = tratamientoId;
		this.clienteId = clienteId;
		this.listaId = listaId;
		this.respuestaId = respuestaId;
		this.metodoRespuesta = metodoRespuesta;
		this.boleta = boleta;
		this.fecUltAct = fecUltAct;
	}
	public String getCampanaId() {
		return campanaId;
	}
	public void setCampanaId(String campanaId) {
		this.campanaId = campanaId;
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
	@Override
	public String toString() {
		return "RespuestaCampaña [campanaId=" + campanaId + ", ofertaId="
				+ ofertaId + ", tratamientoId=" + tratamientoId
				+ ", clienteId=" + clienteId + ", listaId=" + listaId
				+ ", respuestaId=" + respuestaId + ", metodoRespuesta="
				+ metodoRespuesta + ", boleta=" + boleta + ", fecUltAct="
				+ fecUltAct + "]";
	}
}