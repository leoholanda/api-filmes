package br.com.psicologiaviva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.psicologiaviva.api.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findByCodPeople(Long people);

}
