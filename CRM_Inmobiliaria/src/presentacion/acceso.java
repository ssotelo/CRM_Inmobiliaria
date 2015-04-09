package presentacion;

import service.RegionService;

public class acceso {
	public static void main(String[] args) {
		RegionService service = new RegionService();
		service.consultarRegiones();
	}
}