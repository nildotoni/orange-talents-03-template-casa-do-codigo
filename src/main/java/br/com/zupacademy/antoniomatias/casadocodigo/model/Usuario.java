package br.com.zupacademy.antoniomatias.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	private String sobrenome;
	
	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String documento;

	@NotNull
	@NotEmpty
	private String endereco;
	
	@NotNull
	@NotEmpty
	private String complemento;

	@NotNull
	@NotEmpty
	private String cidade;
	@ManyToOne
	private Estado estado;

	@ManyToOne
	private Pais pais;

	@NotNull
	private Long telefone;

	@NotNull
	private Long cep;

	
	
	
	public Usuario(String nome, String sobrenome,
			String email, Long telefone,
			String complemento, String cidade, Long cep,
			String endereco, String documento, Estado estado, Pais pais) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		
		this.telefone = telefone;
		this.cep = cep;
		this.estado = estado;
		this.pais = pais;
	}
	
	@Deprecated
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public Pais getPais() {
		return pais;
	}

	public Long getTelefone() {
		return telefone;
	}

	public Long getCep() {
		return cep;
	}
	
	
	
}
