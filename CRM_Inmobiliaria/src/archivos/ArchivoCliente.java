package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Cliente;

public class ArchivoCliente {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
//cambioss
	public void archivarClientes(List<Cliente> cli) {
		outFileDat = "C:/apps/eilcis_sieb_clientes."
				+ formateador.format(now) + ".dat";
		outFileCif = "C:/apps/eilcis_sieb_clientes."
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
			for (Cliente ccli : cli) {
				System.out.println(ccli.getRowId() + "^" + ccli.getNombre()
						+ "^" + ccli.getApePaterno() + "^"
						+ ccli.getApeMaterno() + "^" + ccli.getRFC() + "^"
						+ ccli.getGenero() + "^" + ccli.getEstadoCivil() + "^"
						+ ccli.getFecNac() + "^" + ccli.getAltaCliente() + "^"
						+ ccli.getClienteMDM() + "^" + ccli.getUltMod());
				salidaDat.write(ccli.getRowId());
				salidaDat.write(ccli.getNombre());
				salidaDat.write(ccli.getApePaterno());
				salidaDat.write(ccli.getApeMaterno());
				salidaDat.write(ccli.getRFC());
				salidaDat.write(ccli.getGenero());
				salidaDat.write(ccli.getEstadoCivil());
				salidaDat.write(ccli.getFecNac());
				salidaDat.write(ccli.getAltaCliente());
				salidaDat.write(ccli.getUltMod());
				salidaDat.write(ccli.getCodCliente());
				salidaDat.write(ccli.getClienteMDM());
				salidaDat.write(ccli.getAlias());
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