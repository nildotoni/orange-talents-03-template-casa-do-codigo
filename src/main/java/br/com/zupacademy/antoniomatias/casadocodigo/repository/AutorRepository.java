package br.com.zupacademy.antoniomatias.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}
