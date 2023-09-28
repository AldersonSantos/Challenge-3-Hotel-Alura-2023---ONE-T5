package br.com.challenge.one_t5.hotel_alura.Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConectionFactoryLogin {

	public DataSource dataSource;

	public ConectionFactoryLogin() {

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("5#*AL87313");

		// set conexoes
		comboPooledDataSource.setMaxPoolSize(10);
		this.dataSource = comboPooledDataSource;

	}

	public Connection recuperaConexao() {

		try {
			// conectar com o banco de dados
			return this.dataSource.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

}
