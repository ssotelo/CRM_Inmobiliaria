package presentacion;

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

public class acceso {
	public static void main(String[] args) {
		String FIni = "20150201";//args[0];
		String Ffin = "20151231";//args[1];
		String cfg = "C:/Users/Wendy/workspace/config.cfg";//args[2];
		 
		CampannaListaCanalService service01 = new CampannaListaCanalService();
		service01.consultarCampannaListaCanal(FIni,Ffin,cfg);
		
		CampannaListaService service02 = new CampannaListaService();
		service02.consultarCampannasListas(FIni,Ffin,cfg);
		
		CampannaOfertaCanalService service03 = new CampannaOfertaCanalService();
		service03.consultarCampannasOfertasCanales(FIni,Ffin,cfg);

		CampannaOfertaService service04 = new CampannaOfertaService();
		service04.consultarCampannaOferta(FIni,Ffin,cfg);

		CampannaService service05 = new CampannaService();
		service05.consultarCampannas(FIni,Ffin,cfg);

		CampannaTiendaService service06 = new CampannaTiendaService();
		service06.consultarCampannasTiendas(FIni,Ffin,cfg);

		CatalogoGeneralService service07 = new CatalogoGeneralService();
		service07.consultarCatalogosGenerales(FIni,Ffin,cfg);
		
		CentroComercialService service08 = new CentroComercialService();
		service08.consultarCentrosComerciales(FIni,Ffin,cfg);
		
		ClienteDireccionService service09 = new ClienteDireccionService();
		service09.consultarClientesDireccion(FIni,Ffin,cfg);
		
		ClienteDireccionVirtualService service10 = new ClienteDireccionVirtualService();
		service10.consultarClientesDireccionesVirtuales(FIni,Ffin,cfg);
		
		ClienteMiembroService service11 = new ClienteMiembroService();
		service11.consultarClientesMiembros(FIni,Ffin,cfg);
		
		ClienteService service12 = new ClienteService();
		service12.consultarClientes(FIni,Ffin,cfg);
		
		ClienteTelefonoService service13 = new ClienteTelefonoService();
		service13.consultarClientetelefono(FIni,Ffin,cfg);

		CompetenciaService service14 = new CompetenciaService();
		service14.consultarCompetencias(FIni,Ffin,cfg);

		ContactoService service15 = new ContactoService();
		service15.consultarContactos(FIni,Ffin,cfg);

		DireccionService service16 = new DireccionService();
		service16.consultarDirecciones(FIni,Ffin,cfg);

		ListaContactoService service17 = new ListaContactoService();
		service17.consultarListasContactos(FIni,Ffin,cfg);

		ListaService service18 = new ListaService();
		service18.consultarListas(FIni,Ffin,cfg);
		
		MiembroService service19 = new MiembroService();
		service19.consultarMiembros(FIni,Ffin,cfg);

		OfertaService service20 = new OfertaService();
		service20.consultarOfertas(FIni,Ffin,cfg);
		
		PlanService service21 = new PlanService();
		service21.consultarPlanes(FIni,Ffin,cfg);
		
		ProgramaService service22 = new ProgramaService();
		service22.consultarProgramas(FIni,Ffin,cfg);
		
		RegionService service23 = new RegionService();
		service23.consultarRegiones(FIni,Ffin,cfg);
		
		RespuestaCampannaService service24 = new RespuestaCampannaService();
		service24.consultarRespuestasCampannas(FIni,Ffin,cfg);
		
		TarjetaService service25 = new TarjetaService();
		service25.consultarTarjetas(FIni,Ffin,cfg);
	}
}