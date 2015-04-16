package service;

import archivos.ArchivoRegion;
import dao.RegionDAO;

public class RegionService {
	private ArchivoRegion file = new ArchivoRegion();

	public void consultarRegiones(String Ini,String Fin) {
		RegionDAO cgd = new RegionDAO();
		file.archivarRegiones(cgd.listarRegiones(Ini,Fin));
	}
}
