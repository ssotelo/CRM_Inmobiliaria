package service;

import java.sql.Connection;

import archivos.ArchivoTarjeta;
import dao.TarjetaDAO;


public class TarjetaService {
	private ArchivoTarjeta file = new ArchivoTarjeta();

	public void consultarTarjetas(String Ini,String Fin, String cfg, Connection conn) {
		TarjetaDAO cgd = new TarjetaDAO();
		file.archivarTarjetas(cgd.listarTarjetas(Ini,Fin,cfg,conn),cfg);
	}
}
