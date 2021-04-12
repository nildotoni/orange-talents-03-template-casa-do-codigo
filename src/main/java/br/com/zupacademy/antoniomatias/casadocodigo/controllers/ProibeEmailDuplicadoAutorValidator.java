package br.com.zupacademy.antoniomatias.casadocodigo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.antoniomatias.casadocodigo.model.Autor;
import br.com.zupacademy.antoniomatias.casadocodigo.model.AutorForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		AutorForm form = (AutorForm) target;
		
		Optional<Autor> possivelAutor = autorRepository.findByEmail(form.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null,
					"Esse e-mail já está cadastrado, por favor informe outro "
					+ form.getEmail());
		}
	}

	
}
