package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Tarjeta;

public class ArchivoTarjeta {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";
	
	public void archivarTarjetas(List<Tarjeta> tc) {
		
		outFileDat = "C:/apps/eilcis_sieb_clientetarjcredito."+formateador.format(now)+".dat";
		outFileCif = "C:/apps/eilcis_sieb_clientetarjcredito."+formateador.format(now)+".cif";
		boolean alreadyExists = new File(outFileDat).exists();
        if(alreadyExists){
            File ficheroDatos = new File(outFileDat);
            ficheroDatos.delete();
        } 
        alreadyExists = new File(outFileCif).exists();
        if(alreadyExists){
        	File ficheroCifras = new File(outFileCif);
        	ficheroCifras.delete();
        }
        try{
        	CsvWriter salidaDat = new CsvWriter(new FileWriter(outFileDat, true), '^');
        	CsvWriter salidaCif = new CsvWriter(new FileWriter(outFileCif, true), '^');
        	for(Tarjeta cat : tc){
            	System.out.println(cat.getCodCliente()+"^"+cat.getDescripcion()+"^"+
        	cat.getTarjeta()+"^"+cat.getFecUltAct());
            	
            	salidaDat.write(cat.getCodCliente());
            	salidaDat.write(cat.getDescripcion());
            	salidaDat.write(cat.getTarjeta());
            	salidaDat.write(cat.getFecUltAct());
            	salidaDat.endRecord();
            	cif++;
            }
            salidaDat.close();
            salidaCif.write(outFileDat);
            salidaCif.write(formateador.format(now));
            salidaCif.write(Long.toString(cif));
            salidaCif.close();
        }catch(IOException ioe){
        	ioe.printStackTrace();
        }
	}
}
