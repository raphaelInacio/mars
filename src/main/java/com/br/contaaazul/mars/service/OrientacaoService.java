package com.br.contaaazul.mars.service;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

public interface OrientacaoService {

	OrientacaoEnum processar(ComandoEnum comando, OrientacaoEnum ultimaOrientacao);

}
