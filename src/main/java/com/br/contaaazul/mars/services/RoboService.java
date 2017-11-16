package com.br.contaaazul.mars.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface RoboService {
	ResponseEntity<String> aplicar(Optional<String> comandos);
	ResponseEntity<String> posicaoAtual();
}
