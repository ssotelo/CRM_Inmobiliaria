package service;

import archivos.ArchivoCampannaOferta;
import dao.CampannaOfertaDAO;

public class CampannaOfertaService {
	private ArchivoCampannaOferta file = new ArchivoCampannaOferta();

	public void consultarCatalogosGenerales() {
		CampannaOfertaDAO cgd = new CampannaOfertaDAO();
		file.archivarCampannasOfertas(cgd.listarCampannasOfertas());
	}
}
