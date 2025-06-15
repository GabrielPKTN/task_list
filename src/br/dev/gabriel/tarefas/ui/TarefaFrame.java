package br.dev.gabriel.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.gabriel.tarefas.model.Status;
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
	
	private JLabel labelDataInicio;
	private JTextField textDataInicio;
	
	private JLabel labelStatus;
	private JComboBox<Status> boxStatus;
	
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
		JDialog telaTarefa = new JDialog(pai, "Registrar nova tarefa", true);

		telaTarefa.setSize(410, 500);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setLayout(null);
		telaTarefa.setResizable(false);
		telaTarefa.setLocationRelativeTo(null);

		Container painel = telaTarefa.getContentPane();

		labelID = new JLabel("ID da tarefa:");
		labelID.setBounds(10, 10, 150, 30);
		textID = new JTextField();
		textID.setBounds(10, 35, 150, 30);
		textID.setEnabled(false);
		textID.setText(Utils.gerarUUID8());

		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 65, 150, 30);
		textNome = new JTextField();
		textNome.setBounds(10, 90, 250, 30);

		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 120, 150, 30);
		textDescricao = new JTextField();
		textDescricao.setBounds(10, 145, 250, 30);

		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 175, 150, 30);
		boxResponsavel = new JComboBox<>();
		boxResponsavel.setBounds(10, 200, 200, 30);

		labelDataInicio = new JLabel("Data de início:");
		labelDataInicio.setBounds(10, 230, 100, 30);
		textDataInicio = new JTextField();
		textDataInicio.setBounds(10, 255, 100, 30);
		

		labelPrazo = new JLabel("Prazo(dias):");
		labelPrazo.setBounds(10, 285, 100, 30);
		textPrazo = new JTextField();
		textPrazo.setBounds(10, 310, 100, 30);

		labelPrazo = new JLabel("Data de entrega:");
		labelPrazo.setBounds(10, 340, 100, 30);
		textPrazo = new JTextField();
		textPrazo.setBounds(10, 365, 100, 30);
		textPrazo.setEditable(false);

		buttonSair = new JButton("Sair");
		buttonSair.setBounds(10, 410, 120, 40);

		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(260, 410, 120, 40);

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
		painel.add(labelPrazo);
		painel.add(textPrazo);


		painel.add(buttonSalvar);
		painel.add(buttonSair);		
	}
}
