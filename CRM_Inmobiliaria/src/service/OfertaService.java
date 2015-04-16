package service;

import archivos.ArchivoOferta;
import dao.OfertaDAO;

public class OfertaService {
	private ArchivoOferta file = new ArchivoOferta();

	public void consultarOfertas(String Ini,String Fin, String cfg) {
		OfertaDAO cld = new OfertaDAO();
		file.archivarOfertas(cld.listarOfertas(Ini,Fin,cfg),cfg);
		file.archivarOfertasCtl(cld.listarOfertasCtl(Ini,Fin,cfg),cfg);
	}
}
