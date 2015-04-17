package service;

import java.sql.Connection;

import archivos.ArchivoDireccion;
import dao.DireccionDAO;

public class DireccionService {
	private ArchivoDireccion file = new ArchivoDireccion();

	public void consultarDirecciones(String Ini,String Fin, String cfg, Connection conn) {
		DireccionDAO cgd = new DireccionDAO();
		file.archivarDirecciones(cgd.listarDirecciones(Ini,Fin,cfg,conn),cfg);
	}
}
