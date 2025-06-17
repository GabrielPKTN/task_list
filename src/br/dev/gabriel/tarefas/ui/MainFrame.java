package br.dev.gabriel.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame {

	private JLabel labelTelaInicial;
	private JButton buttonListaFuncionarios;
	private JButton buttonListaTarefas;
	
	public MainFrame() {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame telaPrincipal = new JFrame("Gerenciador de Tarefas");
		
		telaPrincipal.setSize(235, 200);
		telaPrincipal.setResizable(false);
		telaPrincipal.setLayout(null);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setLocationRelativeTo(null);
		
		Container painel = telaPrincipal.getContentPane();
		
		labelTelaInicial = new JLabel("Gerenciador de Tarefas");
		labelTelaInicial.setBounds(40, 20, 135, 20);
		
		buttonListaFuncionarios = new JButton("Funcionários");
		buttonListaFuncionarios.setBounds(20, 50, 180, 40);
		
		buttonListaTarefas = new JButton("Tarefas");
		buttonListaTarefas.setBounds(20, 95, 180, 40);
		
		painel.add(labelTelaInicial);
		painel.add(buttonListaFuncionarios);
		painel.add(buttonListaTarefas);
		
		telaPrincipal.setVisible(true);
	}
	
}