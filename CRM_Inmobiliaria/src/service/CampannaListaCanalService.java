package service;

import java.sql.Connection;

import archivos.ArchivoCampanaListaCanal;
import dao.CampannaListaCanalDAO;

public class CampannaListaCanalService {
	private ArchivoCampanaListaCanal file = new ArchivoCampanaListaCanal();

	public void consultarCampannaListaCanal(String Ini,String Fin, String cfg, Connection conn) {
		CampannaListaCanalDAO cgd = new CampannaListaCanalDAO();
		file.archivarCampannasListasCanales(cgd.listarCampannasListasCanales(Ini,Fin,cfg,conn),cfg);
		file.archivarCampannasListasCanalesCtl(cgd.listarCampannasListasCanalesCtl(Ini,Fin,cfg,conn),cfg);
	}
}