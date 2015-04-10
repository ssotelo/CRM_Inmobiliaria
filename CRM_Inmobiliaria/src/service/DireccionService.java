package service;

import archivos.ArchivoDireccion;
import dao.DireccionDAO;

public class DireccionService {
	private ArchivoDireccion file = new ArchivoDireccion();

	public void consultarDirecciones() {
		DireccionDAO cgd = new DireccionDAO();
		file.archivarDirecciones(cgd.listarDirecciones());
	}
}
