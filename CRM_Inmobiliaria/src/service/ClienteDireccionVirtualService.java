package service;

import archivos.ArchivoClienteDireccionVirtual;
import dao.ClienteDireccionVirtualDAO;

public class ClienteDireccionVirtualService {
	private ArchivoClienteDireccionVirtual file = new ArchivoClienteDireccionVirtual();

	public void consultarClientesDireccionesVirtuales(String Ini,String Fin, String cfg) {
		ClienteDireccionVirtualDAO cvd = new ClienteDireccionVirtualDAO();
		file.archivarClienteDireccionVirtual(cvd
				.listarClientesDireccionesVirtuales(Ini,Fin, cfg),cfg);
	}
}