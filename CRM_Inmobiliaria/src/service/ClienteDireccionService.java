package service;

import archivos.ArchivoClienteDireccion;
import dao.ClienteDireccionDAO;

public class ClienteDireccionService {
	private ArchivoClienteDireccion file = new ArchivoClienteDireccion();

	public void consultarClientesDireccion() {
		ClienteDireccionDAO cdd = new ClienteDireccionDAO();
		file.archivarClienteDireccion(cdd.listarClientesDirecciones());
	}
}
