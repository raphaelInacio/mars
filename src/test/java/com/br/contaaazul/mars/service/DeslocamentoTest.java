package com.br.contaaazul.mars.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Cordenada;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeslocamentoTest {

	@Autowired
	private DeslocamentoService deslocamentoService;

	@Test
	public void deveRetorarTresQuandoEnviados1VezesM() {
		int deslocamento = deslocamentoService.processar(ComandoEnum.M);
		assertEquals(1, deslocamento);
	}

	@Test
	public void deveRetorarZeroQuandoNaoEnviadoM() {
		int deslocamento = deslocamentoService.processar(ComandoEnum.R);
		assertEquals(0, deslocamento);
	}

}
