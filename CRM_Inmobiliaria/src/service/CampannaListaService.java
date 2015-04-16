package service;

import archivos.ArchivoCampannaLista;
import dao.CampannaListaDAO;

public class CampannaListaService {
	private ArchivoCampannaLista file = new ArchivoCampannaLista();

	public void consultarCampannasListas(String Ini,String Fin, String cfg) {
		CampannaListaDAO cgd = new CampannaListaDAO();
		file.archivarCampannasListas(cgd.listarCampannasListas(Ini,Fin,cfg),cfg);
	}
}
