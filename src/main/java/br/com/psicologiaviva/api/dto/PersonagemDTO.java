package br.com.psicologiaviva.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class PersonagemDTO {
	
	@JsonAlias({"name"})
	private String nome;
	
	private List<String> films;

}
