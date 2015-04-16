package service;

import archivos.ArchivoCatalogoGeneral;
import dao.CatalogoGeneralDAO;

public class CatalogoGeneralService {
	private ArchivoCatalogoGeneral file = new ArchivoCatalogoGeneral();

	public void consultarCatalogosGenerales(String Ini,String Fin, String cfg) {
		CatalogoGeneralDAO cgd = new CatalogoGeneralDAO();
		file.archivarCatalogosGenerales(cgd.listarCatalogosGenerales(Ini,Fin,cfg),cfg);
	}
}