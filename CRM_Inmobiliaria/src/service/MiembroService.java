package service;

import java.sql.Connection;

import archivos.ArchivoMiembro;
import dao.MiembroDAO;

public class MiembroService {
	private ArchivoMiembro file = new ArchivoMiembro();

	public void consultarMiembros(String Ini,String Fin, String cfg, Connection conn) {
		MiembroDAO mem = new MiembroDAO();
		file.archivarMiembros(mem.listarMiembros(Ini,Fin,cfg,conn),cfg);
		file.archivarMiembrosCtl(mem.listarMiembrosCtl(Ini,Fin,cfg,conn),cfg);

	}
}
