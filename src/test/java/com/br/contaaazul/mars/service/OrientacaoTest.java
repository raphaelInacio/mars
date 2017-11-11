package com.br.contaaazul.mars.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doCallRealMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ControleEnum;
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
		Cordenada cordenada = new Cordenada(ControleEnum.M, ControleEnum.M, ControleEnum.L);
		Posicao posicaoInicial = new Posicao();
		OrientacaoEnum orientacao = orientacaoService.processar(cordenada, posicaoInicial);
		assertEquals(OrientacaoEnum.WEST, orientacao);
	}
	
	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoRUmaUnicaVezDeveRetornarEast() {
		Cordenada cordenada = new Cordenada(ControleEnum.M, ControleEnum.M, ControleEnum.R);
		Posicao posicaoInicial = new Posicao();
		OrientacaoEnum orientacao = orientacaoService.processar(cordenada, posicaoInicial);
		assertEquals(OrientacaoEnum.EAST, orientacao);
	}

}
