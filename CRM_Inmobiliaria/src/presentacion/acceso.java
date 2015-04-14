package presentacion;

import service.RespuestaCampannaService;

public class acceso {
	public static void main(String[] args) {
		RespuestaCampannaService service = new RespuestaCampannaService();
		service.consultarRespuestasCampannas();
	}
}