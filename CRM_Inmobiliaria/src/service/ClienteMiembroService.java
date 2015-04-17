package service;

import java.sql.Connection;

import archivos.ArchivoClienteMiembro;
import dao.ClienteMiembroDAO;

public class ClienteMiembroService {
	private ArchivoClienteMiembro file = new ArchivoClienteMiembro();

	public void consultarClientesMiembros(String Ini,String Fin, String cfg, Connection conn) {
		ClienteMiembroDAO cmd = new ClienteMiembroDAO();
		file.archivarClientesMiembros(cmd.listarClientesMiembros(Ini,Fin, cfg,conn),cfg);
	}
}
