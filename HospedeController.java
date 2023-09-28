package br.com.challenge.one_t5.hotel_alura.Controller;

import java.sql.Connection;
import java.util.List;

import br.com.challenge.one_t5.hotel_alura.Factory.ConectionFactoryHospede;
import br.com.challenge.one_t5.hotel_alura.dao.HospedeDAO;
import br.com.challenge.one_t5.hotel_alura.modelo.Hospede;

/**
 * @author Alderson Santos
 *
 */
public class HospedeController {
	
	private HospedeDAO hospede;
	

	/**
	 * HospedeController devolve consuta no banco de dados
	 *
	 */
	public HospedeController() {

		Connection conexaoH = new ConectionFactoryHospede().recuperaConexaoHospede();
		this.hospede = new HospedeDAO(conexaoH);
	}
	
	public List<Hospede> listaHospede() {
		
		return this.hospede.listarHospede();		
		
	}
	
	public  List<Hospede>  buscarReserva(Integer id) {
		
		return this.hospede.buscarReserva(id);
	}
	
	public  List<Hospede>  buscarReservaSobrenome(String sobrenome) {
		
		return this.hospede.buscarSobrenome(sobrenome);
	}
	
	

}
