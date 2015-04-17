package service;

import java.sql.Connection;

import archivos.ArchivoOferta;
import dao.OfertaDAO;

public class OfertaService {
	private ArchivoOferta file = new ArchivoOferta();

	public void consultarOfertas(String Ini,String Fin, String cfg, Connection conn) {
		OfertaDAO cld = new OfertaDAO();
		file.archivarOfertas(cld.listarOfertas(Ini,Fin,cfg,conn),cfg);
		file.archivarOfertasCtl(cld.listarOfertasCtl(Ini,Fin,cfg,conn),cfg);
	}
}
