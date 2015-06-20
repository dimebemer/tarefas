package br.com.listadetarefas.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

public class Tarefa {
    private Long id;

    @NotNull(message = "{tarefa.descricao.vazia}")
    @Size(min = 5, message = "{tarefa.descricao.pequena}")
    private String descricao;
    private boolean finalizado;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dataFinalizacao;

    public Tarefa() {
        this.finalizado = false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("descricao", descricao)
                .append("finalizado", finalizado)
                .append("dataFinalizacao", dataFinalizacao)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarefa tarefa = (Tarefa) o;

        if (finalizado != tarefa.finalizado) return false;
        if (dataFinalizacao != null ? !dataFinalizacao.equals(tarefa.dataFinalizacao) : tarefa.dataFinalizacao != null)
            return false;
        if (!descricao.equals(tarefa.descricao)) return false;
        if (id != null ? !id.equals(tarefa.id) : tarefa.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + descricao.hashCode();
        result = 31 * result + (finalizado ? 1 : 0);
        result = 31 * result + (dataFinalizacao != null ? dataFinalizacao.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        if (dataFinalizacao != null) {
            finalizado = true;
        }
        this.dataFinalizacao = dataFinalizacao;
    }

}
