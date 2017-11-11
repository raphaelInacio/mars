package com.br.contaaazul.mars.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.ControleEnum;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.CordenadasTest;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class AreaServiceImpl implements AreaService {

	private int deslocamento;
	private int posicaoBase;
	private OrientacaoEnum orientacao;
	private List<OrientacaoEnum> orientacoes = Arrays.asList(OrientacaoEnum.NORTH, OrientacaoEnum.EAST,
			OrientacaoEnum.SOUTH, OrientacaoEnum.WEST);
	private String areaPercorrida;

	@Override
	public Posicao percorreTerreno(Cordenada cordenada, Posicao posicaoInicial) {

		Area area = new Area();
		orientacao = posicaoInicial.getOrientacao();

		processarDeslocamento(cordenada);
		processarOrientacaoParaDireita(cordenada);
		processarOrientacaoParaEsquerda(cordenada);

		if (OrientacaoEnum.WEST.equals(orientacao)) {
			areaPercorrida = area.getTamanho()[posicaoInicial.getCartesianoX() + posicaoBase][posicaoInicial
					.getCartesianoY() + deslocamento];
		} else {
			areaPercorrida = area.getTamanho()[posicaoInicial.getCartesianoX() + deslocamento][posicaoInicial
					.getCartesianoY() + posicaoBase];
		}

		String[] posicoes = areaPercorrida.split("|");

		Posicao posicaoFinal = new Posicao(Integer.parseInt(posicoes[0]), Integer.parseInt(posicoes[2]), orientacao);

		return posicaoFinal;
	}

	private void processarDeslocamento(Cordenada cordenada) {

		if (ControleEnum.M.equals(cordenada.getPrimeiroComando()))
			incrementaDeslocamento();

		if (ControleEnum.M.equals(cordenada.getPrimeiroComando()))
			incrementaDeslocamento();

		if (ControleEnum.M.equals(cordenada.getTerceiroComando()))
			incrementaDeslocamento();
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
			incrementaDeslocamento();

		if (ControleEnum.R.equals(cordenada.getPrimeiroComando()))
			incrementaDeslocamento();

		if (ControleEnum.R.equals(cordenada.getTerceiroComando()))
			incrementaDeslocamento();
	}

	private void incrementaDeslocamento() {
		this.deslocamento++;
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
