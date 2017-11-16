package com.br.contaaazul.mars.services;

import com.br.contaaazul.mars.enums.ComandoEnum;
import com.br.contaaazul.mars.enums.OrientacaoEnum;

public interface OrientacaoService {

	OrientacaoEnum processar(ComandoEnum comando, OrientacaoEnum ultimaOrientacao);

}
