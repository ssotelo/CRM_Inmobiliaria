package presentacion;

import service.CampannaService;

public class acceso {
	public static void main(String[] args) {
		CampannaService service = new CampannaService();
		service.consultarCampannas();
	}
}