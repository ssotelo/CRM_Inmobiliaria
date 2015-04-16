package service;

import archivos.ArchivoCampannaOferta;
import dao.CampannaOfertaDAO;

public class CampannaOfertaService {
	private ArchivoCampannaOferta file = new ArchivoCampannaOferta();

	public void consultarCampannaOferta(String Ini,String Fin, String cfg) {
		CampannaOfertaDAO cgd = new CampannaOfertaDAO();
		file.archivarCampannasOfertas(cgd.listarCampannasOfertas(Ini,Fin,cfg),cfg);
		file.archivarCampannasOfertasCtl(cgd.listarCampannasOfertasCtl(Ini,Fin,cfg),cfg);
	}
}
