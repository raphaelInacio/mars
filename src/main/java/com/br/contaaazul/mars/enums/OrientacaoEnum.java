package com.br.contaaazul.mars.enums;

import java.util.Arrays;
import java.util.List;

import com.br.contaaazul.mars.services.DeslocamentoService;
import com.br.contaaazul.mars.services.DeslocamentoLeste;
import com.br.contaaazul.mars.services.DeslocamentoNorte;
import com.br.contaaazul.mars.services.DeslocamentoOeste;
import com.br.contaaazul.mars.services.DeslocamentoSul;

public enum OrientacaoEnum {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	private String value;

	public static List<OrientacaoEnum> getList() {
		return Arrays.asList(OrientacaoEnum.NORTH, OrientacaoEnum.EAST, OrientacaoEnum.SOUTH, OrientacaoEnum.WEST);
	}

	private OrientacaoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static DeslocamentoService orientacaoState(OrientacaoEnum orientacao) {

		if (OrientacaoEnum.SOUTH.equals(orientacao))
			return new DeslocamentoSul();

		if (OrientacaoEnum.NORTH.equals(orientacao))
			return new DeslocamentoNorte();

		if (OrientacaoEnum.EAST.equals(orientacao))
			return new DeslocamentoLeste();

		return new DeslocamentoOeste();
	}

}
