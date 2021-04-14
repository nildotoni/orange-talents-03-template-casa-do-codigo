package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue;

//2
public class LivroForm {
	
	//1
	@NotNull(message = "Favor preencher o título") 
	@NotEmpty(message = "Favor preencher o título")
	@UniqueValue(domainClass=Livro.class, fieldName = "titulo",message = "Título já cadastrado")
	private String titulo;
	
	@NotNull(message = "Favor preencher o resumo")
	@NotEmpty(message = "Favor preencher o resumo")
	@Column(columnDefinition ="TEXT")
	@Size(min = 3, max = 500, message = "Coloque um resumo de até 500 Caracteres")
	private String resumo;
	
	@Column(columnDefinition ="TEXT")
	private String sumario;

	@NotNull(message = "Favor preencher o Preço")
	@DecimalMin(value = "20.00", message="O Preço minimo é de 20")
	private Double preco;
	
	@Min ( value=100, message ="Número de páginas minimo é 100")
	@NotNull(message = "Favor preencher a quantidade de páginas")
	private Integer paginas;
	
	@NotNull(message = "Favor preencher o Isbn")
	@UniqueValue(domainClass=Livro.class, fieldName = "isbn",message = "Isbn já cadastrado")
	private Long isbn;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Future(message="Digite uma data válida para lançamento")
	@NotNull(message = "Favor preencher a data para lançamento")
	private LocalDate datalancamento;
	
	private Long categoria_id;
	
	private Long autor_id;

	//Getters
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public Long getIsbn() {
		return isbn;
	}

	public LocalDate getDatalancamento() {
		return datalancamento;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public Long getAutor_id() {
		return autor_id; 
	}

	
	//Métodos
	//1
	public Livro converter(LivroRepository livroRepository,CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		//1
		
		System.out.println("Autor_ID: " + autor_id + " categoria_id " + categoria_id);
		Optional<Categoria> categoriaId = categoriaRepository.findById(categoria_id);
		Optional<Autor> autorId = autorRepository.findById(autor_id);
		
		Autor autor = autorId.get();
		System.out.println("Autor : " + autor.getNome());
		

		Categoria categoria = categoriaId.get();
		System.out.println("Categoria : " + categoria.getNome());
		
		Livro livro = new Livro(titulo, resumo, sumario, preco, paginas, isbn, datalancamento, categoria, autor );
		
		return livro;
	}
	
	
	
}
