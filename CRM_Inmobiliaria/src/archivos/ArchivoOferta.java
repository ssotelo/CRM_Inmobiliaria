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

import domain.Oferta;

public class ArchivoOferta {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";
	private String ruta = null;
	
	public void archivarOfertas(List<Oferta> ofe, String cfg) {
	
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			ruta = prop.getProperty("LOCAL_DIR");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		outFileDat = "eilcis_sieb_mktoferta."
				+ formateador.format(now) + ".dat";
		outFileCif = "eilcis_sieb_mktoferta."
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
			for (Oferta cofe : ofe) {
				salidaDat.write(cofe.getRowId());
				salidaDat.write(cofe.getTipo());
				salidaDat.write(cofe.getNombre());
				salidaDat.write(cofe.getDescripcion());
				salidaDat.write(cofe.getAprobacion());
				salidaDat.write(cofe.getFecIniOfr());
				salidaDat.write(cofe.getFecFinOfr());
				salidaDat.write(cofe.getFecUltAct());
				salidaDat.write(cofe.getCodOfer());
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
	
	public void archivarOfertasCtl(List<Oferta> ofe, String cfg) {
		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			ruta = prop.getProperty("LOCAL_DIR");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		outFileCtl = "eilcis_sieb_mktoferta."
				+ formateador.format(now) + ".ctl";
		boolean alreadyExists = new File(ruta + outFileCtl).exists();
		if (alreadyExists) {
			File ficheroControl = new File(ruta + outFileCtl);
			ficheroControl.delete();
		}
		try {
			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(ruta + outFileCtl, true), '^');
			for (Oferta cofe : ofe) {
				salidaCtl.write(cofe.getFecToday());
				salidaCtl.write(cofe.getFecUltAct());
				salidaCtl.write(cofe.getTotOfertas());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
			System.out.println(outFileCtl);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}