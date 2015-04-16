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
	private String outFileCtl = "";
 
	public void archivarCampannasOfertasCanales(List<CampannaOfertaCanal> cof, String cfg) {
		String ruta = "C:/apps/";
		outFileDat = "eilcis_sieb_mktcampofertacanal."
				+ formateador.format(now) + ".dat";
		outFileCif = "eilcis_sieb_mktcampofertacanal."
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
			for (CampannaOfertaCanal ccof : cof) {
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
			System.out.println(outFileDat);
			System.out.println(outFileCif);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void archivarCampannasOfertasCanalesCtl(List<CampannaOfertaCanal> cof, String cfg) {
		String ruta = "C:/apps/";
		outFileCtl = "eilcis_sieb_mktcampofertacanal."
				+ formateador.format(now) + ".ctl";
		boolean alreadyExists = new File(ruta + outFileCtl).exists();
		if (alreadyExists) {
			File ficheroControl = new File(ruta + outFileCtl);
			ficheroControl.delete();
		}
		try {

			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(ruta + outFileCtl, true), '^');
			for (CampannaOfertaCanal ccof : cof) {
				salidaCtl.write(ccof.getFecToday());
				salidaCtl.write(ccof.getFecUltAct());
				salidaCtl.write(ccof.getTotCampOffrCan());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
			System.out.println(outFileCtl);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}