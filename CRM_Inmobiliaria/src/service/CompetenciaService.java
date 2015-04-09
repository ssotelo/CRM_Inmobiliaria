package service;

import archivos.ArchivoCompetencia;
import dao.CompetenciaDAO;

public class CompetenciaService {
	private ArchivoCompetencia file = new ArchivoCompetencia();

	public void consultarCompetencias() {
		CompetenciaDAO compt = new CompetenciaDAO();
		file.archivarCompetencias(compt.listarCompetencias());
	}
}
