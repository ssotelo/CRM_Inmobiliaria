package service;

import java.sql.Connection;

import archivos.ArchivoCliente;
import dao.ClienteDAO;

public class ClienteService {
	private ArchivoCliente file = new ArchivoCliente();

	public void consultarClientes(String Ini,String Fin, String cfg, Connection conn) {
		ClienteDAO cld = new ClienteDAO();
		file.archivarClientes(cld.listarClientes(Ini,Fin, cfg,conn),cfg);
		file.archivarClientesCTL(cld.listarClientesCtl(Ini,Fin,cfg,conn),cfg);
	}
}
