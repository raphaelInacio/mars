package com.br.contaaazul.mars.model;

public enum OrientacaoEnum {
	
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String value;

	private OrientacaoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	

}
