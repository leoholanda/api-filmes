package br.com.psicologiaviva.api.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.psicologiaviva.api.dto.FilmeDTO;
import br.com.psicologiaviva.api.dto.PersonagemDTO;
import br.com.psicologiaviva.api.model.Filme;
import br.com.psicologiaviva.repository.FilmeRepository;

@Service
public class FilmeService implements Serializable {

	private static final long serialVersionUID = -1637329960622908811L;
	private static final Logger log = LoggerFactory.getLogger(FilmeService.class);
	
	@Autowired
	private FilmeRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private String urlApi = "https://swapi.dev/api/";
	private static final Long LUCK_SKYWALKER = 1L;
	

	public PersonagemDTO consultaPersonagem(Long codigo) {
		String uri = "people/{codigo}";
		PersonagemDTO people = WebClient
	            .create(urlApi)
	            .get()
	            .uri(uri, codigo)
	            .retrieve()
	            .bodyToMono(PersonagemDTO.class).block();
		
		return people;
	}

	public List<FilmeDTO> consultaFilmesDoPersonagem() {
		PersonagemDTO people = consultaPersonagem(LUCK_SKYWALKER);
		List<FilmeDTO> listaDeFilmes = new ArrayList<>();
		
		people.getFilms().stream().forEach((uri) -> {
			FilmeDTO filme = WebClient
		            .create(uri)
		            .get()
		            .retrieve()
		            .bodyToMono(FilmeDTO.class).block();
			
			listaDeFilmes.add(filme);
		});
		
		//Busca filme cadastrado no banco de dados
		repository.findByCodPeople(LUCK_SKYWALKER)
			.forEach((f) -> {
				FilmeDTO filmeDTO = modelMapper.map(f, FilmeDTO.class);
				listaDeFilmes.add(filmeDTO);
		});
			
		
		return listaDeFilmes;
	}
	
	public List<FilmeDTO> consultaFilmesPorEpisodio(Long episode) {
		return consultaFilmesDoPersonagem()
			.stream()
			.filter(f -> f.getEpisodeId() == episode)
			.collect(Collectors.toList());
	}
	
	public List<FilmeDTO> consultaFilmesPorTitulo(String titulo) {
		return consultaFilmesDoPersonagem()
			.stream()
			.filter(f -> f.getTitle().startsWith(titulo))
			.collect(Collectors.toList());
	}
	
	public void salva(Filme filme) {
		filme.setCodPeople(LUCK_SKYWALKER);
		filme.setReleaseDate(LocalDate.now());
		repository.save(filme);
		
		log.info(filme.toString());
		
	}
	
	
//	private String formatadorDeData(LocalDate releaseDate) {
//		String parsedDate = null;
//		if(releaseDate != null) {
//			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			parsedDate = releaseDate.format(formatters);
//		}
//	    
//	    return parsedDate;
//	}
	
}
