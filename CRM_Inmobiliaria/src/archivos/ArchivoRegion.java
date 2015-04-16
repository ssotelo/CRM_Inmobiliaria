package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Region;

public class ArchivoRegion {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarRegiones(List<Region> reg, String cfg) {
		String ruta = "C:/apps/";		
		outFileDat = "eilcis_sieb_mktregion."+formateador.format(now)+".dat";
		outFileCif = "eilcis_sieb_mktregion."+formateador.format(now)+".cif";
		boolean alreadyExists = new File(ruta + outFileDat).exists();
        if(alreadyExists){
            File ficheroDatos = new File(ruta + outFileDat);
            ficheroDatos.delete();
        } 
        alreadyExists = new File(ruta + outFileCif).exists();
        if(alreadyExists){
        	File ficheroCifras = new File(ruta + outFileCif);
        	ficheroCifras.delete();
        }
        try{
        	CsvWriter salidaDat = new CsvWriter(new FileWriter(ruta + outFileDat, true), '^');
        	CsvWriter salidaCif = new CsvWriter(new FileWriter(ruta + outFileCif, true), '^');
        	for(Region cat : reg){
            	salidaDat.write(cat.getRegionId());
            	salidaDat.write(cat.getRegionName());
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
        }catch(IOException ioe){
        	ioe.printStackTrace();
        }
	}
}