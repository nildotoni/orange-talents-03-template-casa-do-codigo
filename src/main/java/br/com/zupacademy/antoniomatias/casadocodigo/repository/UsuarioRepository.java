package br.com.zupacademy.antoniomatias.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

}
