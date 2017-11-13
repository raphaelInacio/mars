package com.br.contaaazul.mars.service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.Posicao;

public class DeslocamentoSul implements Deslocamento {

	@Override
	public String iniciar(Posicao posicaoAtual, Area area) {
		return area.getDimensao()[posicaoAtual.getCartesianoX()][posicaoAtual.getCartesianoY()
		                                     					- deslocamento];
	}

}
