package br.dev.gabriel.tarefas;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.dev.gabriel.tarefas.dao.FuncionarioDAO;
import br.dev.gabriel.tarefas.model.Funcionario;
import br.dev.gabriel.tarefas.model.Status;
import br.dev.gabriel.tarefas.model.Tarefa;
import br.dev.gabriel.tarefas.ui.FuncionarioFrame;
import br.dev.gabriel.tarefas.ui.FuncionarioListaFrame;
import br.dev.gabriel.tarefas.ui.MainFrame;
import br.dev.gabriel.tarefas.ui.TarefaFrame;
import br.dev.gabriel.tarefas.ui.TarefaListaFrame;

public class Main {

	public static void main(String[] args) {
	
		new MainFrame();
		
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
