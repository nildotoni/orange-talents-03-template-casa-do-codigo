package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue;
//2
@Entity
public class Livro {
	//1
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Favor preencher o título") 
	@NotEmpty(message = "Favor preencher o título")
	private String titulo;
	
	@NotNull(message = "Favor preencher o resumo")
	@NotEmpty(message = "Favor preencher o resumo")
	@Column(columnDefinition ="TEXT")
	@Size(min = 3, max = 500, message = "Coloque um resumo de até 500 Caracteres")
	private String resumo;
	
	@Column(columnDefinition ="TEXT")
	private String sumario;

	@NotNull(message = "Favor preencher o Preço")
	@DecimalMin(value= "20.0", message="Preço minimo é 20")
	private Double preco;
	
	@Min(value = 100, message ="Número de páginas minimo é 100")
	@NotNull(message = "Favor preencher a quantidade de páginas")
	private Integer paginas;
	
	@NotNull(message = "Favor preencher o Isbn")
	private Long isbn;
	
	@Future(message="Digite uma data válida para lançamento")
	@NotNull(message = "Favor preencher a data para lançamento")
	private LocalDate datalancamento;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;

	
	
	public Livro(String titulo,String resumo,String sumario, Double preco,Integer paginas, 
			Long isbn2, LocalDate datalancamento, Categoria categoria, Autor autor) {
		//1
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn2;
		this.datalancamento = datalancamento;
		
		this.categoria = categoria;
		this.autor = autor;
	}


	//Uso interno do Spring
	@Deprecated
	public Livro() {}


	//Getters
	public Long getId() {
		return id;
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
	
	
	
}
