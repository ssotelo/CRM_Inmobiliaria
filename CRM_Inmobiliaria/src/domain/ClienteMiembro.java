package domain;


public class ClienteMiembro {
	private String personId;
	private String programId;
	private String fecUltAct;
	
	public ClienteMiembro(String personId, String programId, String fecUltAct) {
		super();
		this.personId = personId;
		this.programId = programId;
		this.fecUltAct = fecUltAct;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getFecUltAct() {
		return fecUltAct;
	}
	public void setFecUltAct(String fecUltAct) {
		this.fecUltAct = fecUltAct;
	}
	@Override
	public String toString() {
		return  personId + "^"
				+ programId + "^" + fecUltAct;
	}
	
}
