package com.br.contaaazul.mars.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class OrientacaoServiceImpl implements OrientacaoService {

	private OrientacaoEnum orientacao;
	private List<OrientacaoEnum> orientacoes = Arrays.asList(OrientacaoEnum.NORTH, OrientacaoEnum.EAST,
			OrientacaoEnum.SOUTH, OrientacaoEnum.WEST);

	@Override
	public OrientacaoEnum processar(ComandoEnum comando, Posicao posicaoInicial) {
		orientacao = posicaoInicial.getOrientacao();
		if (ComandoEnum.L.equals(comando))
			decrementaOriendacao();
		if (ComandoEnum.R.equals(comando))
			incrementaOriendacao();
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
