package com.br.contaaazul.mars.model;

import lombok.Getter;

@Getter
public class Area {

	static final int VALOR_MINIMO = 5;
	
	private String[][] tamanho;

	public Area(int linha, int coluna) {
		tamanho = new String[linha][coluna];
	}

	public Area() {
		tamanho = new String[VALOR_MINIMO][VALOR_MINIMO];

		for (int linha = 0; linha < VALOR_MINIMO; linha++)
			for (int coluna = 0; coluna < VALOR_MINIMO; coluna++)
				tamanho[linha][coluna] = linha + "|" + coluna;
	}
}
