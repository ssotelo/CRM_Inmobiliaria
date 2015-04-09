package service;

import archivos.ArchivoCatalogoGeneral;
import dao.CatalogoGeneralDAO;

public class CatalogoGeneralService {
	private ArchivoCatalogoGeneral file = new ArchivoCatalogoGeneral();

	public void consultarCatalogosGenerales() {
		CatalogoGeneralDAO cgd = new CatalogoGeneralDAO();
		file.archivarCatalogosGenerales(cgd.listarCatalogosGenerales());
	}
}