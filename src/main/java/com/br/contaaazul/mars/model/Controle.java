package com.br.contaaazul.mars.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Controle {
	private List<ComandoEnum> comandos = new ArrayList<>();

	public Controle(String comandos) {
		if (StringUtils.isEmpty(comandos))
			throw new IllegalArgumentException("Comandos obrigatórios não informados");

		List<String> comandosEnviados = Arrays.asList(comandos.split(""));
		comandosEnviados.forEach(c -> {
			this.comandos.add(ComandoEnum.mapStringToEnum(c));
		});
	}
}
