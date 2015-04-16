package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Cliente;
import domain.ConnSftp;

public class ArchivoCliente {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	private String outFileCtl = "";

	public void archivarClientes(List<Cliente> cli) {
		String ruta = "C:/apps/";
		outFileDat = "eilcis_sieb_clientes." + formateador.format(now)
				+ ".dat";
		outFileCif = "eilcis_sieb_clientes." + formateador.format(now)
				+ ".cif";
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
			for (Cliente ccli : cli) {
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
			System.out.println(outFileDat);
			System.out.println(outFileCif);
			
			ConnSftp consftp = new  ConnSftp();
			System.out.println("archivo outFile"+ outFileDat);
		consftp.conexionSftp(outFileDat,outFileDat);
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void archivarClientesCTL(List<Cliente> clictl) {
		String ruta = "C:/apps/";
		outFileCtl = "eilcis_sieb_clientes." + formateador.format(now)
				+ ".ctl";
		boolean alreadyExists = new File(ruta + outFileCtl).exists();
		if (alreadyExists) {
			File ficheroDatos = new File(ruta + outFileCtl);
			ficheroDatos.delete();
		}
		try {
			CsvWriter salidaDat = new CsvWriter(
					new FileWriter(ruta + outFileCtl, true), '^');
			for (Cliente ccli : clictl) {
				salidaDat.write(ccli.getFecHoy());
				salidaDat.write(ccli.getUltMod());
				salidaDat.write(ccli.getTotCliente());
				salidaDat.endRecord();
			}
			salidaDat.close();
			System.out.println(outFileCtl);
			
			ConnSftp consftp = new  ConnSftp();
			System.out.println("archivo outFile"+ outFileDat);
		consftp.conexionSftp(outFileDat,outFileDat);
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}