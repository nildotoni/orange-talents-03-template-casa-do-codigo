package br.com.zupacademy.antoniomatias.casadocodigo.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.AutorRepository;

public class AutorForm {
	
	//Atributos
	@NotNull @NotBlank
	@Column(length=60)
	@Size(min = 2, max = 60, message = "Coloque um nome")
	private String nome;
	
	@NotNull @NotBlank
	@Column(length=60)
	@Email(message = "Coloque um e-mail válido")
	private String email;
	
	@NotNull @NotBlank
	@Column(length=400)
	@Size(min = 5, max = 400, message = "Coloque uma descrição de até 400 Caracteres")
	private String descricao;
	
	//Métodos
	public Autor convert(AutorRepository autorRepository) {
		Autor autor = new Autor(nome, email, descricao);
		return autor;
	}
	
	//Getters
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}


	
	
}
