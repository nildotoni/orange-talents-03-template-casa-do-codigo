package br.com.zupacademy.antoniomatias.casadocodigo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.CategoriaRepository;

public class CategoriaForm {

	@NotBlank(message = "O nome da categoria não pode ser branco") 
	@NotNull(message = "O nome da categoria não pode ser nulo") 
	@Length(min = 3, max = 30, message = "O nome da categoria deve ter até 30 caracteres")	
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter(CategoriaRepository categoriaRepository) {
		return new Categoria(nome);
	}
	
	
	
}
