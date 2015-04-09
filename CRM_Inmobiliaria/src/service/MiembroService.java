package service;

import archivos.ArchivoMiembro;
import dao.MiembroDAO;

public class MiembroService {
	private ArchivoMiembro file = new ArchivoMiembro();

	public void consultarMiembros() {
		MiembroDAO mem = new MiembroDAO();
		file.archivarMiembros(mem.listarMiembros());
	}
}
