package service;

import archivos.ArchivoClienteTelefono;
import dao.ClienteTelefonoDAO;

public class ClienteTelefonoService {
	private ArchivoClienteTelefono file = new ArchivoClienteTelefono();

	public void consultarClientetelefono(String Ini,String Fin, String cfg) {
		ClienteTelefonoDAO ctd = new ClienteTelefonoDAO();
		file.archivarClientetelefono(ctd.listarClientestelefonos(Ini,Fin, cfg),cfg);
	}
}
