package br.dev.gabriel.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.dev.gabriel.tarefas.factory.ArquivoTarefaFactory;
import br.dev.gabriel.tarefas.model.Funcionario;
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
	public List<Tarefa> getTarefas() {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			BufferedReader br = atf.getBr();
			
			String linha = "";
			
			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					
					String[] tarefaVetor = linha.split(",");
					Tarefa tarefa = new Tarefa(null);
					
					tarefa.setID(tarefaVetor[0]);
					tarefa.setNome(tarefaVetor[1]);
					tarefa.setDescricao(tarefaVetor[2]);
					tarefa.setResponsavelByName(tarefaVetor[3]);
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate data = LocalDate.parse(tarefaVetor[4], formatter);
					
					tarefa.setDataInicio(data);
					
					tarefa.setPrazo(Integer.parseInt(tarefaVetor[5]));
					
					LocalDate dataEntregaString = tarefa.getDataPrevistaEntrega();
					tarefaVetor[6] = dataEntregaString.toString();
					LocalDate dataEntrega = LocalDate.parse(tarefaVetor[6], formatter);					
					
					tarefa.setDataEntrega(dataEntrega);
					
					tarefas.add(tarefa);
				}

			}
			
			return tarefas;
			
		} catch (IOException e) {	
			e.printStackTrace();
			return null;
		}
		
	}
	
}
