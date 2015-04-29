package presentacion;

import java.sql.Connection;
import java.sql.SQLException;

import service.CampannaListaCanalService;
import service.CampannaListaService;
import service.CampannaOfertaCanalService;
import service.CampannaOfertaService;
import service.CampannaService;
import service.CampannaTiendaService;
import service.CatalogoGeneralService;
import service.CentroComercialService;
import service.ClienteDireccionService;
import service.ClienteDireccionVirtualService;
import service.ClienteMiembroService;
import service.ClienteService;
import service.ClienteTelefonoService;
import service.CompetenciaService;
import service.ContactoService;
import service.DireccionService;
import service.ListaContactoService;
import service.ListaService;
import service.MiembroService;
import service.OfertaService;
import service.PlanService;
import service.ProgramaService;
import service.RegionService;
import service.RespuestaCampannaService;
import service.TarjetaService;
import domain.Conexion;

public class acceso {
	public static void main(String[] args) {
		Connection conn = null;
		Connection userConn = null;
		int numArgs = args.length;
    	if (numArgs != 3)
    	{
    		System.out.println("java -jar ExtCRM.jar configFile FechaInicio FechaFin");
    		System.exit(0); 
    	}
		String FIni = args[1];
		String Ffin = args[2];
		String cfg =  args[0];
		try{
			conn = (userConn != null) ? userConn : Conexion.getConnection(cfg);	
			
			CampannaListaCanalService service01 = new CampannaListaCanalService();
			service01.consultarCampannaListaCanal(FIni,Ffin,cfg,conn);
			
			CampannaListaService service02 = new CampannaListaService();
			service02.consultarCampannasListas(FIni,Ffin,cfg,conn);
			
			CampannaOfertaCanalService service03 = new CampannaOfertaCanalService();
			service03.consultarCampannasOfertasCanales(FIni,Ffin,cfg,conn);

			CampannaOfertaService service04 = new CampannaOfertaService();
			service04.consultarCampannaOferta(FIni,Ffin,cfg,conn);
		
			CampannaService service05 = new CampannaService();
			service05.consultarCampannas(FIni,Ffin,cfg,conn);

			CampannaTiendaService service06 = new CampannaTiendaService();
			service06.consultarCampannasTiendas(FIni,Ffin,cfg,conn);

			CatalogoGeneralService service07 = new CatalogoGeneralService();
			service07.consultarCatalogosGenerales(FIni,Ffin,cfg,conn);
			
			CentroComercialService service08 = new CentroComercialService();
			service08.consultarCentrosComerciales(FIni,Ffin,cfg,conn);
			
			ClienteDireccionService service09 = new ClienteDireccionService();
			service09.consultarClientesDireccion(FIni,Ffin,cfg,conn);
			
			ClienteDireccionVirtualService service10 = new ClienteDireccionVirtualService();
			service10.consultarClientesDireccionesVirtuales(FIni,Ffin,cfg,conn);
			
			ClienteMiembroService service11 = new ClienteMiembroService();
			service11.consultarClientesMiembros(FIni,Ffin,cfg,conn);
			
			ClienteService service12 = new ClienteService();
			service12.consultarClientes(FIni,Ffin,cfg,conn);

			ClienteTelefonoService service13 = new ClienteTelefonoService();
			service13.consultarClientetelefono(FIni,Ffin,cfg,conn);
			
			CompetenciaService service14 = new CompetenciaService();
			service14.consultarCompetencias(FIni,Ffin,cfg,conn);

			ContactoService service15 = new ContactoService();
			service15.consultarContactos(FIni,Ffin,cfg,conn);

			DireccionService service16 = new DireccionService();
			service16.consultarDirecciones(FIni,Ffin,cfg,conn);

			ListaContactoService service17 = new ListaContactoService();
			service17.consultarListasContactos(FIni,Ffin,cfg,conn);

			ListaService service18 = new ListaService();
			service18.consultarListas(FIni,Ffin,cfg,conn);
			
			MiembroService service19 = new MiembroService();
			service19.consultarMiembros(FIni,Ffin,cfg,conn);
			
			OfertaService service20 = new OfertaService();
			service20.consultarOfertas(FIni,Ffin,cfg,conn);
			
			PlanService service21 = new PlanService();
			service21.consultarPlanes(FIni,Ffin,cfg,conn);
			
			ProgramaService service22 = new ProgramaService();
			service22.consultarProgramas(FIni,Ffin,cfg,conn);
			
			RegionService service23 = new RegionService();
			service23.consultarRegiones(FIni,Ffin,cfg,conn);
			
			RespuestaCampannaService service24 = new RespuestaCampannaService();
			service24.consultarRespuestasCampannas(FIni,Ffin,cfg,conn);
			
			TarjetaService service25 = new TarjetaService();
			service25.consultarTarjetas(FIni,Ffin,cfg,conn);
			
			conn.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}