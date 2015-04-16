package service;

import archivos.ArchivoCampannaOfertaCanal;
import dao.CampannaOfertaCanalDAO;

public class CampannaOfertaCanalService {
	private ArchivoCampannaOfertaCanal file = new ArchivoCampannaOfertaCanal();

	public void consultarCampannasOfertasCanales(String Ini,String Fin, String cfg) {
		CampannaOfertaCanalDAO cgd = new CampannaOfertaCanalDAO();
		file.archivarCampannasOfertasCanales(cgd.listarCampannasOfertasCanales(Ini,Fin,cfg),cfg);
		file.archivarCampannasOfertasCanalesCtl(cgd.listarCampannasOfertasCanalesCtl(Ini,Fin,cfg),cfg);
	}
}
