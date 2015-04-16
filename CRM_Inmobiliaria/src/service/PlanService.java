package service;

import archivos.ArchivoPlan;
import dao.PlanDAO;

public class PlanService {
	private ArchivoPlan file = new ArchivoPlan();

	public void consultarPlanes(String Ini,String Fin, String cfg) {
		PlanDAO cgd = new PlanDAO();
		file.archivarPlanes(cgd.listarPlanes(Ini,Fin,cfg),cfg);
		file.archivarPlanesCtl(cgd.listarPlanesCtl(Ini,Fin,cfg),cfg);
	}
}
