package com.br.contaaazul.mars.domain;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.br.contaaazul.mars.domain.Controle;

public class ControleTest {

	@Test
	public void deveConverterUmaStringDeComandosValidosEmUmArrayDeComandos() {
		Controle cordenada = new Controle(Optional.of("RRR"));
		assertEquals(3, cordenada.getComandos().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarUmaExcecaoQuandoNullOuVazioForEnviado() {
		new Controle(Optional.ofNullable(null));
	}

}
