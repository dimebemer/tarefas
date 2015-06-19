package br.com.listadetarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.listadetarefas.beans.Tarefa;
import br.com.listadetarefas.dao.TarefaDao;

@Controller
public class TarefasController {
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		new TarefaDao().adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("novaTarefa")
	public String formularioNovaTarefa() {
		return "tarefa/formulario";
	}

	@RequestMapping("listaTarefa")
	public String lista(Model model) {
		List<Tarefa> tarefas = new TarefaDao().getLista();
		model.addAttribute("tarefas", tarefas);

		return "tarefa/lista";
	}

	@ResponseBody
	@RequestMapping("removeTarefa")
	public void remove(Long id){
		new TarefaDao().remove(id);
	}

	@RequestMapping("editaTarefa")
	public String formularioEditar(Tarefa tarefa, Model model) {
		Tarefa tarefaCompleta = new TarefaDao().pesquisa(tarefa.getId());
		model.addAttribute("tarefa", tarefaCompleta);
		return "tarefa/editar";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa){
		new TarefaDao().altera(tarefa);
		return "redirect:listaTarefa";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model){
		TarefaDao dao = new TarefaDao();
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.pesquisa(id));
		return "tarefa/finalizada";
	}

	@RequestMapping("procuraTarefa")
	public String procura(Tarefa tarefa, Model model){
		List<Tarefa> tarefas = new TarefaDao().getListaPorNome(tarefa.getDescricao());
		model.addAttribute("tarefas", tarefas);

		return "tarefa/lista";
	}
}
