package service;

import archivos.ArchivoContacto;
import dao.ContactoDAO;

public class ContactoService {
	private ArchivoContacto file = new ArchivoContacto();

	public void consultarCatalogosGenerales() {
		ContactoDAO cgd = new ContactoDAO();
		file.archivarContactos(cgd.listarContactos());
	}
}
