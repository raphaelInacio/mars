package com.br.contaaazul.mars.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.br.contaaazul.mars.enums.ComandoEnum;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Controle {
	
	private List<ComandoEnum> comandos = new ArrayList<>();

	public Controle(Optional<String> comandos) {
		if (!comandos.isPresent())
			throw new IllegalArgumentException("Comandos obrigatórios não informados");

		List<String> comandosEnviados = Arrays.asList(comandos.get().split(""));
		comandosEnviados.forEach(c -> {
			this.comandos.add(ComandoEnum.mapStringToEnum(c));
		});
	}
}
