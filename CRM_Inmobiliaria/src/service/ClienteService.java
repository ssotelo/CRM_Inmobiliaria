package service;

import archivos.ArchivoCliente;
import dao.ClienteDAO;

public class ClienteService {
	private ArchivoCliente file = new ArchivoCliente();

	public void consultarClientes() {
		ClienteDAO cld = new ClienteDAO();
		file.archivarClientes(cld.listarClientes());
		file.archivarClientesCTL(cld.listarClientesCtl());
	}
}
