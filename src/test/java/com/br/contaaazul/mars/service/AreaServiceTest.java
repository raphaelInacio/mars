package com.br.contaaazul.mars.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;
public class AreaServiceTest {

	private AreaService areaService;
	
	@Before
	public void init() {
		areaService = new AreaServiceImpl(new OrientacaoServiceImpl());
	}
	
	@Test
	public void deveRealizarMovimentosComRotacosADireita() throws AreaException {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.M, ComandoEnum.M, ComandoEnum.R, ComandoEnum.M, ComandoEnum.M, ComandoEnum.R, ComandoEnum.M, ComandoEnum.M);
		Controle cordenada = new Controle(comandos);
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Posicao(), new Area());
		assertEquals("(2,0,S)", posicao.getSaida());
	}
	
	@Test
	public void deveAndarDuasPosicoesParaNorteEVirarParaOeste() throws AreaException {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.M, ComandoEnum.M, ComandoEnum.L);
		Controle cordenada = new Controle(comandos);
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Posicao(), new Area());
		assertEquals("(0,2,W)", posicao.getSaida());
	}

	@Test
	public void deveVirarParaSulEAndarDuasPosicoes() throws AreaException {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.L, ComandoEnum.M, ComandoEnum.M);
		Controle cordenada = new Controle(comandos);
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Posicao(0, 2, OrientacaoEnum.WEST), new Area());
		assertEquals("(0,0,S)", posicao.getSaida());
	}

	@Test
	public void deveVirarParaLesteAndarDuasPosicoes() throws AreaException {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.R, ComandoEnum.M, ComandoEnum.M);
		Controle cordenada = new Controle(comandos);
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Posicao(), new Area());
		assertEquals("(2,0,E)", posicao.getSaida());
	}

	@Test
	public void deveVirarParaOesteAndarDuasPosicoes() throws AreaException {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.R, ComandoEnum.R, ComandoEnum.M, ComandoEnum.M);
		Controle cordenada = new Controle(comandos);
		Posicao posicao = areaService.percorrerTerreno(cordenada, new Posicao(2, 0, OrientacaoEnum.EAST), new Area());
		assertEquals("(0,0,W)", posicao.getSaida());
	}
	
	@Test(expected=AreaException.class)
	public void quandoEnviadoCordenadasInvalidasUmaAreaExcepetionDeveraSerLancada() throws AreaException {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.M, ComandoEnum.M, ComandoEnum.M, ComandoEnum.M, ComandoEnum.M, ComandoEnum.M, ComandoEnum.M, ComandoEnum.M);
		Controle cordenada = new Controle(comandos);
		areaService.percorrerTerreno(cordenada, new Posicao(), new Area());
	}

}
