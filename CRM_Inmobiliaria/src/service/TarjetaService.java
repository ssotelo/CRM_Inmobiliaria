package service;

import archivos.ArchivoTarjeta;
import dao.TarjetaDAO;


public class TarjetaService {
	private ArchivoTarjeta file = new ArchivoTarjeta();

	public void consultarTarjetas(String Ini,String Fin) {
		TarjetaDAO cgd = new TarjetaDAO();
		file.archivarTarjetas(cgd.listarTarjetas(Ini,Fin));
	}
}
