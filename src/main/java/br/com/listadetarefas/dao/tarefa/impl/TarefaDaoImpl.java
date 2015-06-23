package br.com.listadetarefas.dao.tarefa.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import br.com.listadetarefas.dao.tarefa.TarefaDao;
import br.com.listadetarefas.dao.tarefa.rowmapper.TarefaMapper;
import br.com.listadetarefas.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TarefaDaoImpl implements TarefaDao {
	@Autowired
    DataSource dataSource;

    @Override
	public void adiciona(Tarefa tarefa) {
		String sql =
                "INSERT INTO " +
                "tarefa (descricao,finalizado) " +
                "VALUES (?,?)";

        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.update(sql, tarefa.getDescricao(), false);
	}

    @Override
    public void altera(Tarefa tarefa) {
        String sql =
                "UPDATE tarefa " +
                "SET descricao=?, " +
                "datafinalizacao = ?, " +
                "finalizado = ? " +
                "WHERE id = ?";

        Date data;
        if(tarefa.isFinalizado()){
            data = new Date(tarefa.getDataFinalizacao().getTimeInMillis());
        } else {
            data = null;
        }

        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.update(sql,
                tarefa.getDescricao(),
                data,
                tarefa.isFinalizado(),
                tarefa.getId());
    }

    private Tarefa pesquisa(Object valorAtributo, String nomeAtributo){
        String sql =
                "SELECT * " +
                "FROM tarefa " +
                "WHERE " + nomeAtributo + "=?";

        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        List<Tarefa> list = jdbc.query(sql,
                new Object[]{valorAtributo},
                new TarefaMapper());

        if(list.isEmpty()) return null;
        else return list.get(0);
    }

    @Override
    public Tarefa pesquisa(Long id) {
        return pesquisa(id, "id");
    }

    @Override
    public void remove(Tarefa tarefa) {
        String sql =
                "DELETE FROM tarefa " +
                "WHERE id=?";
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.update(sql, tarefa.getId());
    }

    @Override
    public void remove(Long id) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        remove(tarefa);
    }

    @Override
    public void finaliza(Tarefa tarefa) {
        String sql =
                "UPDATE tarefa " +
                "SET finalizado=1, " +
                "dataFinalizacao=? " +
                "WHERE id=?";

        Calendar data = Calendar.getInstance();

        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.update(sql,
                new Date(data.getTimeInMillis()),
                tarefa.getId());
    }

    @Override
    public void finaliza(Long id) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        finaliza(tarefa);
    }

    @Override
	public List<Tarefa> getLista() {
		String sql = "SELECT * FROM tarefa";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        return jdbc.query(sql, new TarefaMapper());
	}

    @Override
	public List<Tarefa> getListaPorNome(String descricao) {
		String sql =
                "SELECT * " +
                "FROM tarefa " +
                "WHERE descricao " +
                "LIKE ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        return jdbc.query(sql, new Object[]{"%"+descricao+"%"}, new TarefaMapper());
	}

}
