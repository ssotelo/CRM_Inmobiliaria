package service;

import archivos.ArchivoLista;
import dao.ListaDAO;

public class ListaService {
	private ArchivoLista file = new ArchivoLista();

	public void consultarListas(String Ini,String Fin) {
		ListaDAO cgd = new ListaDAO();
		file.archivarListas(cgd.listarListas(Ini,Fin));
		file.archivarListasCtl(cgd.listarListasCtl(Ini,Fin));
	}
}
