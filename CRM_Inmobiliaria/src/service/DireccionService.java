package service;

import archivos.ArchivoDireccion;
import dao.DireccionDAO;

public class DireccionService {
	private ArchivoDireccion file = new ArchivoDireccion();

	public void consultarDirecciones(String Ini,String Fin, String cfg) {
		DireccionDAO cgd = new DireccionDAO();
		file.archivarDirecciones(cgd.listarDirecciones(Ini,Fin,cfg),cfg);
	}
}
