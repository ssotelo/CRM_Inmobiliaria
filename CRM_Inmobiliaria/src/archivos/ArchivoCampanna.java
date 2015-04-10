package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Campanna;

public class ArchivoCampanna {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarCampannas(List<Campanna> cmp) {
		outFileDat = "C:/apps/eilcis_sieb_mktcampanas."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktcampanas."
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
			for (Campanna ccmp : cmp) {
				System.out.println(cmp);
				salidaDat.write(ccmp.getRowId());
				salidaDat.write(ccmp.getName());
				salidaDat.write(ccmp.getDescripcion());
				salidaDat.write(ccmp.getType());
				salidaDat.write(ccmp.getMktgId());
				salidaDat.write(ccmp.getPrioridad());
				salidaDat.write(ccmp.getCampannaPadre());
				salidaDat.write(ccmp.getStatus());
				salidaDat.write(ccmp.getAprobacion());
				salidaDat.write(ccmp.getPlanMktg());
				salidaDat.write(ccmp.getHashtag());
				salidaDat.write(ccmp.getFecIniCam());
				salidaDat.write(ccmp.getFecFinCam());
				salidaDat.write(ccmp.getPresupuesto());
				salidaDat.write(ccmp.getUsuario());
				salidaDat.write(ccmp.getFecUltAct());
				salidaDat.write(ccmp.getCodCampanna());
				salidaDat.write(ccmp.getCodLivCamp());

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
