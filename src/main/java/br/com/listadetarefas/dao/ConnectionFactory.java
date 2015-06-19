package br.com.listadetarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException(e1);
		}

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/gerenciadordetarefas", "root", "abc123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
