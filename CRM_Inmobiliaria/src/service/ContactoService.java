package service;

import archivos.ArchivoContacto;
import dao.ContactoDAO;

public class ContactoService {
	private ArchivoContacto file = new ArchivoContacto();

	public void consultarContactos(String Ini,String Fin) {
		ContactoDAO cgd = new ContactoDAO();
		file.archivarContactos(cgd.listarContactos(Ini,Fin));
		file.archivarContactosCtl(cgd.listarContactosCtl(Ini,Fin));
	}
}
