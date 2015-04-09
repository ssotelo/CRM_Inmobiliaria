package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

import domain.CampannaOferta;

public class ArchivoCampannaOferta {
	private Date now = new Date();
	private SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	private long cif = 0;
	private String outFileDat = "";
	private String outFileCif = "";

	public void archivarCampannasOfertas(List<CampannaOferta> co) {
		
		outFileDat = "C:/apps/eilcis_sieb_mktcampanaoferta."+formateador.format(now)+".dat";
		outFileCif = "C:/apps/eilcis_sieb_mktcampanaoferta."+formateador.format(now)+".cif";
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
        	for(CampannaOferta cat : co){
            	System.out.println(co);
            	salidaDat.write(cat.getCampannaId());
            	salidaDat.write(cat.getOfertaId());
            	salidaDat.write(cat.getProducto());
            	salidaDat.write(cat.getMarca());
            	salidaDat.write(cat.getGrupo());
            	salidaDat.write(cat.getSeccion());
            	salidaDat.write(cat.getDivision());
            	salidaDat.write(cat.getExcProducto());
            	salidaDat.write(cat.getExcMarca());
            	salidaDat.write(cat.getExcGrupo());
            	salidaDat.write(cat.getExcSeccion());
            	salidaDat.write(cat.getExcDivision());
            	salidaDat.write(cat.getFecIniOfer());
            	salidaDat.write(cat.getFecUltAct());
            	salidaDat.write(cat.getTratamientoId());
            	salidaDat.write(cat.getTratamientoName());
            	salidaDat.write(cat.getCodLivTrat());
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
