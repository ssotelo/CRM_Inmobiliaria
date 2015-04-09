package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.Contacto;

public class ArchivoContacto {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarContactos(List<Contacto> cont) {
		
		outFileDat = "C:/apps/eilcis_sieb_mktatribcliente."+formateador.format(now)+".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktatribcliente."+formateador.format(now)+".cif";
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
        	for(Contacto cat : cont){
            	salidaDat.write(cat.getRowId());
            	salidaDat.write(cat.getRfc());
            	salidaDat.write(cat.getCs());
            	salidaDat.write(cat.getCazaOferta());
            	salidaDat.write(cat.getLealtadDH());
            	salidaDat.write(cat.getNoInserto());
            	salidaDat.write(cat.getNoSMS());
            	salidaDat.write(cat.getNoContactar());
            	salidaDat.write(cat.getPromociones());
            	salidaDat.write(cat.getEventos());
            	salidaDat.write(cat.getAperturas());
            	salidaDat.write(cat.getMercado());
            	salidaDat.write(cat.getActualizacion());
            	salidaDat.write(cat.getActivacion());
            	salidaDat.write(cat.getBienvenida());
            	salidaDat.write(cat.getCampanna());
            	salidaDat.write(cat.getSeguros());
            	salidaDat.write(cat.getControl());
            	salidaDat.write(cat.getClienteSensible());
            	salidaDat.write(cat.getNoLlamar());
            	salidaDat.write(cat.getNoEmail());
            	salidaDat.write(cat.getNoCorreoPostal());
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
