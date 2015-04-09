package service;

import archivos.ArchivoOferta;
import dao.OfertaDAO;

public class OfertaServices {
	private ArchivoOferta file = new ArchivoOferta();

	public void consultarOfertas() {
		OfertaDAO cld = new OfertaDAO();
		file.archivarOfertas(cld.listarOfertas());
	}
}
