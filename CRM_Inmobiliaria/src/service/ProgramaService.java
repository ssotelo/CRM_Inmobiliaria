package service;

import archivos.ArchivoPrograma;
import dao.ProgramaDAO;

public class ProgramaService {
	private ArchivoPrograma file = new ArchivoPrograma();

	public void consultarProgramas(String Ini,String Fin) {
		ProgramaDAO pgm = new ProgramaDAO();
		file.archivarProgramas(pgm.listarProgramas(Ini,Fin));
	}
}