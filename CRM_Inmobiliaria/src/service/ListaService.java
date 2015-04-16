package service;

import archivos.ArchivoLista;
import dao.ListaDAO;

public class ListaService {
	private ArchivoLista file = new ArchivoLista();

	public void consultarListas(String Ini,String Fin, String cfg) {
		ListaDAO cgd = new ListaDAO();
		file.archivarListas(cgd.listarListas(Ini,Fin,cfg),cfg);
		file.archivarListasCtl(cgd.listarListasCtl(Ini,Fin,cfg),cfg);
	}
}
