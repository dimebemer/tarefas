package br.com.listadetarefas.dao.usuario.impl;

import br.com.listadetarefas.dao.usuario.UsuarioDao;
import br.com.listadetarefas.dao.usuario.rowmapper.UsuarioMapper;
import br.com.listadetarefas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

    @Autowired
    DataSource dataSource;

    @Override
    public boolean valida(Usuario usuario) {
        Usuario teste = pesquisa(usuario.getLogin(), "login");

        if (teste == null) return false;
        if (!teste.getSenha().equals(usuario.getSenha())) return false;
        return true;
    }

    @Override
    public void cadastra(Usuario usuario) {
        String sql =
                "INSERT INTO usuario " +
                "(login,senha) " +
                "VALUES (?,?)";

        new JdbcTemplate(dataSource).update(sql,
                usuario.getLogin(),
                usuario.getSenha());
    }

    @Override
    public Usuario pesquisaPorId(Long id) {
        return pesquisa(id, "id");
    }

    @Override
    public Usuario pesquisaPorLogin(String login) {
       return pesquisa(login, "login");
    }

    /**
     * Método privado para pesquisar um
     * usuário.
     * @param valorAtributo O valor a ser pesquisado
     * @param nomeAtributo O atributo a ser pesquisado na tabela
     */
    private Usuario pesquisa(Object valorAtributo, String nomeAtributo){
        String sql =
                 "SELECT * " +
                 "FROM usuario " +
                 "WHERE " + nomeAtributo + "=?";
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        List<Usuario> list = jdbc.query(sql,
                new Object[]{valorAtributo},
                new UsuarioMapper());

        if(list.isEmpty()) return null;
        else return list.get(0);
    }
}
