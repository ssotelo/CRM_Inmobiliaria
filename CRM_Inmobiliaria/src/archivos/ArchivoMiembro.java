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

	public void archivarMiembros(List<Miembro> mem) {
		outFileDat = "C:/apps/eilcis_sieb_miembro." + formateador.format(now)
				+ ".dat";
		outFileCif = "C:/apps/eilcis_sieb_miembro." + formateador.format(now)
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
			for (Miembro cat : mem) {
				System.out.println(mem);
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
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
