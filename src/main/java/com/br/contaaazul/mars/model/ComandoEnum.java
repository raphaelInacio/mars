package com.br.contaaazul.mars.model;

public enum ComandoEnum {

	R("R"), L("L"), M("M");

	private String value;

	private ComandoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ComandoEnum mapStringToEnum(String value) {
		switch (value) {
		case "R":
			return ComandoEnum.R;
		case "L":
			return ComandoEnum.L;
		case "M":
			return ComandoEnum.M;
		default:
			throw new IllegalArgumentException("Comando inválido");
		}
	}

}
