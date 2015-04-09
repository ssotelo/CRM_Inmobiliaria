package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.ClienteDireccion;

public class ArchivoClienteDireccion {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
/* Hola LEE*/
	/*Hola de nuevo lee*/
	//hola
	public void archivarClienteDireccion(List<ClienteDireccion> cd) {
		outFileDat = "C:/apps/eilcis_sieb_clientedirecc."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_clientedirecc."
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
			for (ClienteDireccion ccd : cd) {
				System.out.println(ccd.getPersonId() + "^" + ccd.getAddressId()
						+ "^" + ccd.getCalle() + "^" + ccd.getNumExt() + "^"
						+ ccd.getNumInt() + "^" + ccd.getEdif() + "^"
						+ ccd.getCodpos() + "^" + ccd.getColonia() + "^"
						+ ccd.getMunicipio() + "^" + ccd.getEstado() + "^"
						+ ccd.getPais() + "^" + ccd.getFecUltAct());
				salidaDat.write(ccd.getPersonId());
				salidaDat.write(ccd.getAddressId());
				salidaDat.write(ccd.getCalle());
				salidaDat.write(ccd.getNumExt());
				salidaDat.write(ccd.getNumInt());
				salidaDat.write(ccd.getEdif());
				salidaDat.write(ccd.getCodpos());
				salidaDat.write(ccd.getColonia());
				salidaDat.write(ccd.getMunicipio());
				salidaDat.write(ccd.getEstado());
				salidaDat.write(ccd.getPais());
				salidaDat.write(ccd.getFecUltAct());
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
