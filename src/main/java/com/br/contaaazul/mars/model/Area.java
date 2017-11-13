package com.br.contaaazul.mars.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.br.contaaazul.mars.exception.AreaException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Area {

	static final int VALOR_MINIMO = 5;
	private String[][] dimensao;
	private String dimensoes;
	private static final Logger loggger = LoggerFactory.getLogger(Area.class);

	public Area(int linha, int coluna) throws AreaException {
		if (linha == 0 || coluna == 0) {
			loggger.error("Dimensão informada é inválida!");
			throw new AreaException("Dimensões obirgatórias não informadas");
		}

		loggger.info("Criando area com dimensões personalizadas de {} X {}", linha, coluna);
		dimensao = new String[linha][coluna];
		popular(linha, coluna);
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
}
