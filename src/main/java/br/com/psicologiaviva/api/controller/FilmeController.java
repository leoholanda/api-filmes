package br.com.psicologiaviva.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.psicologiaviva.api.dto.FilmeDTO;
import br.com.psicologiaviva.api.model.Filme;
import br.com.psicologiaviva.api.service.FilmeService;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
    public ResponseEntity<List<FilmeDTO>> consultarFilmes() {
    	List<FilmeDTO> filmes = service.consultaFilmesDoPersonagem();
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
	}
	
	@GetMapping("/episodio/{episodio}")
    public ResponseEntity<List<FilmeDTO>> consultarFilmesPorEpisodio(@PathVariable Long episodio) {
		List<FilmeDTO> filmes = service.consultaFilmesPorEpisodio(episodio);
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
	}
	
	@GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<FilmeDTO>> consultarFilmesPorTitulo(@PathVariable String titulo) {
		List<FilmeDTO> filmes = service.consultaFilmesPorTitulo(titulo);
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
	}
	
	@PostMapping
	public ResponseEntity<FilmeDTO> cadastrarFilme(@Valid @RequestBody Filme filme) {
		service.salva(filme);
		FilmeDTO filmeDTO = modelMapper.map(filme, FilmeDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(filmeDTO);
	}
}
