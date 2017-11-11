package com.br.contaaazul.mars.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.ControleEnum;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class OrientacaoServiceImpl implements OrientacaoService {

	private OrientacaoEnum orientacao;
	private List<OrientacaoEnum> orientacoes = Arrays.asList(OrientacaoEnum.NORTH, OrientacaoEnum.EAST,
			OrientacaoEnum.SOUTH, OrientacaoEnum.WEST);

	@Override
	public OrientacaoEnum processar(Cordenada cordenada, Posicao posicaoInicial) {
		orientacao = posicaoInicial.getOrientacao();
		processarOrientacaoParaDireita(cordenada);
		processarOrientacaoParaEsquerda(cordenada);
		return orientacao;
	}

	private void processarOrientacaoParaEsquerda(Cordenada cordenada) {
		if (ControleEnum.L.equals(cordenada.getPrimeiroComando()))
			decrementaOriendacao();

		if (ControleEnum.L.equals(cordenada.getPrimeiroComando()))
			decrementaOriendacao();

		if (ControleEnum.L.equals(cordenada.getTerceiroComando()))
			decrementaOriendacao();
	}

	private void processarOrientacaoParaDireita(Cordenada cordenada) {
		if (ControleEnum.R.equals(cordenada.getPrimeiroComando()))
			incrementaOriendacao();

		if (ControleEnum.R.equals(cordenada.getPrimeiroComando()))
			incrementaOriendacao();

		if (ControleEnum.R.equals(cordenada.getTerceiroComando()))
			incrementaOriendacao();
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
