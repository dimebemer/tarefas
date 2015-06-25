package br.com.listadetarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    @RequestMapping("/")
    public String home(){
        return "redirect:tarefas/listar";
    }
}
