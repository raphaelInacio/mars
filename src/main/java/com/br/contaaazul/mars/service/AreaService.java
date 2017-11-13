package com.br.contaaazul.mars.service;

import com.br.contaaazul.mars.exception.AreaException;
import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.Controle;
import com.br.contaaazul.mars.model.Posicao;

public interface AreaService {
	Posicao percorrerTerreno(Controle cordenada, Posicao ultimaPosicao, Area area) throws AreaException;
}
