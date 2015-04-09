package service;

import archivos.ArchivoLista;
import dao.ListaDAO;

public class ListaService {
	private ArchivoLista file = new ArchivoLista();

	public void consultarListas() {
		ListaDAO cgd = new ListaDAO();
		file.archivarListas(cgd.listarListas());
	}
}
