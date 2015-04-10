package service;

import archivos.ArchivoCampannaTienda;
import dao.CampannaTiendaDAO;

public class CampannaTiendaService {
	private ArchivoCampannaTienda file = new ArchivoCampannaTienda();
	public void consultarCampannasTiendas(){
		CampannaTiendaDAO cld = new CampannaTiendaDAO();
		file.archivarCampannasTiendas(cld.listarCampannasTiendas());
		}
}
