package br.dev.gabriel.tarefas.model;

public class Funcionario {

	private String nome;
	private String cargo;
	private String setor;
	
	public Funcionario() {
		System.out.println("Criando um funcionário...");
	}

	public Funcionario(String nome, String cargo, String setor) {
		System.out.println("criando um funocionario com nome");
		this.nome = nome;
		this.cargo = cargo;
		this.setor = setor;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
