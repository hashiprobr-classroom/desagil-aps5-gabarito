package br.edu.insper.desagil.aps5.scrubs;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.MockInitializer;

class HospitalTest {
	private Hospital h;

	@BeforeEach
	void setUp() {
		h = new Hospital("insper.edu.br", new ArrayList<>(), new ArrayList<>());
	}

	@Test
	void emailColaboradorSemSubdominio() {
		Colaborador colaborador;

		// Versão sem mock (seria aceita):
		// colaborador = new Colaborador("joaos", "João Silva", "enfermeiro");

		// Versão com mock:
		colaborador = mock(Colaborador.class);
		when(colaborador.getLogin()).thenReturn("joaos");
		when(colaborador.subdominio()).thenReturn("");

		assertEquals("joaos@insper.edu.br", h.email(colaborador));
	}

	@Test
	void emailColaboradorComSubdominio() {
		Colaborador colaborador;

		// Versão sem mock (seria aceita):
		// colaborador = new Medico("marias", "Maria Souza", "oncologia");

		// Versão com mock:
		colaborador = mock(Colaborador.class);
		when(colaborador.getLogin()).thenReturn("marias");
		when(colaborador.subdominio()).thenReturn("md");

		assertEquals("marias@md.insper.edu.br", h.email(colaborador));
	}

	@Test
	void cadastraNovoPaciente() {
		// Apenas como curiosidade, estou usando um mock de construtor.
		// https://ensino.hashi.pro.br/desagil/resumo/outros/mocks.html

		// Você não é obrigado a fazer isso, então, se quiser, pode
		// comentar as linhas 66-70, 72 e 74. Caso queira testar esse
		// código, substitua mockito-core por mockito-inline no pom.xml.

		MockInitializer<Paciente> initializer = (mock, context) -> {
			List<?> arguments = context.arguments();
			when(mock.getCpf()).thenReturn((String) arguments.get(0));
			when(mock.getNome()).thenReturn((String) arguments.get(1));
		};

		try (MockedConstruction<Paciente> mocked = mockConstruction(Paciente.class, initializer)) {
			h.cadastra("123.456.789-10", "João Souza");
		}

		List<String> esperada = new ArrayList<>();
		esperada.add("João Souza");

		assertEquals(esperada, h.nomesPacientes());
	}

	@Test
	void cadastraMesmoPacienteNovoNome() {
		// Apenas como curiosidade, estou usando um mock de construtor.
		// https://ensino.hashi.pro.br/desagil/resumo/outros/mocks.html

		// Você não é obrigado a fazer isso, então, se quiser, pode comentar
		// as linhas 91-95, 97, 99, 101-102, 105-106. Caso queira testar esse
		// código, substitua mockito-core por mockito-inline no pom.xml.

		MockInitializer<Paciente> initializer = (paciente, context) -> {
			List<?> arguments = context.arguments();
			when(paciente.getCpf()).thenReturn((String) arguments.get(0));
			when(paciente.getNome()).thenReturn((String) arguments.get(1));
		};

		Paciente paciente;

		try (MockedConstruction<Paciente> mocked = mockConstruction(Paciente.class, initializer)) {
			h.cadastra("123.456.789-10", "João Souza");
			paciente = mocked.constructed().get(0);
		}

		h.cadastra("123.456.789-10", "Maria Silva");
		verify(paciente).setNome("Maria Silva");
		when(paciente.getNome()).thenReturn("Maria Silva");

		List<String> esperada = new ArrayList<>();
		esperada.add("Maria Silva");

		assertEquals(esperada, h.nomesPacientes());
	}

	@Test
	void internaNaoInternado() {
		// Versão sem mock (seria aceita):
		// Paciente paciente = new Paciente("123.456.789-10", "João Souza");
		// Medico medico = new Medico("marias", "Maria Souza", "oncologia");

		// Versão com mock:

		Paciente paciente = mock(Paciente.class);
		when(paciente.getCpf()).thenReturn("123.456.789-10");

		Medico medico = mock(Medico.class);

		// Apenas como curiosidade, estou usando um mock de construtor.
		// https://ensino.hashi.pro.br/desagil/resumo/outros/mocks.html

		// Você não é obrigado a fazer isso, então, se quiser, pode
		// comentar as linhas 134 e 138. Caso queira testar esse código,
		// substitua mockito-core por mockito-inline no pom.xml.

		try (MockedConstruction<Prontuario> mocked = mockConstruction(Prontuario.class)) {
			assertDoesNotThrow(() -> {
				h.interna(paciente, medico, "COVID-19");
			});
		}
	}

