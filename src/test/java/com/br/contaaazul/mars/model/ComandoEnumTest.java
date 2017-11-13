package com.br.contaaazul.mars.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComandoEnumTest {

	@Test
	public void deveReceberUmaStringERetornarOValorEnumEquivalente() {
		assertEquals(ComandoEnum.M, ComandoEnum.mapStringToEnum("M"));
		assertEquals(ComandoEnum.R, ComandoEnum.mapStringToEnum("R"));
		assertEquals(ComandoEnum.L, ComandoEnum.mapStringToEnum("L"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void deveLancarUmaIlleArgumentExceptionQuandoUmValorInvalidoForEnviado() {
		ComandoEnum.mapStringToEnum("Z");
	}

}
