package com.br.contaaazul.mars.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.contaaazul.mars.services.RoboService;

@RestController
@RequestMapping("/rest/mars")
public class RoboController {

	@Autowired
	private RoboService roboService;

	@GetMapping(value = "/{comandos}")

	public @ResponseBody ResponseEntity<String> aplicarComandos(@PathVariable Optional<String> comandos) {
		return roboService.aplicar(comandos);

	}

	@GetMapping(value = "/robo/position")
	public @ResponseBody ResponseEntity<String> last() {
		return roboService.posicaoAtual();

	}
}
