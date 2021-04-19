package br.com.zupacademy.antoniomatias.casadocodigo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaDocValidator implements ConstraintValidator<ValidaDoc,String>{

	
	
	@Override
	public boolean isValid(String documento, ConstraintValidatorContext context) {
		System.out.println(documento.length());
		if(documento.length() == 11) {
			Boolean calculo = CalculoCpf.calculaCPF(documento);
			System.out.println("calculo cpf "  + documento+ " "+  calculo);
			return calculo;
		} else if(documento.length()==14) {
			Boolean calculo = CalculoCnpj.calculaCnpj(documento);
			System.out.println("calculo cnpj do cnpj " + documento+ " " + calculo);
			return calculo;
		}
		return false;
	}

}
