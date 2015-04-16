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
		CampannaListaCanalService service01 = new CampannaListaCanalService();
		service01.consultarCampannaListaCanal("20140101","20151231");
		
		CampannaListaService service02 = new CampannaListaService();
		service02.consultarCampannasListas("20140101","20151231");
		
		CampannaOfertaCanalService service03 = new CampannaOfertaCanalService();
		service03.consultarCampannasOfertasCanales("20140101","20151231");

		CampannaOfertaService service04 = new CampannaOfertaService();
		service04.consultarCampannaOferta("20140101","20151231");

		CampannaService service05 = new CampannaService();
		service05.consultarCampannas("20140101","20151231");

		CampannaTiendaService service06 = new CampannaTiendaService();
		service06.consultarCampannasTiendas("20140101","20151231");

		CatalogoGeneralService service07 = new CatalogoGeneralService();
		service07.consultarCatalogosGenerales("20140101","20151231");
		
		CentroComercialService service08 = new CentroComercialService();
		service08.consultarCentrosComerciales("20140101","20151231");
		
		ClienteDireccionService service09 = new ClienteDireccionService();
		service09.consultarClientesDireccion("20140101","20151231");
		
		ClienteDireccionVirtualService service10 = new ClienteDireccionVirtualService();
		service10.consultarClientesDireccionesVirtuales("20140101","20151231");
		
		ClienteMiembroService service11 = new ClienteMiembroService();
		service11.consultarClientesMiembros("20140101","20151231");
		
		ClienteService service12 = new ClienteService();
		service12.consultarClientes("20140101","20151231");
		
		ClienteTelefonoService service13 = new ClienteTelefonoService();
		service13.consultarClientetelefono("20140101","20151231");

		CompetenciaService service14 = new CompetenciaService();
		service14.consultarCompetencias("20140101","20151231");

		ContactoService service15 = new ContactoService();
		service15.consultarContactos("20140101","20151231");

		DireccionService service16 = new DireccionService();
		service16.consultarDirecciones("20140101","20151231");

		ListaContactoService service17 = new ListaContactoService();
		service17.consultarListasContactos("20140101","20151231");

		ListaService service18 = new ListaService();
		service18.consultarListas("20140101","20151231");
		
		MiembroService service19 = new MiembroService();
		service19.consultarMiembros("20140101","20151231");

		OfertaService service20 = new OfertaService();
		service20.consultarOfertas("20140101","20151231");
		
		PlanService service21 = new PlanService();
		service21.consultarPlanes("20140101","20151231");
		
		ProgramaService service22 = new ProgramaService();
		service22.consultarProgramas("20140101","20151231");
		
		RegionService service23 = new RegionService();
		service23.consultarRegiones("20140101","20151231");
		
		RespuestaCampannaService service24 = new RespuestaCampannaService();
		service24.consultarRespuestasCampannas("20140101","20151231");
		
		TarjetaService service25 = new TarjetaService();
		service25.consultarTarjetas("20140101","20151231");
	}
}