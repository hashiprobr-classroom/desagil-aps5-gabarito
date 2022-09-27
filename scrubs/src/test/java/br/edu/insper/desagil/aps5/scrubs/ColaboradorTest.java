package br.edu.insper.desagil.aps5.scrubs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColaboradorTest {
	private Colaborador c;

	// Como há apenas um teste, este método, a rigor, não
	// faz diferença. Mas não vejo problema em incluí-lo.

	@BeforeEach
	void setUp() {
		c = new Colaborador("joaos", "João Silva", "enfermeiro");
	}

	@Test
	void constroi() {
		assertEquals("", c.subdominio());
		assertEquals("João Silva (enfermeiro)", c.titulo());
	}
}
