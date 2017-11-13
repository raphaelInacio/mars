package com.br.contaaazul.mars.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.OrientacaoEnum;

@Service
public class OrientacaoServiceImpl implements OrientacaoService {

	private OrientacaoEnum orientacao;
	private List<OrientacaoEnum> orientacoes = Arrays.asList(OrientacaoEnum.NORTH, OrientacaoEnum.EAST,
			OrientacaoEnum.SOUTH, OrientacaoEnum.WEST);
	private static final Logger loggger = LoggerFactory.getLogger(OrientacaoServiceImpl.class);

	@Override
	public OrientacaoEnum processar(ComandoEnum comando, OrientacaoEnum ultimaOrientacao) {
		loggger.info("Iniciando calibragem da orientação..");
		orientacao = ultimaOrientacao;
		if (ComandoEnum.L.equals(comando))
			decrementaOriendacao();
		if (ComandoEnum.R.equals(comando))
			incrementaOriendacao();
		loggger.info("Calibragem de orientação realizada {}", orientacao);
		return orientacao;
	}

	private void decrementaOriendacao() {
		if (orientacoes.indexOf(orientacao) == 0) {
			this.orientacao = orientacoes.get(3);
		} else {
			this.orientacao = orientacoes.get(orientacoes.indexOf(orientacao) - 1);
		}
	}

	private void incrementaOriendacao() {
		if (orientacoes.indexOf(orientacao) == 3) {
			this.orientacao = orientacoes.get(0);
		} else {
			this.orientacao = orientacoes.get(orientacoes.indexOf(orientacao) + 1);
		}
	}
}
