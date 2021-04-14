package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.zupacademy.antoniomatias.casadocodigo.model.ListaLivros;
import br.com.zupacademy.antoniomatias.casadocodigo.model.Livro;
import br.com.zupacademy.antoniomatias.casadocodigo.model.LivroForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.LivroRepository;

@RestController
//2
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping("/cadastraLivro")
	public ResponseEntity<Livro> cadastraLivro(@RequestBody @Valid LivroForm form, UriComponentsBuilder uriBuilder) {
		//1
		System.out.println(form.getAutor_id());
		Livro livro = form.converter(livroRepository, categoriaRepository, autorRepository);
		if(livro == null) {
			return ResponseEntity.badRequest().build();
		}
		livroRepository.save(livro);
		URI uri = uriBuilder.path("/cadastraLivro/${id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}
	
	//1
	@GetMapping("/livros")
	public List<ListaLivros> listaLivros(){
		//1
		List<Livro> livros = (List<Livro>) livroRepository.findAll();
				
		return ListaLivros.converte(livros);
	}
	
}