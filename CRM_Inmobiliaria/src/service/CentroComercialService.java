package service;

import archivos.ArchivoCentroComercial;
import dao.CentroComercialDAO;

public class CentroComercialService {
	private ArchivoCentroComercial file = new ArchivoCentroComercial();

	public void consultarCentrosComerciales() {
		CentroComercialDAO ccd = new CentroComercialDAO();
		file.archivarCentrosComerciales(ccd.listarCentrosComerciales());
	}
}
