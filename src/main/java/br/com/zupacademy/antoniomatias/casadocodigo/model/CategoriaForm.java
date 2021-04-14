package br.com.zupacademy.antoniomatias.casadocodigo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue;
//3
public class CategoriaForm {
	//1
	@UniqueValue(domainClass=Categoria.class, fieldName="nome")
	@NotBlank(message = "O nome da categoria não pode ser branco") 
	@NotNull(message = "O nome da categoria não pode ser nulo") 
	@Length(min = 3, max = 30, message = "O nome da categoria deve ter até 30 caracteres")	
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter(CategoriaRepository categoriaRepository) {
		//1
		return new Categoria(nome);
	}

	public static Categoria convertByID(Long categoria_id, CategoriaRepository categoriaRepository) {
		//1
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
