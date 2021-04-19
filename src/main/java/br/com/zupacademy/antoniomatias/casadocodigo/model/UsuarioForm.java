package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.util.Collection;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.ValidaDoc;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.ValidaPais;

public class UsuarioForm {

	@NotNull(message = "O Nome não pode ser nulo")
	@NotEmpty(message = "O Nome não pode ser vazio")
	private String nome;

	@NotNull(message = "O Sobrenome não pode ser nulo")
	@NotEmpty(message = "O Sobrenome não pode ser vazio")
	private String sobrenome;

	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Email(message = "Digite um email válido")
	@UniqueValue(domainClass = Usuario.class, fieldName = "email")
	private String email;
	
	@ValidaDoc
	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	@UniqueValue(domainClass = Usuario.class, fieldName = "documento")
	private String documento;

	@NotNull(message = "O endereço não pode ser nulo")
	@NotEmpty(message = "O endereço não pode ser vazio")
	private String endereco;

	@NotNull(message = "O complemento não pode ser nulo")
	@NotEmpty(message = "O complemento não pode ser vazio")
	private String complemento;

	@NotNull(message = "A cidade não pode ser nula")
	@NotEmpty(message = "A cidade não pode ser vazia")
	private String cidade;

	
	private Long estado_id;

	// (message = "A cidade não pode ser nula")
	@ValidaPais(domainClass = Pais.class, fieldName = "id")
	private Long pais_id;

	@NotNull(message = "A cidade não pode ser nula")
	private Long telefone;

	@NotNull(message = "A cidade não pode ser nula")
	private Long cep;

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

	public Long getEstado_id() {
		return estado_id;
	}

	public Long getPais_id() {
		return pais_id;
	}

	public Long getTelefone() {
		return telefone;
	}

	public Long getCep() {
		return cep;
	}

	public Usuario convert(PaisRepository pR, EstadoRepository eR) {
		Optional<Pais> pais = pR.findById(pais_id);
		Collection<Estado> estado = eR.findByPaisId(pais_id);
		if(estado.isEmpty()) {
			return new Usuario(nome, sobrenome, email, telefone, complemento, cidade, cep, endereco, documento, null,
					pais.get());
		}
		for (Estado e : estado) {
			if (e.getId() == estado_id && e.getPais().getId() == pais_id) {
				System.out.println(e.getNome() + " " + pais.get().getNome());
				Estado novoEstado = e;
				return new Usuario(nome, sobrenome, email, telefone, complemento, cidade, cep, endereco, documento,
						novoEstado, pais.get());
			} 

		
		}

		return null;

	}

}
