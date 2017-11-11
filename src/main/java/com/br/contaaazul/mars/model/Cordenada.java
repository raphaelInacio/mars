package com.br.contaaazul.mars.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Cordenada{
	private List<ComandoEnum> comandos;
	
}
