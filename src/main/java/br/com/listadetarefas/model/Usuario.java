package br.com.listadetarefas.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario {

    private Long id;

    @NotNull
    @Size.List({
        @Size(min = 4, message = "{usuario.login.minimo}"),
        @Size(max = 20, message = "{usuario.login.maximo}")
    })
    private String login;

    @NotNull
    @Size.List({
        @Size(min = 6, message = "{usuario.senha.minimo}"),
        @Size(max = 30, message = "{usuario.senha.maximo}")
    })
    private String senha;

    public Usuario() {
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("login", login)
                .append("senha", senha)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
