package br.com.zupacademy.antoniomatias.casadocodigo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME; //precisei por na mão
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD; //precisei por na mão
import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;
//1
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {

	String message() default "{br.com.zupacademy.antoniomatias.casadocodigo.validators.UniqueValue}";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{ };
	
	String fieldName();
	
	Class<?> domainClass();
}
