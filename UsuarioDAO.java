package br.com.challenge.one_t5.hotel_alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.challenge.one_t5.hotel_alura.view.TelaLogin;

public class UsuarioDAO {
	
	private Connection conexao;
	

	public UsuarioDAO(Connection conexao) {
		
		this.conexao = conexao;
		
	}		
	
	//
	public void salvarUsuario(TelaLogin clinte,String nome, String senha) {

		try {

			final String sql = ("INSERT INTO hotel_login_cliente(NOME, SENHA) VALUES(?,?)");
			
			PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, nome);
			pstm.setString(2, senha);
			//
			conexao.setAutoCommit(false);
			//
			pstm.execute();
			//
			try (ResultSet rst = pstm.getGeneratedKeys()) {

				while (rst.next()) {

					Integer id = rst.getInt(1);
					System.out.println(pstm);
					System.out.println("Produtos adicionados: " + id);
				}
			}

			conexao.commit();

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("RollBack Executado1: CadastroUsuario");

			try {
				conexao.rollback();
			} catch (SQLException e1) {

				System.out.println("RollBack Executado2: CadastroUsuario");
				e1.printStackTrace();
			}
		}
	}	
	//	
	public Boolean buscarUsuario(TelaLogin clinte,String nome) {

		Boolean nomeIguais = false;	
		
		try {		
			
			String sql = ("select * from  hotel_login_cliente where NOME like(?)");
							
			PreparedStatement pstm = conexao.prepareStatement(sql);

			pstm.setString(1, nome);

			//
			conexao.setAutoCommit(false);
			//
			pstm.execute();
			//
			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {

					String inputCliente = rst.getString("NOME");					
					
					if (inputCliente.equals(nome)) {

					    nomeIguais = true;
					} 					
				}
			}
			
			conexao.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("RollBack Executado3: CadastroUsuario");

			try {
				conexao.rollback();
			} catch (SQLException e1) {

				System.out.println("RollBack Executado4: CadastroUsuario");
				e1.printStackTrace();
			}
		}
		return nomeIguais;
	}
	
	//login
	public Boolean loginUsuario(TelaLogin cliente,String nome, String senha) {		

		Boolean login = false;	
		
		try {		
			
			final String sql = ("select * from  hotel_login_cliente where NOME like(?) and senha like(?)");
			
			PreparedStatement pstm = conexao.prepareStatement(sql);

			pstm.setString(1, nome);
			pstm.setString(2, senha);

			//
			conexao.setAutoCommit(false);
			//
			pstm.execute();
			//
			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {

					 String inputNome = rst.getString("NOME");
					 String inputSenha = rst.getString("SENHA");
					
					if (inputNome.equals(nome) && inputSenha.equals(senha)) {

						login = true;
					} 					
				}
			}
			
			conexao.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("RollBack Executado5: CadastroUsuario");

			try {
				conexao.rollback();
			} catch (SQLException e1) {

				System.out.println("RollBack Executado26: CadastroUsuario");
				e1.printStackTrace();
			}
		}
		return login;
		
	}
	
}
