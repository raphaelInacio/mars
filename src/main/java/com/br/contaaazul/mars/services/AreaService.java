package com.br.contaaazul.mars.services;

import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.domain.Controle;
import com.br.contaaazul.mars.domain.Posicao;
import com.br.contaaazul.mars.domain.Robo;

public interface AreaService {
	Posicao percorrerTerreno(Controle comandos, Robo robo) throws AreaException;
}
