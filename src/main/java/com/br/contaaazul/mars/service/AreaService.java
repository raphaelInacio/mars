package com.br.contaaazul.mars.service;

import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.Posicao;

public interface AreaService {
	Posicao percorreTerreno(Cordenada cordenada, Posicao posicaoInicial);
}
