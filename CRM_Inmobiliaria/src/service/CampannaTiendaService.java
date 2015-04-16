package service;

import archivos.ArchivoCampannaTienda;
import dao.CampannaTiendaDAO;

public class CampannaTiendaService {
	private ArchivoCampannaTienda file = new ArchivoCampannaTienda();
	public void consultarCampannasTiendas(String Ini,String Fin, String cfg){
		CampannaTiendaDAO cld = new CampannaTiendaDAO();
		file.archivarCampannasTiendas(cld.listarCampannasTiendas(Ini,Fin,cfg),cfg);
		file.archivarCampannasTiendasCtl(cld.listarCampannasTiendasCtl(Ini,Fin,cfg),cfg);
		}
}
