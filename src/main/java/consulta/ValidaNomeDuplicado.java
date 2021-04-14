package consulta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.antoniomatias.casadocodigo.model.AutorForm;
import br.com.zupacademy.antoniomatias.casadocodigo.model.Categoria;
import br.com.zupacademy.antoniomatias.casadocodigo.model.CategoriaForm;
import br.com.zupacademy.antoniomatias.casadocodigo.repository.CategoriaRepository;
//3
@Component
public class ValidaNomeDuplicado implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		//1
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//1
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm form = (CategoriaForm) target;
		
		Optional<Categoria> validaCategoria = categoriaRepository.findByNome(form.getNome()); 
		
		if(validaCategoria.isPresent()) {
			//1
			errors.rejectValue("nome", null, "Categoria já existente "
					+ form.getNome());
		}
	}

}
