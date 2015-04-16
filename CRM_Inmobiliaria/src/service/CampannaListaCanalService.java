package service;

import archivos.ArchivoCampanaListaCanal;
import dao.CampannaListaCanalDAO;

public class CampannaListaCanalService {
	private ArchivoCampanaListaCanal file = new ArchivoCampanaListaCanal();

	public void consultarCampannaListaCanal(String Ini,String Fin) {
		CampannaListaCanalDAO cgd = new CampannaListaCanalDAO();
		file.archivarCampannasListasCanales(cgd.listarCampannasListasCanales(Ini,Fin));
		file.archivarCampannasListasCanalesCtl(cgd.listarCampannasListasCanalesCtl(Ini,Fin));
	}
}