package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Estado;
import br.com.zupacademy.antoniomatias.casadocodigo.model.EstadoForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.PaisRepository;

@RestController
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("/cadastraEstado")
	private ResponseEntity<Estado> cadastraEstado(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder){
	Estado estado = form.converte(paisRepository, estadoRepository);
	if(estado == null) {
		return ResponseEntity.notFound().build();
	}
	
	estadoRepository.save(estado);
	URI uri = uriBuilder.path("/cadastraEstado/{id}").buildAndExpand(estado.getId()).toUri();
	return ResponseEntity.created(uri).body(estado);
}
}
