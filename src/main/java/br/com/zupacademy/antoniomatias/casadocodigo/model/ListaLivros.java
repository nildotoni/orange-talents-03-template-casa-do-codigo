package br.com.zupacademy.antoniomatias.casadocodigo.model;

import java.util.List;
import java.util.stream.Collectors;

//1
public class ListaLivros {

	private Long id;
	private String titulo;
	
	
	
	public ListaLivros(Livro livro) {
	
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public static List<ListaLivros> converte(List<Livro> livros) {
	//1	
		return livros.stream().map(ListaLivros::new).collect(Collectors.toList());
	}
		
}
