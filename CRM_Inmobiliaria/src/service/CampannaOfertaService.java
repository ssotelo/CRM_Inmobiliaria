package service;

import java.sql.Connection;

import archivos.ArchivoCampannaOferta;
import dao.CampannaOfertaDAO;

public class CampannaOfertaService {
	private ArchivoCampannaOferta file = new ArchivoCampannaOferta();

	public void consultarCampannaOferta(String Ini,String Fin, String cfg, Connection conn) {
		CampannaOfertaDAO cgd = new CampannaOfertaDAO();
		file.archivarCampannasOfertas(cgd.listarCampannasOfertas(Ini,Fin,cfg,conn),cfg);
		file.archivarCampannasOfertasCtl(cgd.listarCampannasOfertasCtl(Ini,Fin,cfg,conn),cfg);
	}
}
