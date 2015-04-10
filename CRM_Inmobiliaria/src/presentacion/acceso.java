package presentacion;

import service.DireccionService;

public class acceso {
	public static void main(String[] args) {
		DireccionService service = new DireccionService();
		service.consultarDirecciones();
	}
}