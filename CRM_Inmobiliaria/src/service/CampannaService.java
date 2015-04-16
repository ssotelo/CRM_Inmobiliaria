package service;

import archivos.ArchivoCampanna;
import dao.CampannaDAO;

public class CampannaService {
	private ArchivoCampanna file = new ArchivoCampanna();

	public void consultarCampannas(String Ini,String Fin, String cfg) {
		CampannaDAO cld = new CampannaDAO();
		file.archivarCampannas(cld.listarCampannas(Ini,Fin,cfg),cfg);
		file.archivarCampannasCtl(cld.listarCampannasCtl(Ini,Fin,cfg),cfg);
	}
}
