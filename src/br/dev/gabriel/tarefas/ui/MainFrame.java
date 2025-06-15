package br.dev.gabriel.tarefas.ui;



import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame {
	
		
	private JButton buttonFuncionarios;
	private JButton buttonTarefas;
		
	public MainFrame() {
		criarTela();
	}

	private void criarTela() {
			
		JFrame telaMainFrame = new JFrame("Gerenciador de tarefas");
			
		telaMainFrame.setSize(300, 120);
		telaMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMainFrame.setLayout(null);
		telaMainFrame.setLocationRelativeTo(null);
		telaMainFrame.setResizable(false);
			
		Container painel = telaMainFrame.getContentPane();
			
		buttonFuncionarios = new JButton("Funcionários");
		buttonFuncionarios.setBounds(20, 20, 120, 40);
			
		buttonTarefas = new JButton ("Tarefas");
		buttonTarefas.setBounds(150, 20, 120, 40);
			
		painel.add(buttonFuncionarios);
		painel.add(buttonTarefas);	
			
		telaMainFrame.setVisible(true);
	}
}
	

