package service;

import archivos.ArchivoClienteMiembro;
import dao.ClienteMiembroDAO;

public class ClienteMiembroService {
	private ArchivoClienteMiembro file = new ArchivoClienteMiembro();

	public void consultarClientesMiembros() {
		ClienteMiembroDAO cmd = new ClienteMiembroDAO();
		file.archivarClientesMiembros(cmd.listarClientesMiembros());
	}
}
