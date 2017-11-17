package com.br.contaaazul.mars.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.br.contaaazul.mars.services.RoboService;

@RunWith(SpringRunner.class)
@WebMvcTest(RoboController.class)
public class RoboControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RoboService roboService;

	@Test
	public void deveFazerUmaChamdaHttpNoRobo() throws Exception {
		given(this.roboService.aplicar(Optional.of("MMRMMRMM"))).willReturn(new ResponseEntity<String>("(2,0,S)", HttpStatus.OK));
		mvc.perform(post("/rest/mars/MMRMMRMM").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$").value("(2,0,S)"));
	}

	@Test
	public void deveRetornar404QuandoUmaPosicaoInvalidaForEnviada() throws Exception {
		given(this.roboService.aplicar(Optional.of("MMMMMMMMMMMMMMMMMMMMMMMM")))
				.willReturn(new ResponseEntity<String>("Posição inválida", HttpStatus.BAD_REQUEST));
		mvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andExpect(jsonPath("$").value("Posição inválida"));
	}

	@Test
	public void deveREceberAUltimaPosicaoDoRobo() throws Exception {
		given(this.roboService.posicaoAtual()).willReturn(new ResponseEntity<String>("(0,0,N)", HttpStatus.OK));
		mvc.perform(post("/rest/mars/robo/position").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$").value("(0,0,N)"));
	}

}
