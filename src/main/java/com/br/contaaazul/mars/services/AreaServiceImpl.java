package com.br.contaaazul.mars.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.enums.ComandoEnum;
import com.br.contaaazul.mars.enums.OrientacaoEnum;
import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.domain.Area;
import com.br.contaaazul.mars.domain.Controle;
import com.br.contaaazul.mars.domain.Posicao;
import com.br.contaaazul.mars.domain.Robo;

@Service
public class AreaServiceImpl implements AreaService {

	private static final Logger loggger = LoggerFactory.getLogger(AreaServiceImpl.class);

	private OrientacaoService orientacaoService;
	private DeslocamentoService deslocamentoService;
	private Area area;
	private Posicao posicaoAtual;
	private String areaPercorrida;
	private OrientacaoEnum orientacao;

	@Autowired
	public AreaServiceImpl(OrientacaoService orientacaoService) {
		this.orientacaoService = orientacaoService;
	}

	@Override
	public Posicao percorrerTerreno(Controle comandos, Robo robo) throws AreaException {

		loggger.info("Iniciando movimentação com robo no terreno...");

		try {

			atualizarPosicao(robo.ultimaPosicao());
			atualizarArea(robo.getArea());

			comandos.getComandos().forEach(comandoEnum -> {
				if (ComandoEnum.isMove(comandoEnum)) {
					andar();
				} else {
					calibrarOrientacao(comandoEnum);
				}
			});

			return this.posicaoAtual;

		} catch (Exception e) {
			loggger.error("Houve um erro ao percorrer o terreno!");
			throw new AreaException("Posição inválida!");
		}
	}

	private void calibrarOrientacao(ComandoEnum comandoEnum) {
		orientacao = orientacaoService.processar(comandoEnum, posicaoAtual.getOrientacao());
		posicaoAtual = new Posicao(posicaoAtual.getCartesianoX(), posicaoAtual.getCartesianoY(), orientacao);
		loggger.info("Nova orientação atualizada {}", posicaoAtual.getSaida());
	}

	private void andar() {
		deslocamentoService = calibrarDeslocamento();
		areaPercorrida = deslocamentoService.iniciar(posicaoAtual, area);
		salvarPosicao();
	}

	private DeslocamentoService calibrarDeslocamento() {
		if (orientacao == null) 
			orientacao = posicaoAtual.getOrientacao();
		return OrientacaoEnum.orientacaoState(orientacao);
	}

	private void salvarPosicao() {
		String[] posicoes = areaPercorrida.split("|");
		posicaoAtual = new Posicao(Integer.parseInt(posicoes[0]), Integer.parseInt(posicoes[2]), orientacao);
		loggger.info("Nova posição salva {}", posicaoAtual.getSaida());
	}

	private void atualizarPosicao(Posicao ultimaPosicao) {
		this.posicaoAtual = ultimaPosicao;
		loggger.info("Nova posicao atualizada {}", ultimaPosicao.getSaida());
	}

	private void atualizarArea(Area area) {
		loggger.info("Atualizando area a ser percorrida {}", area);
		this.area = area;
	}

}
