package service;

import java.sql.Connection;

import archivos.ArchivoCampannaOfertaCanal;
import dao.CampannaOfertaCanalDAO;

public class CampannaOfertaCanalService {
	private ArchivoCampannaOfertaCanal file = new ArchivoCampannaOfertaCanal();

	public void consultarCampannasOfertasCanales(String Ini,String Fin, String cfg, Connection conn) {
		CampannaOfertaCanalDAO cgd = new CampannaOfertaCanalDAO();
		file.archivarCampannasOfertasCanales(cgd.listarCampannasOfertasCanales(Ini,Fin,cfg,conn),cfg);
		file.archivarCampannasOfertasCanalesCtl(cgd.listarCampannasOfertasCanalesCtl(Ini,Fin,cfg,conn),cfg);
	}
}
