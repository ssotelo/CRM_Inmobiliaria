package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Oferta;

public class ArchivoOferta {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarOfertas(List<Oferta> ofe) {
		outFileDat = "C:/apps/eilcis_sieb_ mktoferta."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_ mktoferta."
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
			for (Oferta cofe : ofe) {
				System.out.println(ofe);
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
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
