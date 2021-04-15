package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Pais;
import br.com.zupacademy.antoniomatias.casadocodigo.model.PaisForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.PaisRepository;

@RestController
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("/cadastraPais")
	public ResponseEntity<Pais> cadastraPais(@RequestBody @Valid PaisForm form, UriComponentsBuilder uriBuilder){
		Pais pais = form.converter(paisRepository);
		paisRepository.save(pais);
		URI uri = uriBuilder.path("/cadastraPais/{id}").buildAndExpand(pais.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pais);
	}
	
}
