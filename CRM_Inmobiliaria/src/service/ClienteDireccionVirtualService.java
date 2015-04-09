package service;

import archivos.ArchivoClienteDireccionVirtual;
import dao.ClienteDireccionVirtualDAO;

public class ClienteDireccionVirtualService {
	private ArchivoClienteDireccionVirtual file = new ArchivoClienteDireccionVirtual();

	public void consultarClientesDireccionesVirtuales() {
		ClienteDireccionVirtualDAO cvd = new ClienteDireccionVirtualDAO();
		file.archivarClienteDireccionVirtual(cvd
				.listarClientesDireccionesVirtuales());
	}
}
