package com.br.contaaazul.mars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.br.contaaazul.mars.enums.OrientacaoEnum;

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

	public Long getId() {
		return id;
	}

	public int getCartesianoX() {
		return cartesianoX;
	}

	public int getCartesianoY() {
		return cartesianoY;
	}

	public Robo getRobo() {
		return robo;
	}

	public OrientacaoEnum getOrientacao() {
		return orientacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCartesianoX(int cartesianoX) {
		this.cartesianoX = cartesianoX;
	}

	public void setCartesianoY(int cartesianoY) {
		this.cartesianoY = cartesianoY;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}

	public void setOrientacao(OrientacaoEnum orientacao) {
		this.orientacao = orientacao;
	}
}
