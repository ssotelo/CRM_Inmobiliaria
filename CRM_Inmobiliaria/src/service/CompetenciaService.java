package service;

import archivos.ArchivoCompetencia;
import dao.CompetenciaDAO;

public class CompetenciaService {
	private ArchivoCompetencia file = new ArchivoCompetencia();

	public void consultarCompetencias(String Ini,String Fin) {
		CompetenciaDAO compt = new CompetenciaDAO();
		file.archivarCompetencias(compt.listarCompetencias(Ini,Fin));
	}
}
