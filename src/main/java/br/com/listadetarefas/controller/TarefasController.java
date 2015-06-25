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
public class TarefasController {

    @Autowired
    private TarefaDao dao;

    @RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("novaTarefa")
	public String formularioNovaTarefa() {
		return "tarefa/formulario";
	}

	@RequestMapping("listaTarefa")
	public String lista(Model model) {
		List<Tarefa> tarefas = dao.getLista();
		model.addAttribute("tarefas", tarefas);

		return "tarefa/lista";
	}

	@ResponseBody
	@RequestMapping(value = "removeTarefa", method = RequestMethod.POST)
	public void remove(Long id){
		dao.remove(id);
	}

	@RequestMapping("editaTarefa")
	public String formularioEditar(Tarefa tarefa, Model model) {
		Tarefa tarefaCompleta = dao.pesquisa(tarefa.getId());
		model.addAttribute("tarefa", tarefaCompleta);
		return "tarefa/editar";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa){
		dao.altera(tarefa);
		return "redirect:listaTarefa";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model){
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.pesquisa(id));
		return "tarefa/finalizada";
	}

	@RequestMapping("procuraTarefa")
	public String procura(Tarefa tarefa, Model model){
		List<Tarefa> tarefas = dao.getListaPorNome(tarefa.getDescricao());
		model.addAttribute("tarefas", tarefas);

		return "tarefa/lista";
	}
}
