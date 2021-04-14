package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//2
@Entity
public class Autor {
	//1
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String email;
	@Column(columnDefinition ="TEXT")
	private String descricao;
	@NotNull
	private LocalDateTime datacadastro = LocalDateTime.now();
	
	@Deprecated //indicar que somente o spring usa esse construtor default
	public Autor() {
		
	}
	
	public Autor(String nome, String email, String descricao) {
		//1
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public Autor(Autor autor) {
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getDatacadastro() {
		return datacadastro;
	}
	
	
	
}
