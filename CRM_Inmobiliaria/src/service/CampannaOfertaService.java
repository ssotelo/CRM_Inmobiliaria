package service;

import archivos.ArchivoCampannaOferta;
import dao.CampannaOfertaDAO;

public class CampannaOfertaService {
	private ArchivoCampannaOferta file = new ArchivoCampannaOferta();

	public void consultarCampannaOferta() {
		CampannaOfertaDAO cgd = new CampannaOfertaDAO();
		file.archivarCampannasOfertas(cgd.listarCampannasOfertas());
		file.archivarCampannasOfertasCtl(cgd.listarCampannasOfertasCtl());
	}
}
