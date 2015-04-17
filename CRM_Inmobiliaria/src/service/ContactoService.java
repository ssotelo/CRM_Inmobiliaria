package service;

import java.sql.Connection;

import archivos.ArchivoContacto;
import dao.ContactoDAO;

public class ContactoService {
	private ArchivoContacto file = new ArchivoContacto();

	public void consultarContactos(String Ini,String Fin, String cfg, Connection conn) {
		ContactoDAO cgd = new ContactoDAO();
		file.archivarContactos(cgd.listarContactos(Ini,Fin,cfg,conn),cfg);
		file.archivarContactosCtl(cgd.listarContactosCtl(Ini,Fin,cfg,conn),cfg);
	}
}
