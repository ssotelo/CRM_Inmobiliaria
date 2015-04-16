package service;

import archivos.ArchivoCentroComercial;
import dao.CentroComercialDAO;

public class CentroComercialService {
	private ArchivoCentroComercial file = new ArchivoCentroComercial();

	public void consultarCentrosComerciales(String Ini,String Fin, String cfg) {
		CentroComercialDAO ccd = new CentroComercialDAO();
		file.archivarCentrosComerciales(ccd.listarCentrosComerciales(Ini,Fin, cfg),cfg);
	}
}
