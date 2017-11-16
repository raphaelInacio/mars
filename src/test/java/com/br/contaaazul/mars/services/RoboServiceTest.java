package com.br.contaaazul.mars.services;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.contaaazul.mars.domain.Area;
import com.br.contaaazul.mars.domain.Posicao;
import com.br.contaaazul.mars.domain.Robo;
import com.br.contaaazul.mars.repository.RoboRepository;
import com.br.contaaazul.mars.services.RoboService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoboServiceTest {

	@Autowired
	private RoboService roboService;

	@Autowired
	private RoboRepository roboRepository;

	@Before
	public void init() {
		criarRobo();
	}

	public void criarRobo() {
		if (!roboRepository.existsById(1L)) {
			Area area = new Area();
			Robo robo = new Robo(area);
			roboRepository.save(robo);
		}
	}

	public void atualizarPosicaoBase() {
		Optional<Robo> optionalRobo = roboRepository.findById(1L);
		Robo robo = optionalRobo.get();
		robo.atualizarPosicao(new Posicao());
		roboRepository.save(robo);
	}

	public void destroy() {
		roboRepository.deleteAll();
	}

	@Test
	public void deveAplicarAsCordenadaEnviadas() {
		atualizarPosicaoBase();
		ResponseEntity<String> posicao = roboService.aplicar(Optional.of("MMRMMRMM"));
		assertEquals("(2,0,S)", posicao.getBody());
		assertEquals(HttpStatus.OK, posicao.getStatusCode());
	}

	@Test
	public void deveRetornarStatus400QuandCordenadaInvalidasForemEnviadas() {
		ResponseEntity<String> posicao = roboService.aplicar(Optional.of("MMMMMMMMMMMMMMMMMM"));
		assertEquals("Posição inválida", posicao.getBody());
		assertEquals(HttpStatus.BAD_REQUEST, posicao.getStatusCode());
	}

	@Test
	public void deveRecuperarUltimaPosicao() {
		roboService.aplicar(Optional.of("MMRMMRMM"));
		ResponseEntity<String> ultimaPosicao = roboService.posicaoAtual();
		assertEquals("(2,0,S)", ultimaPosicao.getBody());
		assertEquals(HttpStatus.OK, ultimaPosicao.getStatusCode());
	}

}
