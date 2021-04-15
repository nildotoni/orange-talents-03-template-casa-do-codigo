package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String nome;

	
	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	
	public Pais(String nome) {
		
		this.nome = nome;
	}
	
	@Deprecated
	public Pais() {
	
	}


	
}
