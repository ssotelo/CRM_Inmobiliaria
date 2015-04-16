package service;

import archivos.ArchivoCampannaTienda;
import dao.CampannaTiendaDAO;

public class CampannaTiendaService {
	private ArchivoCampannaTienda file = new ArchivoCampannaTienda();
	public void consultarCampannasTiendas(String Ini,String Fin){
		CampannaTiendaDAO cld = new CampannaTiendaDAO();
		file.archivarCampannasTiendas(cld.listarCampannasTiendas(Ini,Fin));
		file.archivarCampannasTiendasCtl(cld.listarCampannasTiendasCtl(Ini,Fin));
		}
}
