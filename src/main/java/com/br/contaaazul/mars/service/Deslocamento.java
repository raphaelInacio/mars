package com.br.contaaazul.mars.service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.Posicao;

public interface Deslocamento {
	public static final int deslocamento = 1;
	String iniciar(Posicao posicaoAtual, Area area);
}
