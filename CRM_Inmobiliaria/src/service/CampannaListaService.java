package service;

import archivos.ArchivoCampannaLista;
import dao.CampannaListaDAO;

public class CampannaListaService {
	private ArchivoCampannaLista file = new ArchivoCampannaLista();

	public void consultarCampannasListas() {
		CampannaListaDAO cgd = new CampannaListaDAO();
		file.archivarCampannasListas(cgd.listarCampannasListas());
	}
}
