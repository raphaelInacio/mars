package com.br.contaaazul.mars.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ControleEnum;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.Posicao;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {
	
	@Autowired
	private AreaService areaService;
	
	@Test
	public void test() {
		Cordenada cordenada = new Cordenada(ControleEnum.M,ControleEnum.M,ControleEnum.L);
		Posicao posicao = areaService.percorreTerreno(cordenada, new Posicao());
		assertEquals("(0,2,W)", posicao.getSaida());
	}

}
