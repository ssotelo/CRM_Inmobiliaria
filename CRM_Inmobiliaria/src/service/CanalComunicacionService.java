package service;

import archivos.ArchivoCanalComunicacion;
import dao.CanalComunicacionDAO;

public class CanalComunicacionService {
	private ArchivoCanalComunicacion file = new ArchivoCanalComunicacion();

	public void consultarCanalesComunicaciones() {
		CanalComunicacionDAO cgd = new CanalComunicacionDAO();
		file.archivarCanalesComunicacion(cgd.listarCanalesComunicacion());
	}
}
