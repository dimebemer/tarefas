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
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("usuario")
public class LoginController {

    @Autowired
    private UsuarioDao dao;

    @RequestMapping("cadastro")
    public String formCadastro() {
        return "usuario/cadastro";
    }

    @RequestMapping("login")
    public String formLogin() {
        return "usuario/login";
    }

    @RequestMapping(value = "loga", method = RequestMethod.POST)
    public String login(Usuario usuario, HttpSession session) {
        if (dao.valida(usuario)) {
            session.setAttribute("USUARIO_LOGADO", usuario);
            return "redirect:../tarefas/listar";
        }
        return "redirect:login";
    }

    @RequestMapping(value = "cadastra", method = RequestMethod.POST)
    public String cadastra(@Valid Usuario usuario, BindingResult result,
                           @ModelAttribute("confirmarSenha") String confirmarSenha,
                           HttpSession session) {
        if (result.hasFieldErrors() ||
            dao.pesquisaPorLogin(usuario.getLogin()) != null ||
            !usuario.getSenha().equals(confirmarSenha)) {
            return "redirect:cadastro";
        }
        dao.cadastra(usuario);
        session.setAttribute("USUARIO_LOGADO", usuario);
        return "usuario/cadastrado";
    }
}
