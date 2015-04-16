package service;

import archivos.ArchivoCampannaOferta;
import dao.CampannaOfertaDAO;

public class CampannaOfertaService {
	private ArchivoCampannaOferta file = new ArchivoCampannaOferta();

	public void consultarCampannaOferta(String Ini,String Fin) {
		CampannaOfertaDAO cgd = new CampannaOfertaDAO();
		file.archivarCampannasOfertas(cgd.listarCampannasOfertas(Ini,Fin));
		file.archivarCampannasOfertasCtl(cgd.listarCampannasOfertasCtl(Ini,Fin));
	}
}
