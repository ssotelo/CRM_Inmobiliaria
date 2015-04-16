package service;

import archivos.ArchivoTarjeta;
import dao.TarjetaDAO;


public class TarjetaService {
	private ArchivoTarjeta file = new ArchivoTarjeta();

	public void consultarTarjetas(String Ini,String Fin, String cfg) {
		TarjetaDAO cgd = new TarjetaDAO();
		file.archivarTarjetas(cgd.listarTarjetas(Ini,Fin,cfg),cfg);
	}
}
