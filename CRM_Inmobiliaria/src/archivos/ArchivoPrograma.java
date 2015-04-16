package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Programa;

public class ArchivoPrograma {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarProgramas(List<Programa> pgm) {
		String ruta = "C:/apps/";
		outFileDat = "eildim_sieb_programalealtad."
				+ formateador.format(now) + ".dat";
		outFileCif = "eildim_sieb_programalealtad."
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
			for (Programa cpgm : pgm) {
				salidaDat.write(cpgm.getRowId());
				salidaDat.write(cpgm.getNombre());
				salidaDat.write(cpgm.getDescripcion());
				salidaDat.write(cpgm.getInicioPrograma());
				salidaDat.write(cpgm.getFinPrograma());
				salidaDat.write(cpgm.getInicioTransferencia());
				salidaDat.write(cpgm.getInicioCompra());
				salidaDat.write(cpgm.getCrecimientoPuntos());
				salidaDat.write(cpgm.getVencimientoPuntos());
				salidaDat.write(cpgm.getReglaCalculo());
				salidaDat.write(cpgm.getReconocimientoBono());
				salidaDat.write(cpgm.getActiveFlag());
				salidaDat.write(cpgm.getConversionPuntos());
				salidaDat.write(cpgm.getSocioFlag());
				salidaDat.write(cpgm.getNombreSocio());
				salidaDat.write(cpgm.getCodOrganizacion());
				salidaDat.write(cpgm.getUltActualizacion());
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