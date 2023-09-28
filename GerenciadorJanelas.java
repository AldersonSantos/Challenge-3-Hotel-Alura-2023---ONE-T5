package br.com.challenge.one_t5.hotel_alura.view;

/**
 * @author Alderson Santos
 *
 */
public class GerenciadorJanelas {

	
	private TelaHome home;
	private TelaLogin login;
	private TelaMenuUsuario menu;
	private TelaReservas reserva;
	private TelaRegistroHospede registro;
	private TelaBuscar buscar;	

	/**
	 * 
	 * GerenciadorJanelas contem  varios contrutores 
	 * que aponta para todos JFrame do programa
	 * 
	 */
	public GerenciadorJanelas( ) {
			
		home = new TelaHome();
		home.telaHome();	
					
	}
	
	
	// login
	public GerenciadorJanelas(TelaLogin login ) {
		
		this.login = login;
		login = new TelaLogin();
		login.telaLogin();
		
	}
	
	// construtor menu
	public GerenciadorJanelas(TelaMenuUsuario menu) {
		
		this.menu = menu;
		menu = new TelaMenuUsuario();
		menu.telaMenu();
		
	}	
	
	// construtor reservas
		public GerenciadorJanelas(TelaReservas reservas){
			
			this.reserva = reservas;
			reserva = new TelaReservas();
			reserva.telaReservas();
			
		}
		
		// construtor reservas
		public GerenciadorJanelas(TelaRegistroHospede registro) {

			this.registro = registro;
			registro = new TelaRegistroHospede();
			registro.telaRegistro();

		}	
		
		// construtor buscar
		public GerenciadorJanelas(TelaBuscar buscar) {

			this.buscar = buscar;
			buscar = new TelaBuscar();
			buscar.telaBuscar();

		}		
		
}





	

