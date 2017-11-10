package com.br.contaaazul.mars.service;

import org.springframework.stereotype.Service;

import com.br.contaaazul.mars.model.Area;
import com.br.contaaazul.mars.model.Cordenada;
import com.br.contaaazul.mars.model.Posicao;

@Service
public class RoboServiceImpl implements RoboService {
	
	private Area area;
	
	@Override
	public Posicao aplicar(Cordenada cordendas) {
		for(int linha=0 ; linha < 3 ; linha++){
            for(int coluna = 0; coluna < 3 ; coluna ++){
                System.out.printf("\t %d \t",area.getTamanho()[linha][coluna]);
            }
            System.out.println();
        }
		return null;
	}

}
