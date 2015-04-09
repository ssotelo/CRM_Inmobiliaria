package domain;

public class ListaContacto {
	private String contactoId;
	private String listaId;
	private String fecIniCli;
	private String fecFinCli;
	private String fecUltAct;
	public ListaContacto(String contactoId, String listaId, String fecIniCli,
			String fecFinCli, String fecUltAct) {
		super();
		this.contactoId = contactoId;
		this.listaId = listaId;
		this.fecIniCli = fecIniCli;
		this.fecFinCli = fecFinCli;
		this.fecUltAct = fecUltAct;
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
	@Override
	public String toString() {
		return "ListaContacto [contactoId=" + contactoId + ", listaId="
				+ listaId + ", fecIniCli=" + fecIniCli + ", fecFinCli="
				+ fecFinCli + ", fecUltAct=" + fecUltAct + "]";
	}
	
	
}
