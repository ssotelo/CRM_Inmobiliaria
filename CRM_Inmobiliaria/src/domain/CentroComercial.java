package domain;

public class CentroComercial {
	private String rowId;
	private String Name;
	private String fecApertura;
	private String facebook;
	private String twitter;
	
	public CentroComercial(String rowId, String name, String fecApertura,
			String facebook, String twitter) {
		super();
		this.rowId = rowId;
		Name = name;
		this.fecApertura = fecApertura;
		this.facebook = facebook;
		this.twitter = twitter;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFecApertura() {
		return fecApertura;
	}

	public void setFecApertura(String fecApertura) {
		this.fecApertura = fecApertura;
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
		return "CentroComercial [rowId=" + rowId + ", Name=" + Name
				+ ", fecApertura=" + fecApertura + ", facebook=" + facebook
				+ ", twitter=" + twitter + "]";
	}
}
