package com.br.contaaazul.mars.enums;

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

	public static boolean isMove(ComandoEnum comando) {
		return ComandoEnum.M.equals(comando);
	}

	public static boolean isRight(ComandoEnum comando) {
		return ComandoEnum.R.equals(comando);
	}

	public static boolean isLeft(ComandoEnum comando) {
		return ComandoEnum.L.equals(comando);
	}

}
