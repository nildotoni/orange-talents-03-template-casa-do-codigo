package br.com.zupacademy.antoniomatias.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank
	private String nome;
	
	//Metodos
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public Categoria() {
		
	}
	


	//getters
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
}
