package com.br.contaaazul.mars.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.Posicao;


@Service
public class RoboServiceImpl implements RoboService {

	private static final Logger loggger = LoggerFactory.getLogger(RoboServiceImpl.class);

	@Autowired
	private AreaService areaService;

	private Posicao ultimaPosicao;

	private Area area;

	@Override
	public ResponseEntity<Posicao> aplicar(Controle controle) {
		try {
			loggger.info("Comandos recebidos, Iniciado processamento das informações {} ...", controle);
			Posicao posicaoAtual = areaService.percorrerTerreno(controle, ultimaPosicao, area);
			loggger.info("Informaçõs processadas com sucesso, nova posição {} ", posicaoAtual.getSaida());
			return new ResponseEntity<Posicao>(posicaoAtual, HttpStatus.OK);
		} catch (AreaException e) {
			loggger.error("Não foi possível processar as informações enviados!");
			return new ResponseEntity<Posicao>(HttpStatus.BAD_REQUEST);
		}
	}

}
