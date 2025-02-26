package br.com.zupacademy.antoniomatias.casadocodigo.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//1
@Documented
@Constraint(validatedBy = {ValidaPaisValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ValidaPais {
	
	String message() default "{br.com.zupacademy.antoniomatias.casadocodigo.validators.ValidaDoc}";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{ };
	
	String fieldName();
	
	Class<?> domainClass();
}
