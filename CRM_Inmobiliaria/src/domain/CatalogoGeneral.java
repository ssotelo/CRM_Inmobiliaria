package domain;

public class CatalogoGeneral {
	private String rowId;
	private String parRowId;
	private String type;
	private String subtype;
	private String val;
	private String name;
	private String descripcion;
	private int orden;
	

	public CatalogoGeneral(String rowId, String parRowId, String type,
			String subtype, String val, String name, String descripcion, int orden) {
		super();
		this.rowId = rowId;
		this.parRowId = parRowId;
		this.type = type;
		this.subtype = subtype;
		this.val = val;
		this.name = name;
		this.descripcion = descripcion;
		this.orden = orden;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getParRowId() {
		return parRowId;
	}

	public void setParRowId(String parRowId) {
		this.parRowId = parRowId;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "CatalogoGeneral [rowId=" + rowId + ", parRowId=" + parRowId
				+ ", type=" + type + ", subtype=" + subtype + ", val=" + val
				+ ", name=" + name + ", descripcion=" + descripcion
				+ ", orden=" + orden + "]";
	}
}
