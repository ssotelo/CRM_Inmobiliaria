package domain;

public class Tratamiento {
	private String rowId;
	private String name;
	public Tratamiento(String rowId, String name) {
		super();
		this.rowId = rowId;
		this.name = name;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Tratamiento [rowId=" + rowId + ", name=" + name + "]";
	}
}