package service;

import archivos.ArchivoOferta;
import dao.OfertaDAO;

public class OfertaService {
	private ArchivoOferta file = new ArchivoOferta();

	public void consultarOfertas(String Ini,String Fin) {
		OfertaDAO cld = new OfertaDAO();
		file.archivarOfertas(cld.listarOfertas(Ini,Fin));
		file.archivarOfertasCtl(cld.listarOfertasCtl(Ini,Fin));
	}
}
