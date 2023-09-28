package br.com.challenge.one_t5.hotel_alura.Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Alderson Santos
 *
 */
public class ConectionFactoryHospede {
	
	public DataSource dataSource2;

	/**
	 * 
	 * configurar conexao com o banco de dados
	 */
	public ConectionFactoryHospede() {		

		ComboPooledDataSource comboPooledDataSourceHospede = new ComboPooledDataSource();
		comboPooledDataSourceHospede.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSourceHospede.setUser("root");
		comboPooledDataSourceHospede.setPassword("5#*AL87313");

		// set conexoes
		comboPooledDataSourceHospede.setMaxPoolSize(10);
		this.dataSource2 = comboPooledDataSourceHospede;		
		
	}
	
	public Connection recuperaConexaoHospede() {

		try {
			// conectar com o banco de dados
			return this.dataSource2.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
	
	

}
