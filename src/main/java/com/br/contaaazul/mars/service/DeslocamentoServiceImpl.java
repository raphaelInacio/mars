package com.br.contaaazul.mars.service;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Cordenada;

@Service
public class DeslocamentoServiceImpl implements DeslocamentoService {

	private int deslocamento = 0;

	@Override
	public int processar(ComandoEnum comando) {

		if (ComandoEnum.M.equals(comando))
			incrementaDeslocamento();

		return deslocamento;
	}

	private void incrementaDeslocamento() {
		this.deslocamento++;
	}

}
