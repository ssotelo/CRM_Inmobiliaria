package domain;

public class ListaContacto {
	private String contactoId;
	private String listaId;
	private String fecIniCli;
	private String fecFinCli;
	private String fecUltAct;
	private String fecToday;
	private String totClieLista;
	public ListaContacto(String contactoId, String listaId, String fecIniCli,
			String fecFinCli, String fecUltAct) {
		super();
		this.contactoId = contactoId;
		this.listaId = listaId;
		this.fecIniCli = fecIniCli;
		this.fecFinCli = fecFinCli;
		this.fecUltAct = fecUltAct;
	}
	public ListaContacto(String fecToday, String fecUltAct, String totClieLista){
		this.fecToday = fecToday;
		this.fecUltAct = fecUltAct;
		this.totClieLista = totClieLista;
	}
	public String getContactoId() {
		return contactoId;
	}
	public void setContactoId(String contactoId) {
		this.contactoId = contactoId;
	}
	public String getListaId() {
		return listaId;
	}
	public void setListaId(String listaId) {
		this.listaId = listaId;
	}
	public String getFecIniCli() {
		return fecIniCli;
	}
	public void setFecIniCli(String fecIniCli) {
		this.fecIniCli = fecIniCli;
	}
	public String getFecFinCli() {
		return fecFinCli;
	}
	public void setFecFinCli(String fecFinCli) {
		this.fecFinCli = fecFinCli;
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
	public String getTotClieLista() {
		return totClieLista;
	}
	public void setTotClieLista(String totClieLista) {
		this.totClieLista = totClieLista;
	}
	@Override
	public String toString() {
		return  contactoId + "^"
				+ listaId + "^" + fecIniCli + "^"
				+ fecFinCli + "^" + fecUltAct;
	}
}