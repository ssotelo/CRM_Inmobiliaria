package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.ListaContacto;

public class ArchivoListaContacto {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";

	public void archivarListasContactos(List<ListaContacto> lcnt) {
		outFileDat = "C:/apps/eilcis_sieb_mktclientelista."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktclientelista."
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
			for (ListaContacto ccnt : lcnt) {
				System.out.println(ccnt);
				salidaDat.write(ccnt.getContactoId());
				salidaDat.write(ccnt.getListaId());
				salidaDat.write(ccnt.getFecIniCli());
				salidaDat.write(ccnt.getFecFinCli());
				salidaDat.write(ccnt.getFecUltAct());
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
	
	public void archivarListasContactosCtl(List<ListaContacto> lcnt) {
		outFileCtl = "C:/apps/eilcis_sieb_mktclientelista."
				+ formateador.format(now) + ".ctl";
		boolean alreadyExists = new File(outFileCtl).exists();
		if (alreadyExists) {
			File ficheroControl = new File(outFileCtl);
			ficheroControl.delete();
		}
		try {
			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(outFileCtl, true), '^');
			for (ListaContacto ccnt : lcnt) {
				salidaCtl.write(ccnt.getFecToday());
				salidaCtl.write(ccnt.getFecUltAct());
				salidaCtl.write(ccnt.getTotClieLista());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}