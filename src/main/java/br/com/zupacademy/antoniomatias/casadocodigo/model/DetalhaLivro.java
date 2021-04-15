package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.util.Optional;

import br.com.zupacademy.antoniomatias.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.LivroRepository;

//2
public class DetalhaLivro {
	//1
	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer paginas;
	private Long isbn;
	private String autor;
	private String descricaoAutor;

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
	public String getAutor() {
		return autor;
	}
	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	
	public DetalhaLivro(Livro livro,
			Autor autor) {
		
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.autor = autor.getNome();
		this.descricaoAutor = autor.getDescricao();
	}

	
	public static DetalhaLivro converte(LivroRepository livroRepository, AutorRepository autorRepository, Long id) {
		Optional<Livro> getLivro = livroRepository.findById(id);
		if (getLivro.isPresent()) {
			Livro livro = getLivro.get();
			Optional<Autor> autor = autorRepository.findById(livro.getAutor().getId());
			
			return new DetalhaLivro(livro ,autor.get());
		}
		
		
		return null;
	}
		
}
