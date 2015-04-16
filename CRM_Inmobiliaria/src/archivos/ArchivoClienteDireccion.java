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

import domain.ClienteDireccion;

public class ArchivoClienteDireccion {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String ruta = null;
	
	public void archivarClienteDireccion(List<ClienteDireccion> cd, String cfg) {
	
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			ruta = prop.getProperty("LOCAL_DIR");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		outFileDat = "eilcis_sieb_clientedirecc."
				+ formateador.format(now) + ".dat";
		outFileCif = "eilcis_sieb_clientedirecc."
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
			for (ClienteDireccion ccd : cd) {
				salidaDat.write(ccd.getPersonId());
				salidaDat.write(ccd.getAddressId());
				salidaDat.write(ccd.getCalle());
				salidaDat.write(ccd.getNumExt());
				salidaDat.write(ccd.getNumInt());
				salidaDat.write(ccd.getEdif());
				salidaDat.write(ccd.getCodpos());
				salidaDat.write(ccd.getColonia());
				salidaDat.write(ccd.getMunicipio());
				salidaDat.write(ccd.getEstado());
				salidaDat.write(ccd.getPais());
				salidaDat.write(ccd.getFecUltAct());
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
}