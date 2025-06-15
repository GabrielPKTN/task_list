package br.dev.gabriel.tarefas.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import br.dev.gabriel.tarefas.dao.TarefaDAO;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton buttonNovaTarefa;

	private DefaultTableModel model;
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	
	Container painel;
	
	String[] colunas = { "ID", "TAREFA", "STATUS", "RESPONSÁVEL", "INÍCIO", "ENTREGA" };

	TarefaDAO dao;

	public TarefaListaFrame(JFrame pai) {
		criarTela(pai);

	}

	private void criarTela(JFrame pai) {
		
		JDialog telaTarefaLista = new JDialog(pai, "Lista de tarefas", true);
		telaTarefaLista.setSize(715, 500);
		telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefaLista.setLayout(null);
		telaTarefaLista.setLocationRelativeTo(null);
		telaTarefaLista.setResizable(false);
		
		painel = telaTarefaLista.getContentPane();
		
		labelTitulo = new JLabel("Registro de Tarefas");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);

		scrollTarefas = new JScrollPane();
		scrollTarefas.setBounds(10, 70, 600, 300);
		
		model = new DefaultTableModel(colunas, 0);
		tabelaTarefas = new JTable(model);

		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 70, 680, 300);

		buttonNovaTarefa = new JButton("Registrar nova tarefa");
		buttonNovaTarefa.setBounds(10, 400, 250, 50);

		painel.add(scrollTarefas);
		painel.add(labelTitulo);
		painel.add(buttonNovaTarefa);
		
		telaTarefaLista.setVisible(true);
	}
	
}
