package br.com.zupacademy.antoniomatias.casadocodigo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue;

public class PaisForm {
	@UniqueValue(domainClass=Pais.class, fieldName="nome",message="O Pais já está cadastrado")
	@NotBlank(message="O País não pode ser em branco") 
	@NotEmpty(message="O País não pode ser em vazio")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Pais converter(PaisRepository paisRepository) {
		return new Pais(nome);
	}

}
