package com.br.contaaazul.mars.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.OrientacaoEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrientacaoServiceTest {
	
	@Autowired
	private OrientacaoService orientacaoService;

	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoLUmaUnicaVezDeveRetornarWest() {
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.L, OrientacaoEnum.NORTH);
		assertEquals(OrientacaoEnum.WEST, orientacao);
	}
	
	@Test
	public void dadoPosicaoInicialSejaNorteQuandoEnviadoRUmaUnicaVezDeveRetornarEast() {
		OrientacaoEnum orientacao = orientacaoService.processar(ComandoEnum.R, OrientacaoEnum.NORTH);
		assertEquals(OrientacaoEnum.EAST, orientacao);
	}

}
