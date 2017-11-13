package com.br.contaaazul.mars.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControleTest {

	@Test
	public void deveConverterUmaStringDeComandosValidosEmUmArrayDeComandos() {
		Controle cordenada = new Controle("RRR");
		assertEquals(3, cordenada.getComandos().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarUmaExcecaoQuandoNullOuVazioForEnviado() {
		Controle cordenada = new Controle("");
	}

}
