package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.csvreader.CsvWriter;

import domain.Contacto;

public class ArchivoContacto {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";
	private String ruta = null;
	
	public void archivarContactos(List<Contacto> cont, String cfg) {
		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			ruta = prop.getProperty("LOCAL_DIR");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		outFileDat = "eilcis_sieb_mktatribcliente."
				+ formateador.format(now) + ".dat";
		outFileCif = "eilcis_sieb_mktatribcliente."
				+ formateador.format(now) + ".cif";
		boolean alreadyExists = new File(ruta + outFileDat).exists();
		if (alreadyExists) {
			File ficheroDatos = new File(ruta + outFileDat);
			ficheroDatos.delete();
		}
		alreadyExists = new File(ruta + outFileCif).exists();
		if (alreadyExists) {
			File ficheroCifras = new File(ruta + outFileCif);
			ficheroCifras.delete();
		}
		try {
			CsvWriter salidaDat = new CsvWriter(
					new FileWriter(ruta + outFileDat, true), '^');
			CsvWriter salidaCif = new CsvWriter(
					new FileWriter(ruta + outFileCif, true), '^');
			for (Contacto cat : cont) {
				salidaDat.write(cat.getRowId());
				salidaDat.write(cat.getRfc());
				salidaDat.write(cat.getCs());
				salidaDat.write(cat.getCazaOferta());
				salidaDat.write(cat.getLealtadDH());
				salidaDat.write(cat.getNoInserto());
				salidaDat.write(cat.getNoSMS());
				salidaDat.write(cat.getNoContactar());
				salidaDat.write(cat.getPromociones());
				salidaDat.write(cat.getEventos());
				salidaDat.write(cat.getAperturas());
				salidaDat.write(cat.getMercado());
				salidaDat.write(cat.getActualizacion());
				salidaDat.write(cat.getActivacion());
				salidaDat.write(cat.getBienvenida());
				salidaDat.write(cat.getCampanna());
				salidaDat.write(cat.getSeguros());
				salidaDat.write(cat.getControl());
				salidaDat.write(cat.getClienteSensible());
				salidaDat.write(cat.getNoLlamar());
				salidaDat.write(cat.getNoEmail());
				salidaDat.write(cat.getNoCorreoPostal());
				salidaDat.write(cat.getFecUltAct());
				salidaDat.endRecord();
				cif++;
			}
			salidaDat.close();
			salidaCif.write(outFileDat);
			salidaCif.write(formateador.format(now));
			salidaCif.write(Long.toString(cif));
			salidaCif.close();
			System.out.println(outFileDat);
			System.out.println(outFileCif);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void archivarContactosCtl(List<Contacto> cont, String cfg) {
		String ruta = "C:/apps/";
		outFileCtl = "eilcis_sieb_mktatribcliente."
				+ formateador.format(now) + ".ctl";
		boolean alreadyExists = new File(ruta + outFileCtl).exists();
		if (alreadyExists) {
			File ficheroDatos = new File(ruta + outFileCtl);
			ficheroDatos.delete();
		}
		try {
			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(ruta + outFileCtl, true), '^');
			for (Contacto cat : cont) {
				salidaCtl.write(cat.getFecToday());
				salidaCtl.write(cat.getFecUltAct());
				salidaCtl.write(cat.getTotContactos());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
			System.out.println(outFileCtl);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}