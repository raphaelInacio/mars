package com.br.contaaazul.mars.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.CordenadasTest;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private DeslocamentoService deslocamentoService;

	@Autowired
	private OrientacaoService orientacaoService;

	private int deslocamento;
	private int posicaoBase;
	private String areaPercorrida;
	private OrientacaoEnum orientacao;
	private Area area = new Area();
	private Posicao posicaoFinal;
	private Posicao posicaoInicial;

	@Override
	public Posicao percorreTerreno(Cordenada cordenada, Posicao posicaoInicial) {

		this.posicaoInicial = posicaoInicial;

		for (ComandoEnum comandoEnum : cordenada.getComandos()) {
			if (ComandoEnum.M.equals(comandoEnum)) {
				deslocamento = deslocamentoService.processar(comandoEnum);
				processar();
			} else {
				orientacao = orientacaoService.processar(comandoEnum, posicaoInicial);
				processar();
			}

		}

		return this.posicaoFinal;
	}

	private void processar() {
		if (OrientacaoEnum.WEST.equals(orientacao)) {
			areaPercorrida = area.getTamanho()[posicaoInicial.getCartesianoX() + posicaoBase][posicaoInicial
					.getCartesianoY() + deslocamento];
		} else {
			areaPercorrida = area.getTamanho()[posicaoInicial.getCartesianoX() + deslocamento][posicaoInicial
					.getCartesianoY() + posicaoBase];
		}

		String[] posicoes = areaPercorrida.split("|");

		posicaoFinal = new Posicao(Integer.parseInt(posicoes[0]), Integer.parseInt(posicoes[2]), orientacao);
	}

}
