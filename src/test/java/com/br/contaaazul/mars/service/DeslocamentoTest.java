package com.br.contaaazul.mars.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ControleEnum;
import com.br.contaaazul.mars.model.Cordenada;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeslocamentoTest {

	@Autowired
	private DeslocamentoService deslocamentoService;

	@Test
	public void deveRetorarTresQuandoEnviados3VezesM() {
		Cordenada cordenada = new Cordenada(ControleEnum.M, ControleEnum.M, ControleEnum.M);
		int deslocamento = deslocamentoService.processar(cordenada);
		assertEquals(3, deslocamento);
	}

	@Test
	public void deveRetorarZeroQuandoNaoEnviadoM() {
		Cordenada cordenada = new Cordenada(ControleEnum.R, ControleEnum.R, ControleEnum.L);
		int deslocamento = deslocamentoService.processar(cordenada);
		assertEquals(0, deslocamento);
	}

}
