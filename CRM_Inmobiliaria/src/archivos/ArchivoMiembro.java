package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Miembro;

public class ArchivoMiembro {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";

	public void archivarMiembros(List<Miembro> mem) {
		String ruta = "C:/apps/";
		outFileDat = "eilcis_sieb_miembro." + formateador.format(now)
				+ ".dat";
		outFileCif = "eilcis_sieb_miembro." + formateador.format(now)
				+ ".cif";
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
			for (Miembro cat : mem) {
				salidaDat.write(cat.getRowId());
				salidaDat.write(cat.getProgramId());
				salidaDat.write(cat.getPersonId());
				salidaDat.write(cat.getTipoAcumulacion());
				salidaDat.write(cat.getCanalAlta());
				salidaDat.write(cat.getFecAlta());
				salidaDat.write(cat.getFecExp());
				salidaDat.write(cat.getFecCan());
				salidaDat.write(cat.getNumMem());
				salidaDat.write(cat.getTipMem());
				salidaDat.write(cat.getStatusMiembro());
				salidaDat.write(cat.getCodigoEsquema());
				salidaDat.write(Double.toString(cat.getPuntuacion()));
				salidaDat.write(Double.toString(cat.getPuntuacionA()));
				salidaDat.write(Double.toString(cat.getPuntuacionB()));
				salidaDat.write(Double.toString(cat.getPuntuacionC()));
				salidaDat.write(Double.toString(cat.getPuntuacionD()));
				salidaDat.write(Double.toString(cat.getCentroComercial()));
				salidaDat.write(cat.getFecUltAct());
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
	
	public void archivarMiembrosCtl(List<Miembro> memctl) {
		String ruta = "C:/apps/";
		outFileCtl = "eilcis_sieb_miembro." + formateador.format(now)
				+ ".ctl";
		boolean alreadyExists = new File(ruta + outFileCtl).exists();
		alreadyExists = new File(ruta + outFileCtl).exists();
		if (alreadyExists) {
			File ficheroControl = new File(ruta + outFileCtl);
			ficheroControl.delete();
		}
		try {
			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(ruta + outFileCtl, true), '^');
			for (Miembro cat : memctl) {
				salidaCtl.write(cat.getFecToday());
				salidaCtl.write(cat.getFecUltAct());
				salidaCtl.write(cat.getProgramId());
				salidaCtl.write(cat.getTotMiembros());
				salidaCtl.write(cat.getTotPuntos());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
			System.out.println(outFileCtl);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}