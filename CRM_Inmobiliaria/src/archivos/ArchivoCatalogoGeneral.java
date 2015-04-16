package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.CatalogoGeneral;

public class ArchivoCatalogoGeneral {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarCatalogosGenerales(List<CatalogoGeneral> cg, String cfg) {
		String ruta = "C:/apps/";
		outFileDat = "eilcis_sieb_crmcatgeneral."
				+ formateador.format(now) + ".dat";
		outFileCif = "eilcis_sieb_crmcatgeneral."
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
			for (CatalogoGeneral cat : cg) {
				salidaDat.write(cat.getRowId());
				salidaDat.write(cat.getParRowId());
				salidaDat.write(cat.getType());
				salidaDat.write(cat.getSubtype());
				salidaDat.write(cat.getVal());
				salidaDat.write(cat.getName());
				salidaDat.write(cat.getDescripcion());
				salidaDat.write(Integer.toString(cat.getOrden()));
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
}