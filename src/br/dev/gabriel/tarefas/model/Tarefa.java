package br.dev.gabriel.tarefas.model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import br.dev.gabriel.tarefas.dao.FuncionarioDAO;
import br.dev.gabriel.tarefas.utils.Utils;

public class Tarefa {

	private String ID;
	private String nome;
	private String descricao;
	private String responsavel;
	private LocalDate dataInicio;
	private int prazo;
	private LocalDate dataEntrega;
	private Status status;

	public Tarefa(String nome) {
		System.out.println("Criando Tarefa...");
		setID(Utils.gerarUUID8());
		setNome(nome);

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setResponsavelByName(String nome) {
		
		FuncionarioDAO dao = new FuncionarioDAO(null);

		for (Funcionario f : dao.getFuncionarios()) {
			
			if (f.getNome().equalsIgnoreCase(nome)) {
				responsavel = f.getNome();		
				}
			}
	}


	public String getResponsavel() {
		return responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataInicio.plusDays(prazo);
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {

		LocalDate hoje = LocalDate.now();

		if (hoje.isBefore(dataEntrega)) {
			status = Status.NAO_INICIADO;

		} else if (hoje.equals(dataInicio) && hoje.isBefore(dataEntrega)) {
			status = Status.EM_ANDAMENTO;

		} else if (hoje.isAfter(dataInicio)) {
			status = Status.EM_ATRASO;

		} else {
			status = Status.CONCLUIDA;

		}

		return status;

	}

	@Override
	public String toString() {
		return ID + "," + nome + "," + descricao + "," + responsavel + "," + dataInicio + "," + prazo + ","
				+ dataEntrega + "," + status + "\n";
	}

}
