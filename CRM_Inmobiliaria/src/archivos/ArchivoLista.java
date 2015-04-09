package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Lista;

public class ArchivoLista {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarListas(List<Lista> lst) {
		
		outFileDat = "C:/apps/eildim_sieb_mktlistas."+formateador.format(now)+".dat";
		outFileCif = "C:/apps/eildim_sieb_mktlistas."+formateador.format(now)+".cif";
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
        	for(Lista cat : lst){
            	System.out.println(cat.getRowId()+"^"+cat.getName()+"^"+cat.getDescripcion()+
            			cat.getTipoLista()+"^"+cat.getStatusLista()+"^"+cat.getCodigoDim()+
            			cat.getArchivoImportado()+"^"+cat.getUsuario()+cat.getFecUltAct());            	
            	salidaDat.write(cat.getRowId());
            	salidaDat.write(cat.getName());
            	salidaDat.write(cat.getDescripcion());
            	salidaDat.write(cat.getTipoLista());
            	salidaDat.write(cat.getStatusLista());
            	salidaDat.write(cat.getCodigoDim());
            	salidaDat.write(cat.getArchivoImportado());
            	salidaDat.write(cat.getUsuario());
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
