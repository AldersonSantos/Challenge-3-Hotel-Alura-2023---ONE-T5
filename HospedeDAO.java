package br.com.challenge.one_t5.hotel_alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.challenge.one_t5.hotel_alura.modelo.Hospede;

/**
 * @author Alderson Santos
 *
 */
public class HospedeDAO {

	Connection conHospede;
	
	/**
	 *  metodos SQL
	 *
	 */
	
	public HospedeDAO(Connection conexao) {
		
		this.conHospede = conexao;
		
	}
	//
	public void salvarHospede(Hospede hospede, int nReserva, String nome, String sobreNome, String dataNascimento,
			String nacionalidade, String telefone) {

		try {

			String sql = ("insert into hotel_registro_hospede(Numero_reserva, Nome, Sobrenome, Data_nascimento, Nacionalidade,Telefone) values(?,?,?,?,?,?)");

			PreparedStatement pstm = conHospede.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, nReserva);
			pstm.setString(2, nome.strip());
			pstm.setString(3, sobreNome.strip());
			pstm.setString(4, dataNascimento);
			pstm.setString(5, nacionalidade);
			pstm.setString(6, telefone);
			//
			conHospede.setAutoCommit(false);
			//
			pstm.execute();

			conHospede.commit();
			pstm.close();

		} catch (SQLException conH) {

			System.out.println("RollBack Executado1: salvarHospede");
			conH.printStackTrace();

		}
	}
	
	//
	public void atualizarHospede(Hospede hospede, int nReserva, String nome, String sobreNome, String dataNascimento,
			String nacionalidade, String telefone) {

		try {

			String sql = ("update hotel_registro_hospede set Nome = (?), Sobrenome = (?), Data_nascimento = (?), Nacionalidade = (?), Telefone = (?) where Numero_reserva = (?)");

			PreparedStatement pstm = conHospede.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, nome.strip());
			pstm.setString(2, sobreNome.strip());
			pstm.setString(3, dataNascimento);
			pstm.setString(4, nacionalidade);
			pstm.setString(5, telefone);
			pstm.setInt(6, nReserva);
			
			//
			conHospede.setAutoCommit(false);
			//
			pstm.execute();

			conHospede.commit();
			
			pstm.close();

		} catch (SQLException conH) {

			System.out.println("RollBack Executado1: atualizar Hospede");
			conH.printStackTrace();

		}
	}
	//
	
	public void deletarHospede(Hospede hospede, int nReserva) {

		try {

			String sql = ("delete from hotel_registro_hospede  where Numero_reserva = (?)");

			PreparedStatement pstm = conHospede.prepareStatement(sql);			
			pstm.setInt(1, nReserva);
			
			//
			conHospede.setAutoCommit(false);
			//
			pstm.execute();

			conHospede.commit();
			pstm.close();

		} catch (SQLException conH) {

			System.out.println("RollBack Executado1: deletar Hospede");
			conH.printStackTrace();

		}
	}
	
	
	public Boolean checkNumeroReserva(Hospede hospede, Integer numero) {
		
			Boolean existeReserva = false;
			try {		
				
				final String sql = ("select * from  hotel_registro_hospede where Numero_reserva like(?)");
				
				PreparedStatement pstm = conHospede.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pstm.setInt(1, numero);
				//
				conHospede.setAutoCommit(false);
				//
				pstm.execute();
				//
				try (ResultSet rst = pstm.getResultSet()) {

					while (rst.next()) {

						Integer numeroReserva = rst.getInt(2);						
						
						if (numeroReserva.equals(numero)) {

							existeReserva  = true;
						} 					
					}
					
				}	
				conHospede.commit();
				pstm.close();
		
	} catch (SQLException e1) {

			System.out.println("RollBack Executado2: checkNumeroReserva");
			e1.printStackTrace();
		}
			
			return  existeReserva;
	}	
	
	public List<Hospede> listarHospede() {

		List<Hospede> listaHospede = new ArrayList<Hospede>();
		
		try {
			//
			String sql = ("select * from hotel_registro_hospede");
			//
			PreparedStatement pstm = conHospede.prepareStatement(sql);
			//
			conHospede.setAutoCommit(false);
			//
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {

					//inverter data
					String nascimento = rst.getString(5);						
					String a = nascimento .substring(0, 4);
					String m = nascimento .substring(5, 7);
					String d = nascimento .substring(8, 10);
					
					String data = d.concat("/").concat(m).concat("/").concat(a);						
					
					Hospede hospede = new Hospede(rst.getInt(2), rst.getString(3), rst.getString(4), data,
							rst.getString(6), rst.getString(7));
					listaHospede.add(hospede);				
				}

				rst.close();
			}

			conHospede.commit();
			pstm.close();

		} catch (SQLException e1) {

			System.out.println("RollBack Executado: listarHospede");
			e1.printStackTrace();
		}
		return listaHospede;
	}

	//
	public List<Hospede> buscarReserva(Integer id) {

		List<Hospede> hospede = new ArrayList<Hospede>();

		try {
			String sql = ("select * from hotel_registro_hospede  where Numero_reserva like(?)");	
			
			PreparedStatement pstm = conHospede.prepareStatement(sql);
			pstm.setInt(1, id);
			//
			conHospede.setAutoCommit(false);
			//
			pstm.execute();
			//
			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {

					Integer numeroReserva = rst.getInt(2);

					if (numeroReserva.equals(id)) {
						
						////inverter data
						String nascimento = rst.getString(5);						
						String a = nascimento .substring(0, 4);
						String m = nascimento .substring(5, 7);
						String d = nascimento .substring(8, 10);
						
						String data = d.concat("/").concat(m).concat("/").concat(a);
						
						Hospede hospedeCadastro = new Hospede(rst.getInt(2), rst.getString(3), rst.getString(4),
								data, rst.getString(6), rst.getString(7));

						hospede.add(hospedeCadastro);

					}

				}
				rst.close();

			}

			conHospede.commit();
			pstm.close();

		} catch (SQLException e1) {

			System.out.println("RollBack Executado: buscarReserva");
			e1.printStackTrace();
		}
		return hospede;

	}
	
	public List<Hospede> buscarSobrenome(String sobrenome) {

		List<Hospede> hospedeSobrenome = new ArrayList<Hospede>();

		try {
			String sql = ("select * from hotel_registro_hospede  where Sobrenome like(?)");

			PreparedStatement pstm = conHospede.prepareStatement(sql);
			pstm.setString(1, sobrenome.strip());
			//
			conHospede.setAutoCommit(false);
			//
			pstm.execute();
			//
			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {

					String registroSobrenome = rst.getString(4);

					if (registroSobrenome.equals(sobrenome.strip())) {

						////inverter data
						String nascimento = rst.getString(5);						
						String a = nascimento .substring(0, 4);
						String m = nascimento .substring(5, 7);
						String d = nascimento .substring(8, 10);
						
						String data = d.concat("/").concat(m).concat("/").concat(a);
						
						Hospede hospedeCadastro = new Hospede(rst.getInt(2), rst.getString(3), rst.getString(4),
								data, rst.getString(6), rst.getString(7));

						hospedeSobrenome.add(hospedeCadastro);

					}

				}
				rst.close();

			}

			conHospede.commit();
			pstm.close();

		} catch (SQLException e1) {

			System.out.println("RollBack Executado: buscarReserva");
			e1.printStackTrace();
		}
		return hospedeSobrenome;

	}
}
