package com.br.contaaazul.mars.services;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.br.contaaazul.mars.enums.OrientacaoEnum;
import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.domain.Controle;
import com.br.contaaazul.mars.domain.Posicao;
import com.br.contaaazul.mars.domain.Robo;
import com.br.contaaazul.mars.services.AreaService;
import com.br.contaaazul.mars.services.AreaServiceImpl;
import com.br.contaaazul.mars.services.OrientacaoServiceImpl;

public class AreaServiceTest {

	private AreaService areaService;

	@Before
	public void init() {
		areaService = new AreaServiceImpl(new OrientacaoServiceImpl());
	}

	@Test
	public void deveRealizarMovimentosComRotacosADireita() throws AreaException {
		Controle cordenada = new Controle(Optional.of("MMRMMRMM"));
		Robo robo = new Robo();
		Posicao posicao = areaService.percorrerTerreno(cordenada, robo);
		assertEquals("(2,0,S)", posicao.getSaida());
	}

	@Test
	public void deveAndarDuasPosicoesParaNorteEVirarParaOeste() throws AreaException {
		Controle cordenada = new Controle(Optional.of("MML"));
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Robo());
		assertEquals("(0,2,W)", posicao.getSaida());
	}

	@Test
	public void deveVirarParaSulEAndarDuasPosicoes() throws AreaException {
		Controle cordenada = new Controle(Optional.of("LMM"));
		Robo robo = new Robo();
		robo.getPosicoes().add(new Posicao(0, 2, OrientacaoEnum.WEST));
		Posicao posicao = areaService.percorrerTerreno(cordenada, robo);
		assertEquals("(0,0,S)", posicao.getSaida());
	}

	@Test
	public void deveVirarParaLesteAndarDuasPosicoes() throws AreaException {
		Controle cordenada = new Controle(Optional.of("RMM"));
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Robo());
		assertEquals("(2,0,E)", posicao.getSaida());
	}

	@Test
	public void deveVirarParaOesteAndarDuasPosicoes() throws AreaException {
		Controle cordenada = new Controle(Optional.of("RRMM"));
		Robo robo = new Robo();
		robo.getPosicoes().add(new Posicao(2, 0, OrientacaoEnum.EAST));
		Posicao posicao = areaService.percorrerTerreno(cordenada, robo);
		assertEquals("(0,0,W)", posicao.getSaida());
	}

	@Test(expected = AreaException.class)
	public void quandoEnviadoCordenadasInvalidasUmaAreaExcepetionDeveraSerLancada() throws AreaException {
		Controle cordenada = new Controle(Optional.of("MMMMMMMMMMMMMMMMMMMMMMM"));
		areaService.percorrerTerreno(cordenada, new Robo());
	}

}
