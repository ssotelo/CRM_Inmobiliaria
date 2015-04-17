package service;

import java.sql.Connection;

import archivos.ArchivoPlan;
import dao.PlanDAO;

public class PlanService {
	private ArchivoPlan file = new ArchivoPlan();

	public void consultarPlanes(String Ini,String Fin, String cfg, Connection conn) {
		PlanDAO cgd = new PlanDAO();
		file.archivarPlanes(cgd.listarPlanes(Ini,Fin,cfg,conn),cfg);
		file.archivarPlanesCtl(cgd.listarPlanesCtl(Ini,Fin,cfg,conn),cfg);
	}
}
