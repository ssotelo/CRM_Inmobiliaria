package service;

import java.sql.Connection;

import archivos.ArchivoRegion;
import dao.RegionDAO;

public class RegionService {
	private ArchivoRegion file = new ArchivoRegion();

	public void consultarRegiones(String Ini,String Fin, String cfg, Connection conn) {
		RegionDAO cgd = new RegionDAO();
		file.archivarRegiones(cgd.listarRegiones(Ini,Fin,cfg,conn),cfg);
	}
}
