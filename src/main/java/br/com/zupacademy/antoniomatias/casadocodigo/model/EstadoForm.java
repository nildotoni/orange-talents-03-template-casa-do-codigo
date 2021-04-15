package br.com.zupacademy.antoniomatias.casadocodigo.model;


import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue;

public class EstadoForm {
	@UniqueValue(domainClass=Estado.class, fieldName="nome", message=("O estado já está cadastrado no banco"))
	@NotNull(message="O Estado não pode ser nulo")
	@NotEmpty(message="O estado não pode ser vazio")
	private String nome;
	
	@NotNull(message="O id do id não pode ser em Vazio")
	private Long pais_id;
	
	

	public Long getPais_id() {
		return pais_id;
	}

	public String getNome() {
		return nome;
	}

	public Estado converte(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Pais> pais = paisRepository.findById(pais_id);
		if(pais.isPresent()) {
			return new Estado(nome,pais.get());
		}
		return null;
	}
	
	

}
