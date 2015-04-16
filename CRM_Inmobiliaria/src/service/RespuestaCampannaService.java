package service;

import archivos.ArchivoRespuestaCampanna;
import dao.RespuestaCampannaDAO;

public class RespuestaCampannaService {
	private ArchivoRespuestaCampanna file = new ArchivoRespuestaCampanna();

	public void consultarRespuestasCampannas(String Ini,String Fin) {
		RespuestaCampannaDAO cld = new RespuestaCampannaDAO();
		file.archivarRespuestasCampannas(cld.listarRespuestasCampannas(Ini,Fin));
		file.archivarRespuestasCampannasCtl(cld.listarRespuestasCampannasCtl(Ini,Fin));
	}
}
