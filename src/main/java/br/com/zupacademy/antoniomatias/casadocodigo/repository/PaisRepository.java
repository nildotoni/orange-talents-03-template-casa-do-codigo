package br.com.zupacademy.antoniomatias.casadocodigo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Estado;
import br.com.zupacademy.antoniomatias.casadocodigo.model.Pais;

public interface PaisRepository  extends CrudRepository<Pais,Long>{
	
	

}
