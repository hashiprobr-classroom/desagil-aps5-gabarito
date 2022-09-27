package br.edu.insper.desagil.aps5.scrubs;

public class Colaborador {
	private String login;
	private String nome;
	private String cargo;

	public Colaborador(String login, String nome, String cargo) {
		this.login = login;
		this.nome = nome;
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
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

	public String titulo() {
		return nome + " (" + cargo + ")";
	}

	public String subdominio() {
		return "";
	}
}
