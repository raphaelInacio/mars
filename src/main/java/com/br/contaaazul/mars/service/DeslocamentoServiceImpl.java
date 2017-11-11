package com.br.contaaazul.mars.service;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.ControleEnum;
import com.br.contaaazul.mars.model.Cordenada;

@Service
public class DeslocamentoServiceImpl implements DeslocamentoService {

	private int deslocamento = 0;

	@Override
	public int processar(Cordenada cordenada) {
		
		if (ControleEnum.M.equals(cordenada.getPrimeiroComando()))
			incrementaDeslocamento();

		if (ControleEnum.M.equals(cordenada.getPrimeiroComando()))
			incrementaDeslocamento();

		if (ControleEnum.M.equals(cordenada.getTerceiroComando()))
			incrementaDeslocamento();
		
		return deslocamento;
	}

	private void incrementaDeslocamento() {
		this.deslocamento++;
	}

}
