package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Usuario;
import br.com.zupacademy.antoniomatias.casadocodigo.model.UsuarioForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository uR;
	@Autowired
	private PaisRepository pR;
	@Autowired
	private EstadoRepository eR;
	
	@PostMapping("/cadastroUsuario")
	public ResponseEntity<?> cadastraUsuario(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.convert(pR,eR);		
		if(usuario == null) {
			return ResponseEntity.badRequest().body("Estado informado é inválido");
		}
		uR.save(usuario);
		URI uri = uriBuilder.path("/cadastroUsuario/{id}").buildAndExpand(usuario.getId()).toUri();
		//return ResponseEntity.created(uri).body("Usuário Cadastrado");
		return ResponseEntity.created(uri).body("Usuario Cadastrado");
	}
	
}
