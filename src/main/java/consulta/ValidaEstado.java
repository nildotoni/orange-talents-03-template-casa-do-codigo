package consulta;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME; //precisei por na mão
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD; //precisei por na mão
import javax.validation.Constraint;
import javax.validation.Payload;
//1
@Documented
@Constraint(validatedBy = {ValidaEstadoValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ValidaEstado {

	String message() default "{br.com.zupacademy.antoniomatias.casadocodigo.validators.ValidaEstado}";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{ };
	

	String paisId();
}
