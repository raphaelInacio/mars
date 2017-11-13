package com.br.contaaazul.mars.service;

import org.springframework.http.ResponseEntity;

import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.Posicao;

public interface RoboService {
	ResponseEntity<Posicao> aplicar(Controle cordendas);
}
