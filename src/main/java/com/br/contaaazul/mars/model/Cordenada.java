package com.br.contaaazul.mars.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cordenada{

	private ControleEnum primeiroComando;
	private ControleEnum segundoComando;
	private ControleEnum terceiroComando;

	public Cordenada(ControleEnum cartesianoX, ControleEnum cartesianoY, ControleEnum orientacao) {
		this.primeiroComando = cartesianoX;
		this.segundoComando = cartesianoY;
		this.terceiroComando = orientacao;
	}

}
