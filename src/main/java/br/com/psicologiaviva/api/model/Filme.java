package br.com.psicologiaviva.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "filme")
public class Filme implements Serializable {

	private static final long serialVersionUID = -6557082943162152824L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Column(name = "episode_id")
	private Long episodeId;
	
	private String director;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	private Long codPeople;

}
