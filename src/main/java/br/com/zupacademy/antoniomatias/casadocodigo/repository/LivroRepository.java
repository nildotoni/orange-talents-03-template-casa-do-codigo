package br.com.zupacademy.antoniomatias.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Livro;
//1
@Repository
public interface LivroRepository extends CrudRepository<Livro,Long>{

}
