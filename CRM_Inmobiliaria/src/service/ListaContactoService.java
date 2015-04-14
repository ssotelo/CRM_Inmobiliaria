package service;

import archivos.ArchivoListaContacto;
import dao.ListaContactoDAO;

public class ListaContactoService {
	private ArchivoListaContacto file = new ArchivoListaContacto();

	public void consultarListasContactos() {
		ListaContactoDAO cld = new ListaContactoDAO();
		file.archivarListasContactos(cld.listarListasContactos());
		file.archivarListasContactosCtl(cld.listarListasContactosCtl());
	}
}