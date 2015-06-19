package br.com.listadetarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.listadetarefas.beans.Tarefa;

public class TarefaDao {
	private Connection connection;

	public TarefaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public TarefaDao(Connection connection) {
		this.connection = connection;
	}

	private List<Tarefa> geraLista(PreparedStatement stmt) throws SQLException {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Tarefa tarefa = new Tarefa();

			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));

			if(tarefa.isFinalizado()) {
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
			} else {
				tarefa.setDataFinalizacao(null);
			}

			tarefas.add(tarefa);
		}

		rs.close();
		stmt.close();

		return tarefas;
	}

	public void adiciona(Tarefa tarefa) {
		String sql = "INSERT INTO tarefa (descricao,finalizado) VALUES (?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, false);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Tarefa> getLista() {
		String sql = "SELECT * FROM tarefa";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			List<Tarefa> tarefas = geraLista(stmt);
			return tarefas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Tarefa tarefa) {
		String sql = "UPDATE tarefa SET descricao=?, datafinalizacao = ?, "
				+ "finalizado = ? WHERE id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());

			if(tarefa.getDataFinalizacao() != null){
				stmt.setDate(2, new Date(tarefa.getDataFinalizacao()
					.getTimeInMillis()));
			} else {
				stmt.setDate(2, null);
			}

			stmt.setBoolean(3, tarefa.isFinalizado());
			stmt.setLong(4, tarefa.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Tarefa pesquisa(Long id) {
		String sql = "SELECT * FROM tarefa WHERE id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();

			Tarefa tarefa = new Tarefa();

			tarefa.setId(id);
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));

			if(tarefa.isFinalizado()) {
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datafinalizacao"));
				tarefa.setDataFinalizacao(data);
			} else {
				tarefa.setDataFinalizacao(null);
			}

			stmt.close();
			rs.close();

			return tarefa;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Tarefa> getListaPorNome(String descricao) {
		String sql = "SELECT * FROM tarefa WHERE descricao LIKE ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + descricao + "%");
			List<Tarefa> tarefas = geraLista(stmt);
			return tarefas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		String sql = "DELETE FROM tarefa WHERE id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		remove(tarefa);
	}

	public void finaliza(Tarefa tarefa) {
		String sql = "UPDATE tarefa "
				+ "SET finalizado=1, dataFinalizacao=?"
				+ "WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(2, tarefa.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void finaliza(Long id) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		finaliza(tarefa);
	}

}
