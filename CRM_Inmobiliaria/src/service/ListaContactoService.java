package service;

import archivos.ArchivoListaContacto;
import dao.ListaContactoDAO;

public class ListaContactoService {
	private ArchivoListaContacto file = new ArchivoListaContacto();

	public void consultarListasContactos(String Ini,String Fin, String cfg) {
		ListaContactoDAO cld = new ListaContactoDAO();
		file.archivarListasContactos(cld.listarListasContactos(Ini,Fin,cfg),cfg);
		file.archivarListasContactosCtl(cld.listarListasContactosCtl(Ini,Fin,cfg),cfg);
	}
}