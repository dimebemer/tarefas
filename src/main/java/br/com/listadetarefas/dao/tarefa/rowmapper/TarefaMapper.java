package br.com.listadetarefas.dao.tarefa.rowmapper;

import br.com.listadetarefas.model.Tarefa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class TarefaMapper implements RowMapper<Tarefa>{
    @Override
    public Tarefa mapRow(ResultSet rs, int i) throws SQLException {
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

        return tarefa;
    }
}
