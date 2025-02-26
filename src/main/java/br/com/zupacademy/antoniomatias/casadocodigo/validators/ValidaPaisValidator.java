package br.com.zupacademy.antoniomatias.casadocodigo.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidaPaisValidator implements ConstraintValidator<ValidaPais, Object>{

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public void initialize(ValidaPais params) {
	domainAttribute = params.fieldName();
	klass = params.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " +klass.getName()+" where " +domainAttribute+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		if(list.size()<= 0) {
			return false;
		}
		return true ;
	}

}
