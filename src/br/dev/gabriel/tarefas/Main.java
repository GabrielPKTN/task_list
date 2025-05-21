package br.dev.gabriel.tarefas;

import java.io.*;
import java.time.LocalDate;

import br.dev.gabriel.tarefas.model.Funcionario;
import br.dev.gabriel.tarefas.model.Status;
import br.dev.gabriel.tarefas.model.Tarefa;

public class Main {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario("André", "Programador", "T.I");
		Tarefa tarefa = new Tarefa(funcionario);
		tarefa.setNome("Lavar a louça");
		tarefa.setDescricao("Lavar a louça antes de eu chegar.");
		tarefa.setDataInicio(LocalDate.of(2025, 5, 21));
		tarefa.setPrazo(1);
		tarefa.getDataPrevistaEntrega();
		tarefa.setStatus(Status.EM_ANDAMENTO);
	}
	
	private static void testarLeituraEscritaArquivo() {
		String so = System.getProperty("os.name");
		System.out.println(so);
		
		String caminho = "/Users/25132902/projetoTarefas/tarefas";
		
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {			
			
			br = new BufferedReader(fr);
			fr = new FileReader(caminho);
			
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			bw.append("Gabriel");
			
			String linha = br.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			
		} catch(FileNotFoundException exception) {
			
			System.out.println("Arquivo não econtrado");

		} catch(IOException exception) {
			
			System.out.println("Arquivo com permissões");
			
		} catch (Exception e) {
			
			System.out.println("ERRO");
			
		}
	}
}
