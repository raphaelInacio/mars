package com.br.contaaazul.mars.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doCallRealMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrientacaoTest {
	
	@Autowired
	private OrientacaoService orientacaoService;

	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoLUmaUnicaVezDeveRetornarWest() {
		Posicao posicaoInicial = new Posicao();
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.L, posicaoInicial);
		assertEquals(OrientacaoEnum.WEST, orientacao);
	}
	
	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoRUmaUnicaVezDeveRetornarEast() {
		Posicao posicaoInicial = new Posicao();
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.R, posicaoInicial);
		assertEquals(OrientacaoEnum.EAST, orientacao);
	}

}
