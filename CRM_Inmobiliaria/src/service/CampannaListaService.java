package service;

import java.sql.Connection;

import archivos.ArchivoCampannaLista;
import dao.CampannaListaDAO;

public class CampannaListaService {
	private ArchivoCampannaLista file = new ArchivoCampannaLista();

	public void consultarCampannasListas(String Ini,String Fin, String cfg, Connection conn) {
		CampannaListaDAO cgd = new CampannaListaDAO();
		file.archivarCampannasListas(cgd.listarCampannasListas(Ini,Fin,cfg,conn),cfg);
	}
}
