package com.br.contaaazul.mars.service;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class AreaServiceImpl implements AreaService {
	
	private int posicaoCartesianaX;
	private int posicaoCartesianaY;
	
	@Override
	public Posicao percorreTerreno(Cordenada cordenada, Posicao posicaoInicial) {
		
		Area area = new Area();
		Posicao posicaoFinal = new Posicao();

		posicaoCartesianaX = 0;
		posicaoCartesianaY = 0;
		
		posicaoCartesianaX = cordenada.getCartesianoX().getValor() + posicaoInicial.getCartesianoX();
		posicaoCartesianaY = cordenada.getCartesianoY().getValor() + posicaoInicial.getCartesianoY();
		
		String areaPercorrida = area.getTamanho()[posicaoCartesianaX][posicaoCartesianaY];		
		
		System.out.println(areaPercorrida);
		
		return posicaoFinal;
	}
	
}
