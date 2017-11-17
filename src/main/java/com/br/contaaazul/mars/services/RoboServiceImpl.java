package com.br.contaaazul.mars.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.repository.RoboRepository;
import com.br.contaaazul.mars.domain.Controle;
import com.br.contaaazul.mars.domain.Posicao;
import com.br.contaaazul.mars.domain.Robo;

@Service
@Transactional
public class RoboServiceImpl implements RoboService {

	private static final Logger loggger = LoggerFactory.getLogger(RoboServiceImpl.class);

	private static final String MSG_ERROR = "Posição inválida";

	private AreaService areaService;

	private RoboRepository roboRepository;
	
	@Autowired
	public RoboServiceImpl(AreaService areaService, RoboRepository roboRepository) {
		this.areaService = areaService;
		this.roboRepository = roboRepository;
	}

	@Override
	public ResponseEntity<String> aplicar(Optional<String> comandos) {

		loggger.info("Comandos recebidos, Iniciado processamento das informações {} ...", comandos);

		try {

			Optional<Robo> optionalRobo = buscarRobo();

			if (!optionalRobo.isPresent())
				throw new Exception();

			Robo robo = optionalRobo.get();

			Controle controle = new Controle(comandos);

			Posicao posicaoAtual = areaService.percorrerTerreno(controle, optionalRobo.get());

			robo.atualizarPosicao(posicaoAtual);

			roboRepository.save(robo);

			loggger.info("Informaçõs processadas com sucesso, nova posição {} ", posicaoAtual.getSaida());

			return new ResponseEntity<String>(posicaoAtual.getSaida(), HttpStatus.OK);

		} catch (AreaException e) {
			loggger.error("Não foi possível processar as informações enviados!");
			return new ResponseEntity<String>(MSG_ERROR, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			loggger.error("Houve um erro não esperado!");
			return new ResponseEntity<String>(MSG_ERROR, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> posicaoAtual() {
		loggger.info("Comandos recebidos, buscando posição atual...");
		Optional<Robo> robo = buscarRobo();
		if (robo.isPresent())
			return new ResponseEntity<String>(robo.get().ultimaPosicao().getSaida(), HttpStatus.OK);
		return new ResponseEntity<String>(MSG_ERROR, HttpStatus.BAD_REQUEST);
	}

	private Optional<Robo> buscarRobo() {
		if (roboRepository.existsById(1L)) {
			return roboRepository.findById(1L);
		} else {
			return Optional.of(roboRepository.save(new Robo()));
		}
	}

}
