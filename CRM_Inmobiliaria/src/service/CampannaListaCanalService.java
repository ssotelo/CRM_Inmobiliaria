package service;

import archivos.ArchivoCampanaListaCanal;
import dao.CampannaListaCanalDAO;

public class CampannaListaCanalService {
	private ArchivoCampanaListaCanal file = new ArchivoCampanaListaCanal();

	public void consultarCampannaListaCanal(String Ini,String Fin, String cfg) {
		CampannaListaCanalDAO cgd = new CampannaListaCanalDAO();
		file.archivarCampannasListasCanales(cgd.listarCampannasListasCanales(Ini,Fin,cfg),cfg);
		file.archivarCampannasListasCanalesCtl(cgd.listarCampannasListasCanalesCtl(Ini,Fin,cfg),cfg);
	}
}