package com.br.contaaazul.mars.services;

import com.br.contaaazul.mars.domain.Area;
import com.br.contaaazul.mars.domain.Posicao;

public interface DeslocamentoService {
	public static final int deslocamento = 1;
	String iniciar(Posicao posicaoAtual, Area area);
}
