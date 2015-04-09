package service;

import archivos.ArchivoRegion;
import dao.RegionDAO;

public class RegionService {
	private ArchivoRegion file = new ArchivoRegion();

	public void consultarRegiones() {
		RegionDAO cgd = new RegionDAO();
		file.archivarRegiones(cgd.listarRegiones());
	}
}
