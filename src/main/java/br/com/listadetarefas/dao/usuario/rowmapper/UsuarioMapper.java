package br.com.listadetarefas.dao.usuario.rowmapper;

import br.com.listadetarefas.model.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario>{

    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(rs.getLong("id"));
        usuario.setLogin(rs.getString("login"));
        usuario.setSenha(rs.getString("senha"));

        return usuario;
    }
}
