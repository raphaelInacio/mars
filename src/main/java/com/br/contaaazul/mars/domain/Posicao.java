package com.br.contaaazul.mars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.br.contaaazul.mars.enums.OrientacaoEnum;

import lombok.Data;
@Data
@Entity
public class Posicao {
	@Id
	@GeneratedValue
	private Long id;
	private int cartesianoX;
	private int cartesianoY;
	@ManyToOne
	private Robo robo;

	private OrientacaoEnum orientacao;

	public Posicao() {
		this.cartesianoX = 0;
		this.cartesianoY = 0;
		orientacao = OrientacaoEnum.NORTH;
	}

	public Posicao(int cartesianoX, int cartesianoY, OrientacaoEnum orientacao) {
		this.cartesianoX = cartesianoX;
		this.cartesianoY = cartesianoY;
		this.orientacao = orientacao;

	}

	public String getSaida() {
		return new StringBuilder().append("(").append(cartesianoX).append(",").append(cartesianoY).append(",")
				.append(orientacao.getValue()).append(")").toString();
	}
}
