package br.com.listadetarefas.dao.tarefa;

import br.com.listadetarefas.model.Tarefa;

import java.util.List;

public interface TarefaDao {
    void adiciona(Tarefa tarefa);
    void altera(Tarefa tarefa);
    void remove(Tarefa tarefa);
    void remove(Long id);
    void finaliza(Tarefa tarefa);
    void finaliza(Long id);

    Tarefa pesquisa(Long id);

    List<Tarefa> getLista();
    List<Tarefa> getListaPorNome(String descricao);
}
