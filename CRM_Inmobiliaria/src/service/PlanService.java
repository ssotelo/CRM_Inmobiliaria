package service;

import archivos.ArchivoPlan;
import dao.PlanDAO;

public class PlanService {
	private ArchivoPlan file = new ArchivoPlan();

	public void consultarPlanes() {
		PlanDAO cgd = new PlanDAO();
		file.archivarPlanes(cgd.listarPlanes());
		file.archivarPlanesCtl(cgd.listarPlanesCtl());
	}
}
