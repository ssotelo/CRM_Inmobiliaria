package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.CentroComercial;

public class ArchivoCentroComercial {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarCentrosComerciales(List<CentroComercial> cc) {
		outFileDat = "C:/apps/eilcis_sieb_centrocomercial."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_centrocomercial."
				+ formateador.format(now) + ".cif";
		boolean alreadyExists = new File(outFileDat).exists();
		if (alreadyExists) {
			File ficheroDatos = new File(outFileDat);
			ficheroDatos.delete();
		}
		alreadyExists = new File(outFileCif).exists();
		if (alreadyExists) {
			File ficheroCifras = new File(outFileCif);
			ficheroCifras.delete();
		}
		try {
			CsvWriter salidaDat = new CsvWriter(
					new FileWriter(outFileDat, true), '^');
			CsvWriter salidaCif = new CsvWriter(
					new FileWriter(outFileCif, true), '^');
			for (CentroComercial cat : cc) {
				System.out.println(cat);
				salidaDat.write(cat.getCodCentroComercial());
				salidaDat.write(cat.getName());
				salidaDat.write(cat.getColonia());
				salidaDat.write(cat.getCiudad());
				salidaDat.write(cat.getPais());
				salidaDat.write(cat.getEstado());
				salidaDat.write(cat.getMunicipio());
				salidaDat.write(cat.getFecApertura());
				salidaDat.write(cat.getFacebook());
				salidaDat.write(cat.getTwitter());

				salidaDat.endRecord();
				cif++;
			}
			salidaDat.close();
			salidaCif.write(outFileDat);
			salidaCif.write(formateador.format(now));
			salidaCif.write(Long.toString(cif));
			salidaCif.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}