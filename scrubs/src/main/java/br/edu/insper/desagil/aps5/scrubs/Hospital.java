package br.edu.insper.desagil.aps5.scrubs;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private String dominio;
	private List<Paciente> pacientes;
	private List<Prontuario> prontuarios;

	public Hospital(String dominio, List<Paciente> pacientes, List<Prontuario> prontuarios) {
		this.dominio = dominio;
		this.pacientes = pacientes;
		this.prontuarios = prontuarios;
	}

	public String email(Colaborador colaborador) {
		String subdominio = colaborador.subdominio();
		if (subdominio.length() > 0) {
			subdominio += ".";
		}
		return colaborador.getLogin() + "@" + subdominio + dominio;
	}

	public void cadastra(String cpf, String nome) {
		for (Paciente paciente : pacientes) {
			if (paciente.getCpf().equals(cpf)) {
				paciente.setNome(nome);
				return;
			}
		}
		Paciente paciente = new Paciente(cpf, nome);
		pacientes.add(paciente);
	}

	public void interna(Paciente paciente, Medico medico, String diagnostico) {
		String cpf = paciente.getCpf();
		for (Prontuario prontuario : prontuarios) {
			if (prontuario.getPaciente().getCpf().equals(cpf)) {
				throw new IllegalArgumentException("Paciente já está internado");
			}
		}
		Prontuario prontuario = new Prontuario(paciente, medico);
		prontuario.anota(medico, diagnostico);
		prontuarios.add(prontuario);
	}

	public List<String> nomesPacientes() {
		List<String> nomes = new ArrayList<>();
		for (Paciente paciente : pacientes) {
			nomes.add(paciente.getNome());
		}
		return nomes;
	}

	public List<Paciente> pacientesDe(String login) {
		List<Paciente> pacientes = new ArrayList<>();
		for (Prontuario prontuario : prontuarios) {
			if (prontuario.getMedico().getLogin().equals(login)) {
				pacientes.add(prontuario.getPaciente());
			}
		}
		return pacientes;
	}
}
