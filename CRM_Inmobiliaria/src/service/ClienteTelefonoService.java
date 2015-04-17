package service;

import java.sql.Connection;

import archivos.ArchivoClienteTelefono;
import dao.ClienteTelefonoDAO;

public class ClienteTelefonoService {
	private ArchivoClienteTelefono file = new ArchivoClienteTelefono();

	public void consultarClientetelefono(String Ini,String Fin, String cfg, Connection conn) {
		ClienteTelefonoDAO ctd = new ClienteTelefonoDAO();
		file.archivarClientetelefono(ctd.listarClientestelefonos(Ini,Fin, cfg,conn),cfg);
	}
}
