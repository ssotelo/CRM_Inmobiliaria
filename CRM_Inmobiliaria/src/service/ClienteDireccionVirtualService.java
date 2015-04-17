package service;

import java.sql.Connection;

import archivos.ArchivoClienteDireccionVirtual;
import dao.ClienteDireccionVirtualDAO;

public class ClienteDireccionVirtualService {
	private ArchivoClienteDireccionVirtual file = new ArchivoClienteDireccionVirtual();

	public void consultarClientesDireccionesVirtuales(String Ini,String Fin, String cfg, Connection conn) {
		ClienteDireccionVirtualDAO cvd = new ClienteDireccionVirtualDAO();
		file.archivarClienteDireccionVirtual(cvd
				.listarClientesDireccionesVirtuales(Ini,Fin, cfg,conn),cfg);
	}
}