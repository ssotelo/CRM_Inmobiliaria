package service;

import archivos.ArchivoContacto;
import dao.ContactoDAO;

public class ContactoService {
	private ArchivoContacto file = new ArchivoContacto();

	public void consultarContactos() {
		ContactoDAO cgd = new ContactoDAO();
		file.archivarContactos(cgd.listarContactos());
	}
}
