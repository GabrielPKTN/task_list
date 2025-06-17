package br.dev.gabriel.tarefas.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.dev.gabriel.tarefas.dao.FuncionarioDAO;
import br.dev.gabriel.tarefas.dao.TarefaDAO;
import br.dev.gabriel.tarefas.model.Funcionario;
import br.dev.gabriel.tarefas.model.Tarefa;
import br.dev.gabriel.tarefas.utils.Utils;

public class TarefaFrame {

	private JLabel labelID;
	private JTextField textID;

	private JLabel labelNome;
	private JTextField textNome;

	private JLabel labelDescricao;
	private JTextField textDescricao;

	private JLabel labelResponsavel;
	private JComboBox<String> boxResponsavel;

	// O status precisa ser adicionado automaticamente
	// isso é feito para evitar que o sistema tenha falhas
	// como definir o status de uma tarefa como atrasada dentro
	// do prazo.

	private JLabel labelDataInicio;
	private JTextField textDataInicio;

	private JLabel labelPrazo;
	private JTextField textPrazo;

	private JLabel labelDataEntrega;
	private JTextField textDataEntrega;

	private JButton buttonSalvar;
	private JButton buttonSair;

	public TarefaFrame(JDialog pai) {
		criarTela(pai);
	}

	private void criarTela(JDialog pai) {
		JDialog telaTarefa = new JDialog(pai, "Cadastro de Tarefas", true);

		telaTarefa.setSize(500, 550);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setLayout(null);
		telaTarefa.setResizable(false);
		telaTarefa.setLocationRelativeTo(null);

		Container painel = telaTarefa.getContentPane();

		labelID = new JLabel("ID da tarefa: ");
		labelID.setBounds(10, 20, 150, 30);
		textID = new JTextField();
		textID.setBounds(10, 50, 150, 30);
		textID.setEnabled(false);
		textID.setText(Utils.gerarUUID8());

		labelNome = new JLabel("Nome da tarefa: ");
		labelNome.setBounds(10, 85, 150, 30);
		textNome = new JTextField();
		textNome.setBounds(10, 115, 350, 30);

		labelDescricao = new JLabel("Descrição: ");
		labelDescricao.setBounds(10, 150, 150, 30);
		textDescricao = new JTextField();
		textDescricao.setBounds(10, 180, 150, 30);

		labelResponsavel = new JLabel("Responsavel pela tarefa: ");
		labelResponsavel.setBounds(10, 215, 150, 30);
		boxResponsavel = new JComboBox<String>();
		boxResponsavel.setBounds(10, 245, 150, 30);

		setElementosComboBox();

		labelDataInicio = new JLabel("Data de Início: ");
		labelDataInicio.setBounds(10, 280, 100, 30);
		textDataInicio = new JTextField();
		textDataInicio.setBounds(10, 310, 70, 30);

		labelPrazo = new JLabel("Prazo: ");
		labelPrazo.setBounds(110, 280, 150, 30);
		textPrazo = new JTextField();
		textPrazo.setBounds(110, 310, 50, 30);

		labelDataEntrega = new JLabel("Data de Entrega: ");
		labelDataEntrega.setBounds(10, 340, 150, 30);
		textDataEntrega = new JTextField();
		textDataEntrega.setBounds(10, 370, 150, 30);
		textDataEntrega.setEnabled(false);

		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(10, 430, 200, 40);
		
		buttonSair = new JButton("Sair");
		buttonSair.setBounds(220, 430, 200, 40);
		

		painel.add(labelID);
		painel.add(textID);
		painel.add(labelNome);
		painel.add(textNome);
		painel.add(labelDescricao);
		painel.add(textDescricao);
		painel.add(labelResponsavel);
		painel.add(boxResponsavel);
		painel.add(labelDataInicio);
		painel.add(textDataInicio);
		painel.add(labelPrazo);
		painel.add(textPrazo);
		painel.add(labelDataEntrega);
		painel.add(textDataEntrega);
		painel.add(buttonSalvar);
		painel.add(buttonSair);

		textPrazo.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				setDataEntrega();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				setDataEntrega();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				setDataEntrega();

			}

			private void setDataEntrega() {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String dataInicioString = textDataInicio.getText();

				LocalDate dataInicio = LocalDate.parse(dataInicioString, formatter);
				int prazo = Integer.parseInt(textPrazo.getText());

				LocalDate dataEntregaLocalDate = dataInicio.plusDays(prazo);

				DateTimeFormatter formatterString = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String dataEntregaFormatada = dataEntregaLocalDate.format(formatterString);

				textDataEntrega.setText(dataEntregaFormatada);
			}
		});

		buttonSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa tarefa = new Tarefa(textNome.getText());
				tarefa.setID(textID.getText());
				tarefa.setResponsavelByName(String.valueOf(boxResponsavel.getSelectedItem()));
				tarefa.setDescricao(textDescricao.getText());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String dataInicioString = textDataInicio.getText();

				LocalDate dataInicio = LocalDate.parse(dataInicioString, formatter);
				tarefa.setDataInicio(dataInicio);

				int prazo = Integer.parseInt(textPrazo.getText());
				LocalDate dataEntregaLocalDate = dataInicio.plusDays(prazo);

				tarefa.setDataEntrega(dataEntregaLocalDate);
				
				tarefa.getStatus();	
				
				TarefaDAO dao = new TarefaDAO(tarefa);
				boolean sucesso = dao.gravarTarefa();
				if (sucesso) {
					JOptionPane.showMessageDialog(painel, "Tarefa gravada com sucesso");
					limparFormulario();
				} else {
					JOptionPane.showMessageDialog(painel, "Ocorreu um erro na gravação. \nTente novamente. \nSe o problema persistir, entre em contato com o suporte.");
				}
			}
		});
		
		buttonSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaTarefa, "Confirma sair do sistema?", "Atenção!", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
					
				}
				telaTarefa.dispose();
				
			}
		});

		telaTarefa.setVisible(true);
	}

	private void setElementosComboBox() {
		FuncionarioDAO dao = new FuncionarioDAO(null);

		List<String> listaNomeFuncionarios = dao.getFuncionariosNomes();

		for (String nome : listaNomeFuncionarios) {
			boxResponsavel.addItem(nome);
		}
	}
	
	private void limparFormulario() {
		textID.setText(Utils.gerarUUID8());
		textNome.setText(null);
		textDescricao.setText(null);
		textDataInicio.setText(null);
		textPrazo.setText(null);
		textDataEntrega.setText(null);
		textNome.requestFocus();
	}
	
	
}