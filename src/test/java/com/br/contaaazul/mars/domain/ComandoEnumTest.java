package com.br.contaaazul.mars.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.br.contaaazul.mars.enums.ComandoEnum;


public class ComandoEnumTest {

	@Test
	public void deveReceberUmaStringERetornarOValorEnumEquivalente() {
		assertEquals(ComandoEnum.M, ComandoEnum.mapStringToEnum("M"));
		assertEquals(ComandoEnum.R, ComandoEnum.mapStringToEnum("R"));
		assertEquals(ComandoEnum.L, ComandoEnum.mapStringToEnum("L"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarUmaIlleArgumentExceptionQuandoUmValorInvalidoForEnviado() {
		ComandoEnum.mapStringToEnum("Z");
	}

	@Test
	public void deveRetornarTrueSeComandoForM() {
		assertTrue(ComandoEnum.isMove(ComandoEnum.M));
	}

}
