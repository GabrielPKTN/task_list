package br.dev.gabriel.tarefas.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.gabriel.tarefas.dao.FuncionarioDAO;
import br.dev.gabriel.tarefas.model.Funcionario;
import br.dev.gabriel.tarefas.utils.Utils;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FuncionarioFrame {
	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSetor;
	private JLabel labelSalario;
	
	private JTextField textMatricula;
	private JTextField textNome;
	private JTextField textCargo;
	private JTextField textSetor;
	private JTextField textSalario;
	
	private JButton buttonSalvar;
	private JButton buttonSair;
	
	
	public FuncionarioFrame() {
		criaTela();
	}
	
	public void criaTela() {
		JFrame telaFuncionario = new JFrame();
		
		telaFuncionario.setSize(500, 500);
		telaFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaFuncionario.setLayout(null);
		telaFuncionario.setResizable(false);
		telaFuncionario.setLocationRelativeTo(null);
		
		Container painel = telaFuncionario.getContentPane();
		
		labelMatricula = new JLabel("Matricula: ");
		labelMatricula.setBounds(10, 20, 150, 30);
		textMatricula = new JTextField();
		textMatricula.setBounds(10, 50, 150, 30);
		textMatricula.setText(Utils.gerarUUID8());
		
		labelNome = new JLabel("Nome: ");
		labelNome.setBounds(10, 85, 150, 30);
		textNome = new JTextField();
		textNome.setBounds(10, 115, 350, 30);
		
		labelCargo = new JLabel("Cargo: ");
		labelCargo.setBounds(10, 150, 150, 30);
		textCargo = new JTextField();
		textCargo.setBounds(10, 180, 150, 30);
		
		labelSetor = new JLabel("Setor: ");
		labelSetor.setBounds(10, 215, 150, 30);
		textSetor = new JTextField();
		textSetor.setBounds(10, 245, 150, 30);
		
		labelSalario = new JLabel("Salário: ");
		labelSalario.setBounds(10, 280, 150, 30);
		textSalario = new JTextField();
		textSalario.setBounds(10, 310, 150, 30);
		
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(10, 380, 200, 40);
//		buttonSalvar.setOpaque(true);
//		buttonSalvar.setBackground(Color.green);
		
		buttonSair = new JButton("Sair");
		buttonSair.setBounds(220, 380, 120, 40);
		
		painel.add(labelMatricula);
		painel.add(textMatricula);
		painel.add(labelNome);
		painel.add(textNome);
		painel.add(labelCargo);
		painel.add(textCargo);
		painel.add(labelSetor);
		painel.add(textSetor);
		painel.add(labelSalario);
		painel.add(textSalario);
		painel.add(buttonSalvar);
		painel.add(buttonSair);
		
		buttonSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Funcionario f = new Funcionario(textNome.getText());
				f.setMatricula(textMatricula.getText());
				f.setNome(textMatricula.getText());
				f.setSetor(textSetor.getText());
				
				double salario = Double.parseDouble(textSalario.getText());
				f.setSalario(salario);
				
				FuncionarioDAO dao = new FuncionarioDAO(f);
				boolean sucesso = dao.gravar();
				
				if (sucesso) {
					JOptionPane.showMessageDialog(painel, "Funcionario gravado com sucesso");
					limparFormulario();
				} else {
					JOptionPane.showMessageDialog(painel, "Ocorreu um erro na gravação. \nTente novamente. \nSe o problema persistir, entre em contato com o suporte.");
				}
			
			
			}
		});
		
		buttonSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaFuncionario, "Confirma sair do sistema?", "Atenção!", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
					System.exit(JFrame.EXIT_ON_CLOSE);
				}
				
			}
		});
		
		telaFuncionario.setVisible(true);
	}
	
	private void limparFormulario() {
		textMatricula.setText(Utils.gerarUUID8());
		textNome.setText(null);
		textCargo.setText(null);
		textSetor.setText(null);
		textSalario.setText(null);
		textNome.requestFocus();
	}
}

	