	@Test
	void naoInternaInternado() {
		// Versão sem mock (seria aceita):
		// Paciente paciente1 = new Paciente("123.456.789-10", "João Souza");
		// Paciente paciente2 = new Paciente("123.456.789-10", "Maria Silva");
		// Medico medico = new Medico("marias", "Maria Souza", "oncologia");

		// Versão com mock:

		Paciente paciente1 = mock(Paciente.class);
		when(paciente1.getCpf()).thenReturn("123.456.789-10");

		Paciente paciente2 = mock(Paciente.class);
		when(paciente2.getCpf()).thenReturn("123.456.789-10");

		Medico medico = mock(Medico.class);

		// Apenas como curiosidade, estou usando um mock de construtor.
		// https://ensino.hashi.pro.br/desagil/resumo/outros/mocks.html

		// Você não é obrigado a fazer isso, então, se quiser, pode
		// comentar as linhas 165-168, 170, 176. Caso queira testar esse
		// código, substitua mockito-core por mockito-inline no pom.xml.

		MockInitializer<Prontuario> initializer = (prontuario, context) -> {
			List<?> arguments = context.arguments();
			when(prontuario.getPaciente()).thenReturn((Paciente) arguments.get(0));
		};

		try (MockedConstruction<Prontuario> mocked = mockConstruction(Prontuario.class, initializer)) {
			h.interna(paciente1, medico, "COVID-19");

			assertThrows(IllegalArgumentException.class, () -> {
				h.interna(paciente2, medico, "COVID-19");
			});
		}
	}

	@Test
	void internaComMesmoMedico() {
		// Versão sem mock (seria aceita):
		// Paciente paciente1 = new Paciente("123.456.789-10", "João Souza");
		// Paciente paciente2 = new Paciente("111.213.141-51", "Maria Silva");
		// Medico medico = new Medico("marias", "Maria Souza", "oncologia");

		// Versão com mock:

		Paciente paciente1 = mock(Paciente.class);
		when(paciente1.getCpf()).thenReturn("123.456.789-10");

		Paciente paciente2 = mock(Paciente.class);
		when(paciente2.getCpf()).thenReturn("111.213.141-51");

		Medico medico = mock(Medico.class);
		when(medico.getLogin()).thenReturn("marias");

		// Apenas como curiosidade, estou usando um mock de construtor.
		// https://ensino.hashi.pro.br/desagil/resumo/outros/mocks.html

		// Você não é obrigado a fazer isso, então, se quiser, pode
		// comentar as linhas 204-208, 210, 213. Caso queira testar esse
		// código, substitua mockito-core por mockito-inline no pom.xml.

		MockInitializer<Prontuario> initializer = (prontuario, context) -> {
			List<?> arguments = context.arguments();
			when(prontuario.getPaciente()).thenReturn((Paciente) arguments.get(0));
			when(prontuario.getMedico()).thenReturn((Medico) arguments.get(1));
		};

		try (MockedConstruction<Prontuario> mocked = mockConstruction(Prontuario.class, initializer)) {
			h.interna(paciente1, medico, "COVID-19");
			h.interna(paciente2, medico, "COVID-19");
		}

		List<String> esperada = new ArrayList<>();
		esperada.add("123.456.789-10");
		esperada.add("111.213.141-51");

		List<String> obtida = new ArrayList<>();
		for (Paciente paciente : h.pacientesDe("marias")) {
			obtida.add(paciente.getCpf());
		}

		assertEquals(esperada, obtida);
	}

	@Test
	void internaComMedicosDiferentes() {
		// Versão sem mock (seria aceita):
		// Paciente paciente1 = new Paciente("123.456.789-10", "João Souza");
		// Paciente paciente2 = new Paciente("111.213.141-51", "Maria Silva");
		// Medico medico1 = new Medico("marias", "Maria Souza", "oncologia");
		// Medico medico2 = new Medico("joaos", "João Silva", "oncologia");

		// Versão com mock:

		Paciente paciente1 = mock(Paciente.class);
		when(paciente1.getCpf()).thenReturn("123.456.789-10");

		Paciente paciente2 = mock(Paciente.class);
		when(paciente2.getCpf()).thenReturn("111.213.141-51");

		Medico medico1 = mock(Medico.class);
		when(medico1.getLogin()).thenReturn("marias");

		Medico medico2 = mock(Medico.class);
		when(medico2.getLogin()).thenReturn("joaos");

		// Apenas como curiosidade, estou usando um mock de construtor.
		// https://ensino.hashi.pro.br/desagil/resumo/outros/mocks.html

		// Você não é obrigado a fazer isso, então, se quiser, pode
		// comentar as linhas 256-260, 262, 265. Caso queira testar esse
		// código, substitua mockito-core por mockito-inline no pom.xml.

		MockInitializer<Prontuario> initializer = (prontuario, context) -> {
			List<?> arguments = context.arguments();
			when(prontuario.getPaciente()).thenReturn((Paciente) arguments.get(0));
			when(prontuario.getMedico()).thenReturn((Medico) arguments.get(1));
		};

		try (MockedConstruction<Prontuario> mocked = mockConstruction(Prontuario.class, initializer)) {
			h.interna(paciente1, medico1, "COVID-19");
			h.interna(paciente2, medico2, "COVID-19");
		}

		List<String> esperada, obtida;

		esperada = new ArrayList<>();
		esperada.add("123.456.789-10");

		obtida = new ArrayList<>();
		for (Paciente paciente : h.pacientesDe("marias")) {
			obtida.add(paciente.getCpf());
		}

		assertEquals(esperada, obtida);

		esperada = new ArrayList<>();
		esperada.add("111.213.141-51");

		obtida = new ArrayList<>();
		for (Paciente paciente : h.pacientesDe("joaos")) {
			obtida.add(paciente.getCpf());
		}

		assertEquals(esperada, obtida);
	}
}
