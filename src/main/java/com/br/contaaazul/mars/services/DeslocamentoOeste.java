package com.br.contaaazul.mars.services;

import com.br.contaaazul.mars.domain.Area;
import com.br.contaaazul.mars.domain.Posicao;

public class DeslocamentoOeste implements DeslocamentoService {

	@Override
	public String iniciar(Posicao posicaoAtual, Area area) {
		return area.getDimensao()[posicaoAtual.getCartesianoX() - deslocamento][posicaoAtual.getCartesianoY()];
	}

}
