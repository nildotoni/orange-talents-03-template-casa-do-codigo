package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Autor;
import br.com.zupacademy.antoniomatias.casadocodigo.model.AutorForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
//1
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	/* Para consulta
	 * @Autowired private ProibeEmailDuplicadoAutorValidator
	 * proibeEmailDuplicadoAutorValidator;
	 * 
	 * @InitBinder public void init(WebDataBinder binder) { //1
	 * binder.addValidators(proibeEmailDuplicadoAutorValidator);
	 * 
	 * }
	 */
	
	//cadastra Autor
	@PostMapping
	public ResponseEntity<Autor> cadastroAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
		//1
		
		Autor autor = autorForm.convert(autorRepository);
		autorRepository.save(autor);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(autor);
	}
}

