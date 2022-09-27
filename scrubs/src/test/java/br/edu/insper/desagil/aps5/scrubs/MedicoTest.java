package br.edu.insper.desagil.aps5.scrubs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicoTest {
	private Medico m;

	// Como há apenas um teste, este método, a rigor, não
	// faz diferença. Mas não vejo problema em incluí-lo.
	@BeforeEach
	void setUp() {
		m = new Medico("marias", "Maria Souza", "oncologia");
	}

	@Test
	void constroi() {
		assertEquals("md", m.subdominio());
		assertEquals("MD Maria Souza (oncologia)", m.titulo());
	}
}
