package service;

import archivos.ArchivoCampanaListaCanal;
import dao.CampannaListaCanalDAO;

public class CampannaListaCanalService {
	private ArchivoCampanaListaCanal file = new ArchivoCampanaListaCanal();

	public void consultarCatalogosGenerales() {
		CampannaListaCanalDAO cgd = new CampannaListaCanalDAO();
		file.archivarCampannasListasCanales(cgd.listarCampannasListasCanales());
	}
}