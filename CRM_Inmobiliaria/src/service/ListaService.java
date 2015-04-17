package service;

import java.sql.Connection;

import archivos.ArchivoLista;
import dao.ListaDAO;

public class ListaService {
	private ArchivoLista file = new ArchivoLista();

	public void consultarListas(String Ini,String Fin, String cfg, Connection conn) {
		ListaDAO cgd = new ListaDAO();
		file.archivarListas(cgd.listarListas(Ini,Fin,cfg,conn),cfg);
		file.archivarListasCtl(cgd.listarListasCtl(Ini,Fin,cfg,conn),cfg);
	}
}
