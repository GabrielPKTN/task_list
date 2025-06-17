package br.dev.gabriel.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.gabriel.tarefas.dao.FuncionarioDAO;
import br.dev.gabriel.tarefas.model.Funcionario;

public class FuncionarioListaFrame {
	
	private JLabel labelTitulo;
	private JButton buttonCadastroFuncionario;
	
	private DefaultTableModel model; // dados da tabela
	private JTable tabelaFuncionarios; // visual da tabela
	private JScrollPane scrollFuncionarios;
	
	String[] colunas = {"CÓDIGO", "NOME FUNCIONÁRIO", "CARGO"};
	
	public FuncionarioListaFrame(JFrame pai) {
		criarTela(pai);
	}
	
	private void criarTela(JFrame pai) {
		JDialog telaFuncionarioLista = new JDialog(pai, "Lista de Funcionários", true);
		
		telaFuncionarioLista.setSize(700, 500);
		telaFuncionarioLista.setResizable(false);
		telaFuncionarioLista.setLayout(null);
		telaFuncionarioLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaFuncionarioLista.setLocationRelativeTo(null);

		Container painel = telaFuncionarioLista.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);
		
		// Criar tabela
		
		model = new DefaultTableModel(colunas, 10);
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);
		
		carregarDadosTabela();
		
		buttonCadastroFuncionario = new JButton("Cadastrar novo funcionário");
		buttonCadastroFuncionario.setBounds(10, 400, 250, 50);
		
		buttonCadastroFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(telaFuncionarioLista);
				carregarDadosTabela();
				
			}
		});
		
		painel.add(buttonCadastroFuncionario);
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		
		telaFuncionarioLista.setVisible(true);
	}
	
	private void carregarDadosTabela() {
		List<Funcionario> funcionarios = new ArrayList<>();
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();
		
		int i = 0;
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		
		model.setDataVector(dados, colunas);
		
	}
	
}
