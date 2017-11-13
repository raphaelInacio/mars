package com.br.contaaazul.mars.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.ComandoEnum;
import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.OrientacaoEnum;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class AreaServiceImpl implements AreaService {

	private static final Logger loggger = LoggerFactory.getLogger(AreaServiceImpl.class);

	@Autowired
	public AreaServiceImpl(OrientacaoService orientacaoService) {
		this.orientacaoService = orientacaoService;
	}

	private OrientacaoService orientacaoService;
	private Deslocamento deslocamentoService;
	private Area area;
	private Posicao posicaoAtual;
	private String areaPercorrida;
	private OrientacaoEnum orientacao;

	@Override
	public Posicao percorrerTerreno(Controle cordenada, Posicao ultimaPosicao, Area area) throws AreaException {

		loggger.info("Iniciando movimentação com robo no terreno...");

		try {

			atualizarPosicao(ultimaPosicao);
			atualizarArea(area);

			cordenada.getComandos().forEach(comandoEnum -> {
				if (isMovimento(comandoEnum)) {
					andar();
				} else {
					orientacao = orientacaoService.processar(comandoEnum, posicaoAtual.getOrientacao());
					atualizarOrientacao();
				}
			});

			return this.posicaoAtual;

		} catch (Exception e) {
			loggger.error("Houve um erro ao percorrer o terreno!");
			throw new AreaException("Posição inválida");
		}
	}
	
	private void andar() {
		deslocamentoService = calibrarDeslocamento();
		areaPercorrida = deslocamentoService.iniciar(posicaoAtual, area);
		salvarPosicao();
	}

	private boolean isMovimento(ComandoEnum comandoEnum) {
		return ComandoEnum.M.equals(comandoEnum);
	}

	private Deslocamento calibrarDeslocamento() {
		
		if (orientacao == null)
			orientacao = posicaoAtual.getOrientacao();

		if (OrientacaoEnum.SOUTH.equals(orientacao))
			return new DeslocamentoSul();

		if (OrientacaoEnum.NORTH.equals(orientacao))
			return new DeslocamentoNorte();

		if (OrientacaoEnum.EAST.equals(orientacao))
			return new DeslocamentoLeste();

		return new DeslocamentoOeste();
	}

	private void salvarPosicao() {
		String[] posicoes = areaPercorrida.split("|");
		posicaoAtual = new Posicao(Integer.parseInt(posicoes[0]), Integer.parseInt(posicoes[2]), orientacao);
		loggger.info("Nova posição salva {}", posicaoAtual.getSaida());
	}

	private void atualizarOrientacao() {
		posicaoAtual = new Posicao(posicaoAtual.getCartesianoX(), posicaoAtual.getCartesianoY(), orientacao);
		loggger.info("Nova orientação atualizada {}", posicaoAtual.getSaida());
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
