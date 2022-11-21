package br.com.psicologiaviva.api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize
public class FilmeDTO implements Serializable {
	
	private static final long serialVersionUID = 5513488003463051802L;

	private String title;
	
	@JsonAlias({"episode_id"})
	private Long episodeId;
	
	private String director;
	
	@JsonAlias({"release_date"})
	private LocalDate releaseDate;
	
}
