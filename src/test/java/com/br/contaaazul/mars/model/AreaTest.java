package com.br.contaaazul.mars.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.br.contaaazul.mars.exception.AreaException;

public class AreaTest {

	@Test
	public void deveCriarUmaAreaComAsDimencoesInformadas() throws AreaException {
		Area area = new Area(2,2);
		assertEquals("2X2", area.getDimensoes());
	}

	@Test(expected=AreaException.class)
	public void quandoInformadoDimensoesIgualZeroDeveLancarUmaAreaException() throws AreaException {
		new Area(0,0);
	}
	
	@Test
	public void quandoNaoInformadoAreaDeveCriarComDimensoesPadrao5X5() {
		Area area = new Area();
		assertEquals("5X5", area.getDimensoes());
	}

}
