package br.edu.insper.desagil.aps5.scrubs;

public class Medico extends Colaborador {
	private String especialidade;

	public Medico(String login, String nome, String especialidade) {
		super(login, nome, "Médico");
		this.especialidade = especialidade;
	}

	@Override
	public String titulo() {
		return "MD " + getNome() + " (" + especialidade + ")";
	}

	@Override
	public String subdominio() {
		return "md";
	}
}
