package com.br.contaaazul.mars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.br.contaaazul.mars.exception.AreaException;

@Entity
public class Area {

	private static final Logger loggger = LoggerFactory.getLogger(Area.class);

	@Id
	@GeneratedValue
	private Long id;
	private int dimensaoX;
	private int dimensaoY;
	private String dimensoes;

	@Transient
	static final int VALOR_MINIMO = 5;
	@Transient
	private String[][] dimensao;

	public Area(int dimensaoX, int dimensaoY) throws AreaException {
		if (dimensaoX == 0 || dimensaoY == 0) {
			loggger.error("Dimensão informada é inválida!");
			throw new AreaException("Dimensões obirgatórias não informadas");
		}

		loggger.info("Criando area com dimensões personalizadas de {} X {}", dimensaoX, dimensaoY);
		this.dimensaoX = dimensaoX;
		this.dimensaoY = dimensaoY;
		dimensao = new String[dimensaoX][dimensaoY];
		popular(this.dimensaoX, dimensaoY);
	}

	public Area() {
		loggger.info("Criando area com dimensões padrões de {} X {}", VALOR_MINIMO, VALOR_MINIMO);
		dimensao = new String[VALOR_MINIMO][VALOR_MINIMO];
		popular(VALOR_MINIMO, VALOR_MINIMO);
	}

	private void popular(int tamanholinha, int tamanhocoluna) {
		dimensoes = new StringBuilder().append(tamanholinha).append("X").append(tamanhocoluna).toString();
		for (int linha = 0; linha < tamanholinha; linha++) {
			for (int coluna = 0; coluna < tamanhocoluna; coluna++) {
				dimensao[linha][coluna] = linha + "|" + coluna;
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDimensaoX() {
		return dimensaoX;
	}

	public void setDimensaoX(int dimensaoX) {
		this.dimensaoX = dimensaoX;
	}

	public int getDimensaoY() {
		return dimensaoY;
	}

	public void setDimensaoY(int dimensaoY) {
		this.dimensaoY = dimensaoY;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	public String[][] getDimensao() {
		return dimensao;
	}

	public void setDimensao(String[][] dimensao) {
		this.dimensao = dimensao;
	}

}
