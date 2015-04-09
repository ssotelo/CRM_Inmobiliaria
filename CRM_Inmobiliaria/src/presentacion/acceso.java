package presentacion;

import service.ClienteService;

public class acceso {
	public static void main(String[] args) {
		ClienteService service = new ClienteService();
		service.consultarClientes();
	}
}