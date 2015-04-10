package service;

import archivos.ArchivoRespuestaCampanna;
import dao.RespuestaCampannaDAO;

public class RespuestaCampannaService {
	private ArchivoRespuestaCampanna file = new ArchivoRespuestaCampanna();

	public void consultarRespuestasCampannas() {
		RespuestaCampannaDAO cld = new RespuestaCampannaDAO();
		file.archivarRespuestasCampannas(cld.listarRespuestasCampannas());
	}
}