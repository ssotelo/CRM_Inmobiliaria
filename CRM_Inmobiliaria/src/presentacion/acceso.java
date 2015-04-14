package presentacion;

import service.PlanService;

public class acceso {
	public static void main(String[] args) {
		PlanService service = new PlanService();
		service.consultarPlanes();
	}
}