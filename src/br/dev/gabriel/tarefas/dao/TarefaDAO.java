package br.dev.gabriel.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import br.dev.gabriel.tarefas.factory.ArquivoTarefaFactory;
import br.dev.gabriel.tarefas.model.Tarefa;

public class TarefaDAO {
	
	private Tarefa tarefa;
	private ArquivoTarefaFactory atf = new ArquivoTarefaFactory();
	
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public boolean gravarTarefa() {
		try {
			BufferedWriter bw = atf.getBw();
			bw.write(tarefa.toString());
			bw.flush();
			System.out.println("A tarefa " + tarefa.getNome() + " foi salva com sucesso.\n");
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		}
	}
	
}
