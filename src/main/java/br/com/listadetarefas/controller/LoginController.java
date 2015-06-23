package br.com.listadetarefas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.listadetarefas.dao.usuario.UsuarioDao;
import br.com.listadetarefas.model.Usuario;

@Controller
public class LoginController {

    @Autowired
    private UsuarioDao dao;

    @RequestMapping("novoUsuario")
    public String formCadastro() {
        return "usuario/cadastro";
    }

    @RequestMapping("loginUsuario")
    public String formLogin() {
        return "usuario/login";
    }

    @RequestMapping("efetuaLogin")
    public String login(Usuario usuario, HttpSession session) {
        if (dao.valida(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:listaTarefa";
        }
        return "redirect:loginUsuario";
    }

    @RequestMapping("cadastraUsuario")
    public String cadastra(@Valid Usuario usuario, BindingResult result,
                           @ModelAttribute("confirmarSenha") String confirmarSenha,
                           HttpSession session) {
        if (result.hasFieldErrors() ||
            dao.pesquisaPorLogin(usuario.getLogin()) != null ||
            !usuario.getSenha().equals(confirmarSenha)) {
            return "redirect:novoUsuario";
        }
        dao.cadastra(usuario);
        session.setAttribute("usuarioLogado", usuario);
        return "usuario/cadastrado";
    }
}
