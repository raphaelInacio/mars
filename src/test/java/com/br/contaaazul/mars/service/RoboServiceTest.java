package com.br.contaaazul.mars.service;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.Posicao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoboServiceTest {
	
	@Autowired
	private RoboService roboService;
	
	@Test
	public void deveAplicarUmaCordenada() {
		List<ComandoEnum> comandos = Arrays.asList(ComandoEnum.M, ComandoEnum.M, ComandoEnum.L);
		Controle cordenada = new Controle(comandos);
		ResponseEntity<Posicao> posicao = roboService.aplicar(cordenada);
	}

}
