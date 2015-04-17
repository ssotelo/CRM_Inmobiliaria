package service;

import java.sql.Connection;

import archivos.ArchivoCampanna;
import dao.CampannaDAO;

public class CampannaService {
	private ArchivoCampanna file = new ArchivoCampanna();

	public void consultarCampannas(String Ini,String Fin, String cfg, Connection conn) {
		CampannaDAO cld = new CampannaDAO();
		file.archivarCampannas(cld.listarCampannas(Ini,Fin,cfg,conn),cfg);
		file.archivarCampannasCtl(cld.listarCampannasCtl(Ini,Fin,cfg,conn),cfg);
	}
}
