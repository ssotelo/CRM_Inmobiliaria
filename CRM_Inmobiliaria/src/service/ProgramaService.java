package service;

import java.sql.Connection;

import archivos.ArchivoPrograma;
import dao.ProgramaDAO;

public class ProgramaService {
	private ArchivoPrograma file = new ArchivoPrograma();

	public void consultarProgramas(String Ini,String Fin, String cfg, Connection conn) {
		ProgramaDAO pgm = new ProgramaDAO();
		file.archivarProgramas(pgm.listarProgramas(Ini,Fin,cfg,conn),cfg);
	}
}