package service;

import archivos.ArchivoCampannaOfertaCanal;
import dao.CampannaOfertaCanalDAO;

public class CampannaOfertaCanalService {
	private ArchivoCampannaOfertaCanal file = new ArchivoCampannaOfertaCanal();

	public void consultarCatalogosGenerales() {
		CampannaOfertaCanalDAO cgd = new CampannaOfertaCanalDAO();
		file.archivarCampannasOfertasCanales(cgd
				.listarCampannasOfertasCanales());
	}
}
