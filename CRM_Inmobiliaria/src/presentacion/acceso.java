package presentacion;

import service.TarjetaService;


public class acceso {
	public static void main(String[] args) {
		TarjetaService service = new TarjetaService();
		service.consultarTarjetas();
	}
}