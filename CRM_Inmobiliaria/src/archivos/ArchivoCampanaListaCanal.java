package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.CampannaListaCanal;

public class ArchivoCampanaListaCanal {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";

	public void archivarCampannasListasCanales(List<CampannaListaCanal> clc) {
		outFileDat = "C:/apps/eilcis_sieb_mktcampanalistacanal."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktcampanalistacanal."
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
			for (CampannaListaCanal cat : clc) {
				System.out.println(cat);

				salidaDat.write(cat.getCampanaId());
				salidaDat.write(cat.getListaId());
				salidaDat.write(cat.getTratamientoId());
				salidaDat.write(cat.getFecIniCam());
				salidaDat.write(cat.getFecFinCam());
				salidaDat.write(cat.getFecUltAct());
				salidaDat.write(cat.getTratamientoNum());
				salidaDat.write(cat.getTratamientoName());
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

	public void archivarCampannasListasCanalesCtl(List<CampannaListaCanal> clc) {
		outFileCtl = "C:/apps/eilcis_sieb_mktcampanalistacanal."
				+ formateador.format(now) + ".ctl";
		boolean alreadyExists = new File(outFileCtl).exists();
		if (alreadyExists) {
			File ficheroCtl = new File(outFileCtl);
			ficheroCtl.delete();
		}
		try {
			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(outFileCtl, true), '^');
			for (CampannaListaCanal cat : clc) {
				salidaCtl.write(cat.getFecToday());
				salidaCtl.write(cat.getFecUltAct());
				salidaCtl.write(cat.getTotCampListCan());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
