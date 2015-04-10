package domain;

public class Direccion {
	private String codMunicipio;
	private String descMunicipio;
	private String codEstado;
	private String descEstado;
	private String descPais;
	public Direccion(String codMunicipio, String descMunicipio,
			String codEstado, String descEstado, String descPais) {
		super();
		this.codMunicipio = codMunicipio;
		this.descMunicipio = descMunicipio;
		this.codEstado = codEstado;
		this.descEstado = descEstado;
		this.descPais = descPais;
	}
	public String getCodMunicipio() {
		return codMunicipio;
	}
	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
	public String getDescMunicipio() {
		return descMunicipio;
	}
	public void setDescMunicipio(String descMunicipio) {
		this.descMunicipio = descMunicipio;
	}
	public String getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}
	public String getDescEstado() {
		return descEstado;
	}
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
	public String getDescPais() {
		return descPais;
	}
	public void setDescPais(String descPais) {
		this.descPais = descPais;
	}
	@Override
	public String toString() {
		return codMunicipio + "^ " + descMunicipio + "^ " + codEstado + "^ "
				+ descEstado + "^ " + descPais;
	}
}
