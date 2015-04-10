package service;

import archivos.ArchivoRespuestaCampanna;
import dao.RespuestaCampannaDAO;

public class RespuestaCammpanaService {
	private ArchivoRespuestaCampanna file = new ArchivoRespuestaCampanna();

	public void consultarRespuestasCampannas() {
		RespuestaCampannaDAO cld = new RespuestaCampannaDAO();
		file.archivarRespuestasCampannas(cld.listarRespuestasCampannas());
	}
}
