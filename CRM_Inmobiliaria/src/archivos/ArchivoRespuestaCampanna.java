package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.RespuestaCampanna;

public class ArchivoRespuestaCampanna {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarRespuestasCampannas(List<RespuestaCampanna> rcam) {
		outFileDat = "C:/apps/eilcis_sieb_mktrespuestacampana."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktrespuestacampana."
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
			for (RespuestaCampanna crcam : rcam) {
				System.out.println(rcam);
				salidaDat.write(crcam.getCampannaId());
				salidaDat.write(crcam.getOfertaId());
				salidaDat.write(crcam.getTratamientoId());
				salidaDat.write(crcam.getClienteId());
				salidaDat.write(crcam.getListaId());
				salidaDat.write(crcam.getRespuestaId());
				salidaDat.write(crcam.getMetodoRespuesta());
				salidaDat.write(crcam.getBoleta());
				salidaDat.write(crcam.getFecUltAct());
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