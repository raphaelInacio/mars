package com.br.contaaazul.mars.model;

public enum ControleEnum {

	R(1, "R"), L(1, "L"), M(1, "M");
	private int valor;
	private String descricao;

	private ControleEnum(int valor, String descricao) {
		this.setValor(valor);
		this.setDescricao(descricao);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
