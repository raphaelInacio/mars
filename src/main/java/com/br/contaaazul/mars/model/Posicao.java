package com.br.contaaazul.mars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Posicao {

	private int cartesianoX;
	private int cartesianoY;
	private OrientacaoEnum orientacao;

	public Posicao() {
		this.cartesianoX = 0;
		this.cartesianoY = 0;
		orientacao = OrientacaoEnum.NORTH;
	}

	public String getSaida() {
		return new StringBuilder().append("(").append(cartesianoX).append(",").append(cartesianoY).append(",")
				.append(orientacao.getValue()).append(")").toString();
	}
}
