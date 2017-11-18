package com.br.contaaazul.mars.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.br.contaaazul.mars.domain.Posicao;

@Entity
public class Robo {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Posicao> posicoes = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	private Area area;

	public Robo() {
		this.area = new Area();
		this.posicoes.add(new Posicao());
	}

	public Robo(Area area) {
		this.area = area;
		this.posicoes.add(new Posicao());
	}

	public Robo(Area area, List<Posicao> posicoes) {
		this.area = area;
		this.posicoes = posicoes;
	}

	public Posicao ultimaPosicao() {
		if (posicoes.isEmpty()) {
			posicoes.add(new Posicao());
		}
		return posicoes.get(posicoes.size() - 1);
	}

	public void atualizarPosicao(Posicao ultimaPosicao) {
		if (posicoes.isEmpty()) {
			posicoes.add(new Posicao());
		}
		posicoes.add(ultimaPosicao);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Posicao> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(List<Posicao> posicoes) {
		this.posicoes = posicoes;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Long getId() {
		return id;
	}

}
