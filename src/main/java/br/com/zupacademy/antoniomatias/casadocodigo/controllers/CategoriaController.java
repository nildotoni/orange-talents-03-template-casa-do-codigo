package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Categoria;
import br.com.zupacademy.antoniomatias.casadocodigo.model.CategoriaForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.CategoriaRepository;

@RestController
//1
public class CategoriaController {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/* Para Consulta
	 * @Autowired private ValidaNomeDuplicado validaNomeDuplicado;
	 * 
	 * @InitBinder public void init(WebDataBinder binder) { //1
	 * binder.addValidators(validaNomeDuplicado);
	 * 
	 * }
	 */
	
	@PostMapping("/cadastraCategoria")
	public ResponseEntity<Categoria> cadastraCategoria(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder){
		//1
		Categoria categoria = form.converter(categoriaRepository);
		URI uri = uriBuilder.path("/cadastraCategoria/${id}").buildAndExpand(categoria.getId()).toUri();
		categoriaRepository.save(categoria);
		return ResponseEntity.created(uri).body(categoria);
		
	}
	
}
