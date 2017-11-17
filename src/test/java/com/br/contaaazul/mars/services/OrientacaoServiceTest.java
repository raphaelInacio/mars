package com.br.contaaazul.mars.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.br.contaaazul.mars.enums.ComandoEnum;
import com.br.contaaazul.mars.enums.OrientacaoEnum;
import com.br.contaaazul.mars.services.OrientacaoService;

public class OrientacaoServiceTest {
	
	@Autowired
	private OrientacaoService orientacaoService = new OrientacaoServiceImpl();

	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoComandoLeftUmaUnicaVezDeveRetornarOeste() {
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.L, OrientacaoEnum.NORTH);
		assertEquals(OrientacaoEnum.WEST, orientacao);
	}
	
	@Test
	public void dadoPosicaoInicialSejaLestQuandoEnviadoComandoRigthUmaUnicaVezDeveRetornarSul() {
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.R, OrientacaoEnum.EAST);
		assertEquals(OrientacaoEnum.SOUTH, orientacao);
	}
	
	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoComandoRigthUmaUnicaVezDeveRetornarLeste() {
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.R, OrientacaoEnum.NORTH);
		assertEquals(OrientacaoEnum.EAST, orientacao);
	}

}
