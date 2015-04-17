package service;

import java.sql.Connection;

import archivos.ArchivoListaContacto;
import dao.ListaContactoDAO;

public class ListaContactoService {
	private ArchivoListaContacto file = new ArchivoListaContacto();

	public void consultarListasContactos(String Ini,String Fin, String cfg, Connection conn) {
		ListaContactoDAO cld = new ListaContactoDAO();
		file.archivarListasContactos(cld.listarListasContactos(Ini,Fin,cfg,conn),cfg);
		file.archivarListasContactosCtl(cld.listarListasContactosCtl(Ini,Fin,cfg,conn),cfg);
	}
}