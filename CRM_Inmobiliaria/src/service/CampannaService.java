package service;

import archivos.ArchivoCampanna;
import dao.CampannaDAO;

public class CampannaService {
	private ArchivoCampanna file = new ArchivoCampanna();

	public void consultarCampannas(String Ini,String Fin) {
		CampannaDAO cld = new CampannaDAO();
		file.archivarCampannas(cld.listarCampannas(Ini,Fin));
		file.archivarCampannasCtl(cld.listarCampannasCtl(Ini,Fin));
	}
}
