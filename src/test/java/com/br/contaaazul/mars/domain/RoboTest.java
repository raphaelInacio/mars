package com.br.contaaazul.mars.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.br.contaaazul.mars.enums.OrientacaoEnum;
import com.br.contaaazul.mars.exception.AreaException;

public class RoboTest {

	@Test
	public void deveCriarUmNovoRoboComAsPosicoeseAreaDefault() {
		Robo robo = new Robo();
		assertNotNull(robo.getArea());
		assertNotNull(robo.getPosicoes());
		assertEquals("5X5", robo.getArea().getDimensoes());
		assertEquals("(0,0,N)", robo.ultimaPosicao().getSaida());
	}

	@Test
	public void deveCriarUmRoboComAreaInformada() throws AreaException {
		Robo robo = new Robo(new Area(10, 10));
		assertEquals("10X10", robo.getArea().getDimensoes());
	}

	@Test
	public void deveCriarUmRoboinformandoAreaEUmaListaDePosicoes() {
		List<Posicao> posicoes = new ArrayList<>();
		posicoes.add(new Posicao());
		posicoes.add(new Posicao(2, 2, OrientacaoEnum.EAST));
		
		Robo robo = new Robo(new Area(), posicoes);
		assertEquals("5X5", robo.getArea().getDimensoes());
		assertEquals("(2,2,E)", robo.ultimaPosicao().getSaida());
		assertEquals(2, robo.getPosicoes().size());
	}

	@Test
	public void deveObterSempreAUltimaPosicao() {
		List<Posicao> posicoes = new ArrayList<>();
		posicoes.add(new Posicao());
		posicoes.add(new Posicao(2, 2, OrientacaoEnum.EAST));
		
		Robo robo = new Robo(new Area(), posicoes);
		assertEquals("5X5", robo.getArea().getDimensoes());
		assertEquals("(2,2,E)", robo.ultimaPosicao().getSaida());
	}

}
