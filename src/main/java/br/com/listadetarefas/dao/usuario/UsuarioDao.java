package br.com.listadetarefas.dao.usuario;

import br.com.listadetarefas.model.Usuario;

public interface UsuarioDao {
    /**
     * Valida o usuário e a senha fornecidos.
     */
    boolean valida(Usuario usuario);

    /**
     * Cadastra um novo usuário.
     */
    void cadastra(Usuario usuario);

    /**
     * Pesquisa o usuário fornecido
     * pelo ID (caso exista).
     * @return O usuário encontrado, ou null
     */
    Usuario pesquisaPorId(Long id);

    /**
     * Pesquisa um usuário pelo
     * seu login (caso exista).
     */
    Usuario pesquisaPorLogin(String login);
}
