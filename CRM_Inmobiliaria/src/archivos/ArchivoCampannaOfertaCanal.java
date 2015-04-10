package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.CampannaOfertaCanal;

public class ArchivoCampannaOfertaCanal {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarCampannasOfertasCanales(List<CampannaOfertaCanal> cof) {

		outFileDat = "C:/apps/eilcis_sieb_mktcampofertacanal."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktcampofertacanal."
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
			for (CampannaOfertaCanal ccof : cof) {
				System.out.println(ccof);
				salidaDat.write(ccof.getOfertaId());
				salidaDat.write(ccof.getTratamientoId());
				salidaDat.write(ccof.getCampanaId());
				salidaDat.write(ccof.getAprobacion());
				salidaDat.write(ccof.getCosto());
				salidaDat.write(ccof.getFecIniChnl());
				salidaDat.write(ccof.getFecFinChnl());
				salidaDat.write(ccof.getFecUltAct());
				salidaDat.write(ccof.getTratamientoNum());
				salidaDat.write(ccof.getTratamientoName());
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
