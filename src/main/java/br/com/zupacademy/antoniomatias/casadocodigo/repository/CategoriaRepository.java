package br.com.zupacademy.antoniomatias.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Categoria;
//1
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Long> {

	Optional<Categoria> findByNome(String nome);
	Optional<Categoria> findById(Long in);
}
