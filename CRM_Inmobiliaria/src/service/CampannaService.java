package service;

import archivos.ArchivoCampanna;
import dao.CampannaDAO;

public class CampannaService {
	private ArchivoCampanna file = new ArchivoCampanna();

	public void consultarCampannas() {
		CampannaDAO cld = new CampannaDAO();
		file.archivarCampannas(cld.listarCampannas());
	}
}
