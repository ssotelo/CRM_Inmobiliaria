package service;

import archivos.ArchivoTarjeta;
import dao.TarjetaDAO;


public class TarjetaService {
	private ArchivoTarjeta file = new ArchivoTarjeta();

	public void consultarTarjetas() {
		TarjetaDAO cgd = new TarjetaDAO();
		file.archivarTarjetas(cgd.listarTarjetas());
	}
}
