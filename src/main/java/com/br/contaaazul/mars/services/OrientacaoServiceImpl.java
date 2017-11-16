package com.br.contaaazul.mars.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.enums.ComandoEnum;
import com.br.contaaazul.mars.enums.OrientacaoEnum;

@Service
public class OrientacaoServiceImpl implements OrientacaoService {

	private static final Logger loggger = LoggerFactory.getLogger(OrientacaoServiceImpl.class);

	private OrientacaoEnum orientacao;

	@Override
	public OrientacaoEnum processar(ComandoEnum comando, OrientacaoEnum ultimaOrientacao) {

		loggger.info("Iniciando calibragem da orientação..");

		atualizarUltimaOrientacao(ultimaOrientacao);

		if (ComandoEnum.isLeft(comando))
			decrementaOriendacao();

		if (ComandoEnum.isRight(comando))
			incrementaOriendacao();

		loggger.info("Calibragem de orientação realizada {}", orientacao);

		return orientacao;
	}

	private void atualizarUltimaOrientacao(OrientacaoEnum ultimaOrientacao) {
		orientacao = ultimaOrientacao;
	}

	private void decrementaOriendacao() {
		if (OrientacaoEnum.getList().indexOf(orientacao) == 0) {
			this.orientacao = OrientacaoEnum.getList().get(3);
		} else {
			this.orientacao = OrientacaoEnum.getList().get(OrientacaoEnum.getList().indexOf(orientacao) - 1);
		}
	}

	private void incrementaOriendacao() {
		if (OrientacaoEnum.getList().indexOf(orientacao) == 3) {
			this.orientacao = OrientacaoEnum.getList().get(0);
		} else {
			this.orientacao = OrientacaoEnum.getList().get(OrientacaoEnum.getList().indexOf(orientacao) + 1);
		}
	}
}
