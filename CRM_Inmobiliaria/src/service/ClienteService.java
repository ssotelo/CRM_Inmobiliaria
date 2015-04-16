package service;

import archivos.ArchivoCliente;
import dao.ClienteDAO;

public class ClienteService {
	private ArchivoCliente file = new ArchivoCliente();

	public void consultarClientes(String Ini,String Fin) {
		ClienteDAO cld = new ClienteDAO();
		file.archivarClientes(cld.listarClientes(Ini,Fin));
		file.archivarClientesCTL(cld.listarClientesCtl(Ini,Fin));
	}
}
