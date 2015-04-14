package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Lista;

public class ArchivoLista {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";
	
	public void archivarListas(List<Lista> lst) {
		outFileDat = "C:/apps/eildim_sieb_mktlistas." + formateador.format(now)
				+ ".dat";
		outFileCif = "C:/apps/eildim_sieb_mktlistas." + formateador.format(now)
				+ ".cif";
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
			for (Lista cat : lst) {
				System.out.println(cat);
				salidaDat.write(cat.getRowId());
				salidaDat.write(cat.getName());
				salidaDat.write(cat.getDescripcion());
				salidaDat.write(cat.getTipoLista());
				salidaDat.write(cat.getStatusLista());
				salidaDat.write(cat.getCodigoDim());
				salidaDat.write(cat.getArchivoImportado());
				salidaDat.write(cat.getUsuario());
				salidaDat.write(cat.getFecUltAct());
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

	public void archivarListasCtl(List<Lista> lst) {
		outFileCtl = "C:/apps/eildim_sieb_mktlistas." + formateador.format(now)
				+ ".ctl";
		boolean alreadyExists = new File(outFileCtl).exists();
		if (alreadyExists) {
			File ficheroDatos = new File(outFileCtl);
			ficheroDatos.delete();
		}
		try {
			CsvWriter salidaCtl = new CsvWriter(
					new FileWriter(outFileCtl, true), '^');
			for (Lista cat : lst) {
				salidaCtl.write(cat.getFectoday());
				salidaCtl.write(cat.getFecUltAct());
				salidaCtl.write(cat.getTotListas());
				salidaCtl.endRecord();
			}
			salidaCtl.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
