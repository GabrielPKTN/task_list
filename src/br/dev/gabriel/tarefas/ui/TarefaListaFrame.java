package br.dev.gabriel.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton buttonCadastroTarefa;

	private DefaultTableModel model; // dados da tabela
	private JTable tabelaTarefas; // visual da tabela
	private JScrollPane scrollTarefas;

	String[] colunas = { "ID", "NOME TAREFA", "RESPONSAVEL", "STATUS", "DATA INÍCIO", "VENCIMENTO" };

	public TarefaListaFrame(JFrame pai) {
		criarTela(pai);
	}

	private void criarTela(JFrame pai) {
		JDialog telaTarefaLista = new JDialog(pai, "Lista de Funcionários", true);

		telaTarefaLista.setSize(715, 500);
		telaTarefaLista.setResizable(false);
		telaTarefaLista.setLayout(null);
		telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefaLista.setLocationRelativeTo(null);

		Container painel = telaTarefaLista.getContentPane();

		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);

		model = new DefaultTableModel(colunas, 10);
		tabelaTarefas = new JTable(model);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 70, 680, 300);

		buttonCadastroTarefa = new JButton("Cadastrar nova Tarefa");
		buttonCadastroTarefa.setBounds(10, 400, 250, 50);

		buttonCadastroTarefa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaFrame(telaTarefaLista);
			}
		});

		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(buttonCadastroTarefa);

		telaTarefaLista.setVisible(true);
		

	}
}
