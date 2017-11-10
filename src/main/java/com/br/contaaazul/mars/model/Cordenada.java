package com.br.contaaazul.mars.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cordenada{

	private ControleEnum cartesianoX;
	private ControleEnum cartesianoY;
	private ControleEnum orientacao;

	public Cordenada(ControleEnum cartesianoX, ControleEnum cartesianoY, ControleEnum orientacao) {
		this.cartesianoX = cartesianoX;
		this.cartesianoY = cartesianoY;
		this.orientacao = orientacao;
	}

}
