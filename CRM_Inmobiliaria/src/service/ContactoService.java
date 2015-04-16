package service;

import archivos.ArchivoContacto;
import dao.ContactoDAO;

public class ContactoService {
	private ArchivoContacto file = new ArchivoContacto();

	public void consultarContactos(String Ini,String Fin, String cfg) {
		ContactoDAO cgd = new ContactoDAO();
		file.archivarContactos(cgd.listarContactos(Ini,Fin,cfg),cfg);
		file.archivarContactosCtl(cgd.listarContactosCtl(Ini,Fin,cfg),cfg);
	}
}
