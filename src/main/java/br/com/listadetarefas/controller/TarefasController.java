package br.com.listadetarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.listadetarefas.dao.tarefa.TarefaDao;
import br.com.listadetarefas.model.Tarefa;

@Controller
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefaDao dao;

    @RequestMapping("listar")
    public String lista(Model model) {
        List<Tarefa> tarefas = dao.getLista();
        model.addAttribute("tarefas", tarefas);

        return "tarefa/lista";
    }

    @RequestMapping("buscar")
    public String busca(Tarefa tarefa, Model model){
        List<Tarefa> tarefas = dao.getListaPorNome(tarefa.getDescricao());
        model.addAttribute("tarefas", tarefas);

        return "tarefa/lista";
    }

    @RequestMapping("adicionar")
    public String formularioNovaTarefa() {
        return "tarefa/formulario";
    }

    @RequestMapping(value = "adiciona", method = RequestMethod.POST)
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

    @RequestMapping("editar")
    public String formularioEditar(Tarefa tarefa, Model model) {
        Tarefa tarefaCompleta = dao.pesquisa(tarefa.getId());
        model.addAttribute("tarefa", tarefaCompleta);
        return "tarefa/editar";
    }

    @RequestMapping(value = "edita", method = RequestMethod.POST)
    public String edita(Tarefa tarefa){
        dao.altera(tarefa);
        return "redirect:listar";
    }

    @RequestMapping(value = "finaliza", method = RequestMethod.POST)
    public String finaliza(Long id, Model model){
        dao.finaliza(id);
        model.addAttribute("tarefa", dao.pesquisa(id));
        return "tarefa/finalizada";
    }

	@ResponseBody
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public void remove(Long id){
		dao.remove(id);
	}
}
