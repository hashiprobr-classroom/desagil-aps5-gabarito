package br.edu.insper.desagil.aps5.scrubs;

import java.util.HashMap;
import java.util.Map;

public class Prontuario {
	private Paciente paciente;
	private Medico medico;
	private Map<String, String> observacoes;

	public Prontuario(Paciente paciente, Medico medico) {
		this.paciente = paciente;
		this.medico = medico;
		this.observacoes = new HashMap<>();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public Map<String, String> getObservacoes() {
		return observacoes;
	}

	public void anota(Colaborador colaborador, String observacao) {
		observacoes.put(colaborador.getLogin(), observacao);
	}
}
