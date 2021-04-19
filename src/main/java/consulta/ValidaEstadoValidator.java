package consulta;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaEstadoValidator implements ConstraintValidator<ValidaEstado, Object>{

	private String paisId;
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public void initialize(ValidaEstado params) {
	paisId = params.paisId();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select e from estados e where pais_id = "+ paisId);
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Iterable<?> lista = query.getResultList();
		if(list.isEmpty()) {
			return true;
		}
		for (Object e : lista) {
			System.out.println(e.getClass().getName());

		
		}
		return false;
	}

}
